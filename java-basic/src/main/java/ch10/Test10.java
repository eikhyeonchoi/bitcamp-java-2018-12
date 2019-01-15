// 생성자 - 기본 생성자 default constructor 2
package ch10;

class Monitor8{
  int bright; // 밝기 0 ~ 100
  int contrast = 50; // 명암 0 ~ 100
  int widthRes; // 해상도 너비
  int heightRes = 1080; // 해상도 높이
  
  // 만약 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 추가하지 않음
  public Monitor8(int b, int c) {
    this.bright = b;
    this.contrast = c;
  }
  
  public void on() {
    // 모니터를 켜면 bright contrast widthRes heightRes 값에 맞춰
    // 화면에 불을 밝힌다
    System.out.println("화면을 출력한다");
  }
}

public class Test10 {
  public static void main(String[] args) {
    
    // 기본생성자가 없는 경우 다음과 같이 기본 생성자를 호출할 수 없다
    // new Monitor8(); 
    
    // 존재하는 생성자를 지정해야하고, 그 생성자의 파라미터에 맞춰 값을 넘겨야한다
    // ==> Monitor8 설계도에 따라 인스턴스를 생성한 후, int 값 2개 받는 생성자를 호출하라는 의미
    new Monitor8(50, 50);
    
    
    
    
    
    
  }
}
