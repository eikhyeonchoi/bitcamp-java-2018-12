// StringBuffer 클래스 사용법
package ch11;

public class Test07 {
  public static void main(String[] args) {
    
    StringBuffer b1 = new StringBuffer("hello");
    
    // StringBuffer는 mutable 객체이다. 내부의 문자열을 변경할 수 있다
    StringBuffer b2 = b1.replace(2, 4, "xxxxx");
    
    System.out.println(b1 == b2);
    System.out.println(b1.toString());
    
    System.out.println(b1); // 파라미터에 넘겨주는 값이 String이 아닐 경우
                            // println() 메서드가 내부에서 해당 값에 대해 toString()을 
                                // 호출하여 그 리턴값 String을 출력한다
    
    // 만약 해당 클래스에 toString() 메서드가 없다면????
    // ==> 자바의 모든 클래스에는 toString()이 있다
    // ==> 왜? 자바의 모든 클래스는 Object 클래스를 상속받는다
    // ==> Object클래스에 toString()이 정의되어 있다.
    
    
    
    
    
  }
}