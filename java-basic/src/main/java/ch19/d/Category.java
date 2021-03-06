// static nested class의 문법 응용 : 분류명 관리하기
package ch19.d;

// 상수를 관리하는 용도로만 사용될 클래스라면 서브 클래스를 만들지 못하도록 막아야 한다
// ==> final 제한자를 사용하라
public final class Category {
  
  // static nested class 문법이 필요한 이유
  // 작은 클래스를 패키지 멤버 클래스로 만들면 소스 파일이 너무 많이 생겨 관리하기가 번거롭다
  // ==> 예:
  //        Computer.java, Mouse.java, Appliance.java, Book.java
  //
  // ==> 이렇게 작은 크기의 클래스가 많은 경우 어느 한 클래스 안에 static 중첩 클래스로 작성하는 것이
  //     클래스 파일을 한 개 만 유지하면 되기 때문에 유지보수에 편하다 = 소스 파일 관리가 쉬움
  
  // 분류의 각 계층을 static 중첩 클래스로 선언하여 관리
  // ==> 보통 클래스 이름은 대문자로 시작해야 한다
  // ==> 그런데 OGNL 표기법에서 하위 프로퍼티(필드)를 지정하는 것처럼 보이기 하려고
  //     일부러 소문자로 이름을 지었음
  public static final class computer {
    public static final class mouse {
      public static final int bluetooth = 111;
      public static final int gaming = 112;
      public static final int wired = 113;
      public static final int trackball = 114;
    }
    public static final int keyboard = 102;
    public static final int monitor = 103;
    public static final int cpu = 104;
    public static final int ram = 105;
    public static final int vga = 106;
  }

  public static final class appliance {
    public static final int tv = 201;
    public static final int audio = 202;
    public static final int dvd = 203;
    public static final int vacuum = 204;
  }

  public static final class book{
    public static final int poet = 301;
    public static final int novel = 302;
    public static final int essay = 303;
    public static final int it = 304;
    public static final int lang = 305;
  }
}
