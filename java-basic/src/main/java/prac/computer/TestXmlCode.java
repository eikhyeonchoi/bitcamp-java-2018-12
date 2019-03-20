package prac.computer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlCode {
  public static void main(String[] args) {
    
    ApplicationContext appCtx = 
        new ClassPathXmlApplicationContext("prac/computer/application-context.xml");
    
    
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    String[] coms = appCtx.getBeanDefinitionNames();
    for(String com : coms) {
      System.out.printf("%s ==> %s\n", com, appCtx.getBean(com).getClass().getName());
    }
    
    
    
    
  }
}
