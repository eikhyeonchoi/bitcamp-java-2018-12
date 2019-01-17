package ch13.f;

// 수퍼 클래스를 지정하지 않으면 무조건 무조건 무조건 무조건 자동으로 java.lang.Object 상속받는다
public class A {
  private int v1 = 100;
  
  public A() {
    // 생성자를 정의할 때 반드시 수퍼 클래스의 어떤 생성자를 호출할 것인지 지정해야한다
    // 문법 : super(파라미터값, 파라미터 값 ...);
    // 만약 지정하지 않는다면 무조건 수퍼 클래스의 기본생성자를 호출한다 super();
    // 수퍼 클래스의 생성자를 호출할 때는 반드시 반드시 반드시 첫 번재 문장으로 와야한다
    super(); // 생략하면 수퍼 클래스의 기본 생성자 호출
             // A클래스의 수퍼클래스 ? Object이다
    System.out.println("A.A()");
  }
  
  public void m1() {
    System.out.printf("A.v1 = %d\n",this.v1);
  }
}
