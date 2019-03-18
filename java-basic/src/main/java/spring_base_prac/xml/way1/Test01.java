package spring_base_prac.xml.way1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("spring_base_prac/xml/way1/application-context.xml");
    
    String[] beans = iocContainer.getBeanDefinitionNames();
    for (String bean : beans) {
      System.out.println(bean);
    }
    
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    
    Pizza p1 = (Pizza) iocContainer.getBean("p1");
    System.out.println(p1);
    
    Topping t1 = (Topping) iocContainer.getBean("t1");
    System.out.println(t1);
    

    
    

  }
}
