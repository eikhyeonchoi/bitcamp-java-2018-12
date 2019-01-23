package design_pattern.abstract_factory;

// 이 클래스는 직접 사용할 클래스가 아님
// ==> 건물을 짓는데 필요한 기본필드와 기본메서드를 서브 클래스에게 상속해주는 용도로 사용
// ==> 일부 메서드는 추상 메서드이다
// ==> 따라서 이 클래스는 추상클래스이어야한다

// 결국 이 클래스는 특정 빌딩을 짓는 서브 클래스를 만들기 위한 틀(templet)로써 사용된다
// 기본 흐름은 build()메서드에 정의 되어있음
// 흐름에서 각 단계는 추상 메서드로 선언되어 있다
// 어떤 작업을 수행할지는 서브 클래스에서 정의하는 것이다
// 즉 Unit클래스는 서브 클래스가 구현해야할 틀
// prepare();
// construct();
// install();
// interior();
public abstract class Unit {
  // 건물 타입값을 지정할 때 직접 숫자를 사용하면 나중에 알아보기가 힘듬
  // 유지보수를 위해 숫자보다 문자를 사용하는 것이 좋다
  // 그래서 상수변수를 사용하는 것
  public static final int GENERAL_BUILDING = 0;
  public static final int DEFENCE_BUILDING = 1;
  public static final int ATTACK_BUILDING = 2;
  protected String name;
  protected int area;
  protected int type;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  // 수퍼 클래스에서 기본 흐름을 정의한다
  // ==> 그래서 build() 메서드는 구현 메서드로 정의
  public void build() {
    prepare(); // 건물 지을 땅 준비
    construct(); // 건물 뼈대를 짓는다
    install(); // 배선 및 단열, 외장을 설치
    interior(); // 내부 인테리어를 한다
  }
  
  // 유닛의 종류에 따라 건물을 짓는 방식이 다르기 때문에 
  // 구체적인 구현은 서브클래스에게 맡긴다
  // ==> 따라서 build()가 호출하는 메서드는 추상 메서드로 선언
  
  public abstract void prepare();
  public abstract void construct();
  public abstract void install();
  public abstract void interior();
}
