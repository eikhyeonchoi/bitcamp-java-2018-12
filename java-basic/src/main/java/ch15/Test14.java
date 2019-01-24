// Object 클래스 : 주요 메서드 - getClass()와 배열의 항목이름
package ch15;

public class Test14 {
  public static void main(String[] args) {
    
    // 배열의 클래스 정보
    String[] obj2 = new String[10];
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //   [Ljava.lang.String;
    
    
    // 배열 항목의 타입 정보를 가져옴
    Class compTypeInfo = classInfo.getComponentType();
    System.out.println(compTypeInfo.getName()); // java.lang.String
    
    // 값을 한 번 밖에 사용하지 않을 것이라면
    // 아래 처럼 체인방식으로 호출
   System.out.println(obj2.getClass().getComponentType().getName());
    
    
  }
}
