package com.eomcs.lms.context;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ApplicationContext {

  ArrayList<Class<?>> classes = new ArrayList<>();

  //l 생성한 인스턴스를 보관하는 저장소
  HashMap<String, Object> beanContainer = new HashMap<String, Object>();


  public ApplicationContext(String packageName, Map<String, Object> beans) throws Exception {
    //l 외부에서 생성한 인스턴스가 파라미터로 넘어온다면, 저장소에 보관한다
    if(beans != null && beans.size() > 0) {
      Set<String> names = beans.keySet();
      for(String name : names) {
        addBean(name, beans.get(name));
      }
    }

    //l 1) 패키지명으로 디렉토리 경로를 알아낸다
    File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));

    //l 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 클래스 이름을 알아냄
    //l    ==> 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외 + 중첩클래스 제외
    findClasses(packageDir, packageName);
    System.out.println(packageDir);
    System.out.println(packageName);

    //l 3) Component 애노테이션 클래스만 찾아서 인스턴스를 생성한다
    prepareComponent();

    //l 4) 인스턴스 생성을 완료한 후 작업을 수행
    postProcess();
    
    System.out.println("------------------------------------------");
    //l 저장소에 보관된 객체의 이름과 클래스명을 출력한다
    Set<String> names = beanContainer.keySet();
    for(String name : names) {
      System.out.printf("%s : %s \n",
          name, beanContainer.get(name).getClass().getSimpleName());
    }

  }

  //l 인스턴스를 추가할 때 호출
  //l bean == 인스턴스 == 객체
  private void addBean(String name, Object bean) {
    if(name == null || name.length() == 0 || bean == null)
      return ;
    beanContainer.put(name, bean);
  }

  //l 저장소에 보관된 인스턴스를 꺼낸다
  public Object getBean(String name) {
    return beanContainer.get(name);
  }


  private void findClasses(File dir, String packageName) throws Exception {
    //l 디렉토리를 뒤져서 클래스파일(.class)이나 하위 디렉토리 목록을 알아낸다
    File[] files = dir.listFiles((File pathname) -> {
      if(pathname.isDirectory())
        return true;

      if(pathname.getName().endsWith(".class") && // 자바 클래스파일
          !pathname.getName().contains("$"))  // 증첩 클래스가 아닌 경우
        return true;

      return false;
    });

    for(File f : files) {
      if(f.isFile()) {
        //l 클래스 파일일 경우,
        //l ==> 파라미터로 받은 패키지명과 파일 이름을 합쳐 클래스 이름을 만든다
        //l     ex) com.eomcs.lms(package) + . + ServerApp = com.eomcs.lms.ServerApp
        String filename = f.getName();
        String className = packageName + "." + 
            filename.substring(0, filename.indexOf('.'));

        //l ==> 클래스 이름으로 클래스파일(.class)를 로딩한다
        Class<?> clazz = Class.forName(className);
        // BoardAddCommand.class;

        //l ==> 클래스 정보를 분석해 중첩 클래스이거나 인터페이스이거나 Enum이면 무시한다
        if(clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum()) 
          continue;

        //l ==> 추상 클래스나 public이 아닌 클래스 무시
        if(Modifier.isAbstract(clazz.getModifiers()) ||
            !Modifier.isPublic(clazz.getModifiers())) 
          continue;

        //l 즉 public인 일반 클래스인 경우 클래스 관리 목록에 추가
        classes.add(clazz);

      } else {
        //l 디렉토리 일경우, 그 하위 디렉토리에서 다시 클래스를 찾음
        //l ==> 하위 디렉토리에서 클래스를 찾을 때 사용할 패키지명을 준비한다
        //l ==> 파라미터로 받은 패키지 이름에 하위 디렉토리 이름을 붙이면 전체 패키지명이 된다
        //l ==> com.eomcs.lms(현재 패키지이름) + . + dao(디렉토리 이름) = com.eomcs.lms.dao
        findClasses(f, packageName + "." + f.getName());
      }
    } // for
  } // findClasses()


  private void prepareComponent() throws Exception {
    for(Class<?> clazz : classes) {
      //l 클래스 Component 애노테이션 정보를 추출한다
      Component compAnno = clazz.getAnnotation(Component.class);

      if(compAnno == null) 
        continue;
      
      //l Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성한다
      Object obj = createInstance(clazz);
      
      if(obj != null) { // 제대로 생성했다면, beanContainer에 저장한다
        //l beanContainer에 객체를 저장할 때, key는 Component는 value 값를 사용
        //l 만약 value가 빈 문자열이라면 클래스이름을 사용한다
        //l ==> 클래스에서 getName() 메서드를 알아낸다
        addBean( //l getName()을 호출해 리턴 값을 key로 사용한다
            compAnno.value().length() > 0 ? compAnno.value() : clazz.getName(),
            obj);
      }
    } // for
  } // prepareCommand


  private Object createInstance(Class<?> clazz) throws Exception{
    //l 파라미터로 주어진 클래스 정보를 가지고 인스턴스를 생성한다
    //l ==> 기본 생성자를 알아낸다
    try {
      Constructor<?> defaultConstructor = clazz.getConstructor();
      return defaultConstructor.newInstance();
    } catch(Exception e) {
    }

    //l ==> 기본 생성자가 없다면, 다른생성자 목록을 얻는다
    Constructor<?>[] constructors = clazz.getConstructors();
    for(Constructor<?> c : constructors) {
      //l ==> 생성자를 호출하려면 먼저 어떤 타입의 파라미터가 필요한지 알아야함
      Class<?>[] paramTypes = c.getParameterTypes();


      //l ==> 생성자가 요규하는 타입의 파라미터 값이 저장소에 있는지 찾아본다
      Object[] paramValues = getParameterValues(paramTypes);
      if(paramValues != null) { //l 생성자가 요구하는 모든 파라미터 값을 찾았다면
        //l 생성자를 통해 인스턴스를 생성해 return
        return c.newInstance(paramValues);

      }
    }
    return null;

  } // createInstance

  private Object[] getParameterValues(Class<?>[] paramTypes) {
    //l 파라미터 타입에 해당하는 객체를 beanContiner에서 찾아 배열만들어 return
    ArrayList<Object> values = new ArrayList<Object>();

    for(Class<?> type : paramTypes) {
      Object value = findBean(type);

      if(value != null) {
        values.add(value);
      }
    }
    if(values.size() == paramTypes.length)
      //l 파라미터의 타입 목록에 지정된 값을 모두 찾았으면 배열로 retrun 못찾으면 return null
      return values.toArray();
    else
      return null;
  }

  private Object findBean(Class<?> type) {
    //l 빈컨테이너에서 특정 타입의 인스턴스를 찾기
    //l ==> 먼저 빈 컨테이너에서 인스턴스 목록을 꺼낸다
    Collection<Object> beans = beanContainer.values();
    for(Object bean : beans) {
      if(type.isInstance(bean)) 
        return bean;
    }
    return null;
  }

  //l bean생성을 완료한 후 작업 수행
  public void postProcess() {
    //l RequestMappingHandler 정보를 관리할 객체 생성
    RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
    
    //l 빈컨테이너에서 객체를 모두 꺼낸다
    Collection<Object> beans = beanContainer.values();
    
    for(Object bean : beans) {
      //l 각 객체의 대해 @RequestMapping 메서드를 찾는다
      Method[] methods = bean.getClass().getMethods();
      for(Method m : methods) {
        RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
        if(requestMapping == null)
          continue;
        
        //l RequestMapping이 붙은 메서드를 찾았으면 그 정보를 RequestMappingHandler에 담는다
        RequestMappingHandler handler = new RequestMappingHandler(bean, m);
        
        //l 그리고 이 요청 핸들러(RequestMapping 애노테이션이 붙은 메서드)를 저장한다
        handlerMapping.add(requestMapping.value(), handler);
      } // for(Method)
    } // for(Object)
    
    //l ServerApp에서 꺼낼 수 있도록 RequestMappingHandlerMapping객체를 beanContainer에 저장
    beanContainer.put("handlerMapping", handlerMapping);
  } // postProcess
  
  

} // end of class

