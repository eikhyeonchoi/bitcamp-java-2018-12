// Serialize - serialVersionUID 스태틱 필드 사용
package ch22.f;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test03_2 {
  public static void main(String[] args) {

    // deSerialize
    // ==> Score3 클래스를 변경하지 않고 읽기
    //      정상적으로 읽을것 이다
    // ==> Score3에 tel필드와 getter/setter를 추가하고 toString을 다시 생성한 후 읽기
    //      단 serialVersionUID값은 출력할 때와 동일하게
    try (ObjectInputStream in = 
        new ObjectInputStream(new FileInputStream("score3.data"))) {
      
      Score3 score = (Score3) in.readObject();
      System.out.println(score);
      
      // Score3클래스를 바꾼 후에도 기존에 serialize된 데이터를
      // 그래도 읽을 수 있다 ==> serializeVersionUID가 같기 때문이다
      // 이런 이유로 개발자가 serialVersionUID변수의 값을 설정하는 것이다
      // 물론 기존 클래스와 비교해 완전히 바뀌어서 기존 serialize된 값을 정상적으로
      // 읽을 수 없을 경우에는 serialVersionUID값을 같게하는 것은 좋지 않다
      // 지금처럼 이전 클래스와 비교해 큰 변경이 없을 경우에만
      // 이 변수의 값을 그대로 유지하는 것이다.
      
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
}
