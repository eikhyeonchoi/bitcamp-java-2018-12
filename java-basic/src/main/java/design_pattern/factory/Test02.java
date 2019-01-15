package design_pattern.factory;

class Car2 {
  int cc;
  String model;
  boolean sunroof;
}


// 인스턴스 생성과정이 복잡할 때 별도의 클래스에서 인스턴스를 생성하는 것이 유지보수에 좋다
// ==> 어떤 클래스의 인스턴스를 대신 생성해주는 클래스는 보통 xxxFactory라는 이름으로 짓는다
class Car2Factory {
  
  // 인스턴스를 생성해주는 메서드를 정의한다
  // ==> 이렇게 설계하는 기법을 "팩토리메서드"라고한다
  public static Car2 create(String product) {
    Car2 c = new Car2();
    switch (product) {
      case "tc":
        c.model = "티코";
        c.cc = 890;
        c.sunroof = true;
        break;
      case "tcg":
        c.model = "티코 골드";
        c.cc = 890;
        c.sunroof = true;
        break;
      case "sn":
        c.model = "소나타";
        c.cc = 1990;
        c.sunroof = false;
        break;
      case "sng":
        c.model = "소나타 골드";
        c.cc = 1990;
        c.sunroof = true;
        break;
      default:
        return null;
    }
    return c;
  }
  
}

public class Test02 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Car2 c1 = Car2Factory.create("tc");
    Car2 c2 = Car2Factory.create("tcg");
    Car2 c3 = Car2Factory.create("sn");
    Car2 c4 = Car2Factory.create("sng");
    
    System.out.println(c1.model);
    System.out.println(c2.model);
    System.out.println(c3.model);
    System.out.println(c4.model);
    


  }
}
