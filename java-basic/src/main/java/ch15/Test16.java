// Object 클래스 : clone() 사용법 2
package ch15;

// clone() 인스턴스를 자동 복제할 때 호출하는 메서드이다
public class Test16 {

  // 인스턴스 복제 기능을 활성화 하려면 Cloneable 인터페이스를 구현해야한다
  // ==> 이 인터페이스에는 메서드가 선언되어 있지 않다 
  // ==> 따라서 클래스는 따로 메서드를 구현할 필요가 없다
  // ==> Cloeable을 구현하는 이유는 JVM에게 이 클래스의 인스턴스를 복제할 수 있음을 표시하기 위함임
  //     이 표시가 안된 클래스는 JVM이 인스턴스를 복제해 주지 않는다
  // ==> 인스턴스를 복제할 때는
  //    Object에서 상속받은 clone()을 호출해야한다
  //    그런데 clone()의 접근 제어가 protected라서 
  //    같은 패키지의 멤버이거나 서브 클래스만이 호출할 수 있다
  //    다른 패키지의 멤버가 호출하려면 public으로 접근 제어의 범위를 넓혀야한다
  //    오버라이딩 하라
  static class Score implements Cloneable{
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    public Score() {}
    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = this.kor + this.eng + this.math;
      this.aver = this.sum / 3f;
    }
    @Override
    public String toString() {
      return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
          + sum + ", aver=" + aver + "]";
    }
    
    // 자바에서 제공하는 인스턴스를 복제해주는 기능을 사용하려면
    // ==> java.lang.Cloneable 인터페이스 규칙을 따라야한다
    // Object에서 상속받은 clone()을 오버라이딩하여 다른 패키지의 멤버도 사용할 수 있게
    // public으로 접근 범위를 넓혀라
    // 오버라이딩은 접근범위를 좁힐수는 ㅇ벗지만 넓힐 수는 있다
    // 오버라이딩할 때 리턴 타입을 클래스 타입으로 변경 해도 된다
    @Override
    public Score clone() throws CloneNotSupportedException {
      // 복제를 위한 코드를 작성할 필요가 없다 JVM이 알아서해줌
      // 그냥 상속받은 메서드를 호출하라
      return (Score) super.clone();
    }
  }

  public static void main(String[] args) throws Exception{
    // Object에서 상속 받은 clone()을 오버라이딩 하기
    Score s1 = new Score("홍길동",100,100,100);

    // 만약 Score 클래스에 java.lang.Cloneable 인터페이스를 붙이지 않았다면
    // JVM은 다음 예외를 발생 시킴 
    // ==>     java.lang.CloneNotSupportedException
    // 즉 Score 클래스는 개발자가 복제를 허락하지 않았다는 뜻이다
    Score s2 = s1.clone();
    s2.name = "임꺽정";
    System.out.println(s1);
    System.out.println(s2);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

  }
}
