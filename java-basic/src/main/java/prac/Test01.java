package prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    String[] beans = iocContainer.getBeanDefinitionNames();
    for(String bean : beans) {
      System.out.println(bean);
    }
    
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    Car car = (Car) iocContainer.getBean("car");
    System.out.println(car);
    
    Navigation navigation = (Navigation) iocContainer.getBean("navigation");
    System.out.println(navigation);
    
    
    
    
    
    
  }
}
