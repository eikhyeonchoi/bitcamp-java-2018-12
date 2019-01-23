package design_pattern.abstract_factory;

public class Restaurant extends Unit {
  @Override
  public void prepare() {
    System.out.println(this.name + " Restaurant.preapare() 땅 나라시");
  }
  @Override
  public void construct() {
    System.out.println(this.name + " Restaurant.construct() 조립 판넬 세움");
  }
  @Override
  public void install() {
    System.out.println(this.name + " Restaurant.install() 내부 배선과 창을 붙인다");
    
  }
  @Override
  public void interior() {
    System.out.println(this.name + " Restaurant.interior() 내부 식탁, 의자등 인테리어");
  }
}
