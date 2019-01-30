package design_pattern.decorator.before;

public class Test01 {
  public static void main(String[] args) {
    
    // 전기차 트럭을 만들어보자
    // Hybird를 상속받고 트럭기능을 덧붙인다
    // 트럭에는 Sedan기능이 필요 없지만 
    // 상속은 중간에 특정기능을 뺄 수 없다 무조건 다 상속받을 수 밖에 없음
    HybridTruck c1 = new HybridTruck();
    c1.dump();
    System.out.println();
    // 만약 Hybrid 이면서 Convertible 기능을 갖는 자동차를 만들고 싶다면
    // ==> Hybrid나 Convertible 둘 중 한 개를 상속 받아서 구현해야 한다
    // ==> 하위 클래스는 다른 클래스의 기능을 중복해서 개발해야 한다
    HybridConvertible c2 = new HybridConvertible();
    c2.open(true);
    c2.run2();
    
    // Convertible 자동차에 간단히 물건을 내리는 dump기능을 포함한다면 
    // 위 경우와 마찬가지로 Truck클래스나 Convertible클래스 둘 중 하나를 상속 받고
    // 둘 중 하나의 기능(코드)를 중복해서 작성해야한다 이게 상속에 한계이다
    
    System.out.println("11111111111111111111");
    Sedan s = new Sedan();
    s.run();
    s.start();
    s.openSunRoof();
    
    System.out.println("222222222222222222222");
    Convertible con = new Convertible();
    con.run();
    con.run2();
    con.openSunRoof();
    con.start();
    
    
    
    
    
    
  }
}
