// 템플릿 메서드 패턴 + 팩토리 메서드 패턴 결합

package design_pattern.template_method;

public class Test02 {
  public static void main(String[] args) {
    UnitFactory unitFactory = new UnitFactory();
    Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
    u1.build();
    

  }
}
