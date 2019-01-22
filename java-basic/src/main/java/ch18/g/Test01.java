package ch18.g;

public class Test01 {
  public static void main(String[] args) {
    
    // 인터페이스에 선언한 필드는 public static final 이기 때문에 바로 사용가능
    System.out.println(A.V1); // static이라 바로 사용가능 클래스이름.변수
    System.out.println(A.V2);
    
    // A.V2 = 300; final 이라 변경 불가능
  }

}
