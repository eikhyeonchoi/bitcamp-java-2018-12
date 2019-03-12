//l reflection API - 인스턴스 생성하기
package ch27.c;
import java.lang.reflect.Constructor;

public class Test01 {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    
    //Class<?> clazz = Student.class;
    Class<?> clazz = Class.forName("ch27.c.Student");
    
    //l 클래스 정보를 가지고 인스턴스 생성(deprecated)
    //l ==> 기본생성자가 있을 때만 가능
    Student s1 = (Student) clazz.newInstance();
    
    //l 생성자를 통한 인스턴스 생성
    //l ==> 기본생성자 꺼내기
    Constructor<Student> c1 = (Constructor<Student>) clazz.getConstructor();
    Student s2 =  c1.newInstance();

    //l ==> 파라미터가 있는 생성자 꺼내기
    Constructor<Student> c2 = (Constructor<Student>) clazz.getConstructor(
        String.class, String.class);
    
    Student s3 = c2.newInstance("홍길동","hong@test.com");
    System.out.println(s3);
    
    
    
    
    
    
  }
}
