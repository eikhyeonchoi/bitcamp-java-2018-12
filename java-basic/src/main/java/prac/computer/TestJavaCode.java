package prac.computer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestJavaCode {
  public static void main(String[] args) {
    
    ApplicationContext appCtx = 
        new AnnotationConfigApplicationContext(AppConfig2.class);
    
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    String[] coms = appCtx.getBeanDefinitionNames();
    for(String com : coms) {
      System.out.printf("%s ==> %s\n", com, appCtx.getBean(com).getClass().getName());
    }
    
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    System.out.println(appCtx.getBean("computer"));
    

  }
}
