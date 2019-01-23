package design_pattern.template_method;

public class TrainingCenter extends Unit {
  @Override
  public void prepare() {
    System.out.println("TrainingCenter.preapare() 운동장 나라시, 숙소 건물땅에 콘크리트포장");
  }
  @Override
  public void construct() {
    System.out.println("TrainingCenter.construct() 운동장 잔디, 숙소건물 짓는다");
  }
  @Override
  public void install() {
    System.out.println("TrainingCenter.install() 연설대 설치, 내부 배선과 창을 붙인다");
    
  }
  @Override
  public void interior() {
    System.out.println("TrainingCenter.interior() 내부 침실 인테리어");
  }
}
