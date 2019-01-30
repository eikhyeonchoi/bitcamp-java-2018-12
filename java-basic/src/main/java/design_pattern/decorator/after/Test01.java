package design_pattern.decorator.after;

public class Test01 {
  public static void main(String[] args) {

    // Decorator 패턴이 적용된 자동차
    // Decorator 디자인 패턴의 목표 
    // 기능을 플러그인 처럼 붙였다 뗐다를 자유롭게 하기 위함이다
    
    Truck c1 = new Truck();
    Hybrid c2 = new Hybrid(c1);
    c2.run();

    System.out.println();
    Convertible c3 = new Convertible(c2);
    c3.openRoof(true);
    c3.run();

    System.out.println();
    Sedan s1 = new Sedan();
    Convertible c4 = new Convertible(s1);
    c4.openRoof(true);
    c4.run();

    System.out.println();
    Dump c5 = new Dump(c4);
    c5.run();

    System.out.println();
    Dump c6 = new Dump(c3);
    c6.run();

    System.out.println("testsddddddddddddddddddddd");
    System.out.println();
    Hybrid h = new Hybrid(new Convertible(new Dump(new SunRoof(new Sedan()))));
    h.run();



  }

}
