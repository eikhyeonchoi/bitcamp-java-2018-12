package spring_base_prac.java.way1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    Pizza pz = (Pizza) iocContainer.getBean("pizza");
    System.out.println(pz);
    
    String[] beans = iocContainer.getBeanDefinitionNames();
    for (String bean : beans) {
      System.out.println(bean);
    }
    
    
    
  }
}
