package ch09;

public class Calculator3 {
  
  // 클래스에서 공통으로 관리하지 않고 
  // 개별적으로 관리해야 할 값이 있다면 인스턴스 필드로 선언하라
  int result = 0; // 인스턴스필드(논-스태틱필드)
  
  static void plus(Calculator3 that, int a) {
    // result가 더이상 클래스 필드가 아니기 때문에 다음과 같이 사용할 수 없다
    // result += a;
    
    // 파라미터 that에 들어 있는 주소로 찾아서 그 인스턴스의 result필드를 사용한다
    that.result += a;
  }

  static void minus(Calculator3 that, int a) {
    // result가 더이상 클래스 필드가 아니기 때문에 다음과 같이 사용할 수 없다
    // result -= a;
    
    that.result -=  a; // 이렇게 reuslt 변수가 있는 인스턴스 주소를 사용해 계산을 수행
  }

  static void multiple(Calculator3 that, int a) {
    // result가 더이상 클래스 필드가 아니기 때문에 다음과 같이 사용할 수 없다
    // result *= a;
    
    that.result *=  a;
  }

  static void divide(Calculator3 that, int a) {
    // result가 더이상 클래스 필드가 아니기 때문에 다음과 같이 사용할 수 없다
    // result /= a;
    
    that.result /=  a;
  }
  
  
}
