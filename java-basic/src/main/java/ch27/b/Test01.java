//l 클래스(또는 인터페이스)이름 알아내기
package ch27.b;
public class Test01 {

  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = Calculator.class;
    
    System.out.println(clazz.getName()); //l 패키지명을 포함한 클래스명
    System.out.println(clazz.getCanonicalName()); //l 패키지명을 포함한 클래스명
    System.out.println(clazz.getSimpleName()); //l 패키지명을 제외한 클래스명

  }

}
