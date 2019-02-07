// Serialize 인스턴스 필드의 값 읽기
package ch22.g;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test03_2 {
  public static void main(String[] args) {

    try (ObjectInputStream in = 
        new ObjectInputStream(new FileInputStream("score2.data"))) {
      
      // deSerialize할 때 private필드의 값도 데이터를 읽어 저장한다
      // 생성자나 setter를 호출하지 않는다
      // 인스턴스를 생성한 후 
      Score3 score = (Score3) in.readObject();
      System.out.println(score);
      
      // transient 필드는 보안상 serialize되지 않았기 때문에
      // deSerialize한 후 계산을 다시해야 한다
      // ==> 파일을 조작해 합계, 평균을 왜곡하는 상황을 막을 수 있다
      score.compute();
      System.out.println(score);
      
      
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
}
