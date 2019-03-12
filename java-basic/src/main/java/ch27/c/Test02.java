//l reflection API - 인스턴스 생성하기
package ch27.c;
import java.lang.reflect.Method;

public class Test02 {

  public static void main(String[] args) throws Exception {
    
    Student s1 = new Student("홍길동", "hong@test.com", true, 25);

    //l 인스턴스 메서드 호출하기
    //l ==> setName()
    Method m1 = s1.getClass().getMethod("setName", String.class);
//    Method m1 = Student.class.getMethod("setName", String.class);
//    Method m1 = Class.forName("ch27.c.Studenr").getMethod("setName", String.class);
    
    //l ==> invoke(객체주소, 파라미터값, ...)
    m1.invoke(s1, "임꺽정"); // = s1.setName("임꺽정")
    System.out.println(s1);
    
    Method m2 = s1.getClass().getMethod(
        "greeting", String.class, int.class, boolean.class);
    System.out.println(m2.invoke(null, "최익현", 26, true));
    
  }
}
