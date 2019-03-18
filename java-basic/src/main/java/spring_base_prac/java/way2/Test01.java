package spring_base_prac.java.way2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);


    String[] beans = iocContainer.getBeanDefinitionNames();
    for (String bean : beans) {
      System.out.println(bean);
    }
    
    Pizza p = (Pizza) iocContainer.getBean("pizza");
    System.out.println(p);
    
    Topping t = (Topping) iocContainer.getBean("topping");
    System.out.println(t);


  }
}
