//l reflection API - 클래스가 상속받은 수퍼클래스 알아내기
package ch27.b;

public class Test09 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;
    
    Class<?> superClass = clazz.getSuperclass();
    System.out.println(superClass.getName());
    
    
    
    
  } // main
} // end of class
