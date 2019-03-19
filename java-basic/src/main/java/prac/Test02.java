package prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {

    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("prac/application-context.xml");

    String[] beans = iocContainer.getBeanDefinitionNames();
    for(String bean : beans) {
      System.out.println(bean);
    }

    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

    try {
      Car car1 = (Car) iocContainer.getBean("car1");
      System.out.println(car1);
    } catch(Exception e) {
      System.out.println("값을 치환할 수 없습니다 에디터를 사용해야합니다");
    }

    Car car2 = (Car) iocContainer.getBean("car2");
    System.out.println(car2);    




  }
}
