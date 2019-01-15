// 생성자 - 여러개의 생성자
package ch10;

class Monitor9{
  int bright; // 밝기 0 ~ 100
  int contrast = 50; // 명암 0 ~ 100
  int widthRes; // 해상도 너비
  int heightRes = 1080; // 해상도 높이
  
  // 여러 개의 생성자를 지정할 수 있다 
  Monitor9() {
    this.bright = 50;
    this.contrast = 70; 
    this.widthRes = 2560; 
    this.heightRes = 1200; 
    System.out.println("Monitor9()");
    
  }
  
  Monitor9(int b, int c) {
    this.bright = b;
    this.contrast = c;
    System.out.println("Monitor9(int, int)");
  }
  
  Monitor9(int b, int c, int w, int h) {
    this.bright = b;
    this.contrast = c;
    this.widthRes = w;
    this.heightRes = h;
    System.out.println("Monitor9(int, int, int, int)");
  }
  
  public void on() {
    // 모니터를 켜면 bright contrast widthRes heightRes 값에 맞춰
    // 화면에 불을 밝힌다
    System.out.println("화면을 출력한다");
  }
}

public class Test11 {
  public static void main(String[] args) {

    // 생성자를 지정할 때 파라미터의 값에 따라 결정된다
    new Monitor9(); // 기본 생성자를 지정한다
    new Monitor9(50, 50); // Monitor9(int, int) 생성자를 지정한다
    new Monitor9(50,50,1920,1080); //Monitor9(int, int, int, int) 생성자를 지정
    
    // 파라미터 타입이나 개수가 일치하지 않는 생성자는 호출할 수 없다
    // new Monitor9(50); compile error
    
  }
}
