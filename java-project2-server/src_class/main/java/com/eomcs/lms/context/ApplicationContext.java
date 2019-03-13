package com.eomcs.lms.context;
import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import com.eomcs.lms.handler.Command;

public class ApplicationContext {

  ArrayList<Class<?>> classes = new ArrayList<>();
  
  //l 생성한 인스턴스를 보관하는 저장소
  HashMap<String, Object> beans = new HashMap<String, Object>();

  public ApplicationContext(String packageName) throws Exception {
    //l 1) 패키지명으로 디렉토리 경로를 알아낸다
    File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/"));

    //l 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 클래스 이름을 알아냄
    //l    ==> 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외 + 중첩클래스 제외
    findClasses(packageDir, packageName);
    System.out.println(packageDir);
    System.out.println(packageName);

    //l 3) Command 인터페이스를 구현한 클래스만 찾아서 인스턴스를 생성한다
    prepareCommand();

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


  private void prepareCommand() throws Exception {
    for(Class<?> clazz : classes) {
      //l 클래스 또는 조상 클래스가 구현한 인터페이스 목록을 거낸다
      List<Class<?>> interfaces = getAllInterfaces(clazz);

      for(Class<?> i : interfaces) {
        if(i == Command.class) {
          System.out.println(clazz.getName());
          break;
        }
      } // for
    } // for

  } // prepareCommand

  
  @SuppressWarnings("unused")
  private List<Class<?>> getAllInterfaces(Class<?> clazz){
    ArrayList<Class<?>> list = new ArrayList<Class<?>>();

    while(clazz != Object.class) {
      Class<?> [] interfaces = clazz.getInterfaces();

      for(Class<?> i : interfaces)
        list.add(i);

      clazz = clazz.getSuperclass();
    }

    return list;
  } // getAllInterfaces


} // end of class

