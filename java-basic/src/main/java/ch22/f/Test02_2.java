// Serialize 구현체의 인터페이스 읽기
package ch22.f;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test02_2 {
  public static void main(String[] args) {

    // deSerialize
    // ==> 저장할 때 사용한 클래스를 가지고 인스턴스를 만든 후
    //     바이트 배열을 읽어 인스턴스 필드에 그대로 저장 
    // ==> 생성자는 호출 x
    // ==> 저장할 때 사용한 클래스가 변경된 경우에는 
    //    deSerialize할 때 예외가 발생한다
    // ==> 예) Score2 인스턴스를 저장한 후
    //       Score2 클래스를 변경
    //         인스턴스 필드를 추가한다음 다시 읽기
    try (ObjectInputStream in = 
        new ObjectInputStream(new FileInputStream("score2.data"))) {
      
      Score2 score = (Score2) in.readObject();
      System.out.println(score);
      
      // Score2 클래스를 변경한 후 이 클래스를 이용해 
      // serialize된 데이터를 읽어들이면 예외가 발생한다
      // 예외 분석 : 
      // ==> java.io.Serializable 구현체는 내부적으로
      //     SerialVersionUID라는 스태틱 변수가 자동으로 생김
      //     Serialize되는 데이터의 파일 버전 역할을 한다
      // ==> SerialVersionUID 직접 지정하지 않으면 컴파일할 때 자동으로 부여
      // ==> Score2클래스 또한 이 변수가 존재하고
      //     score2.data파일로 인스턴스를 출력할 때 ObejctOutputStream
      //       이 변수의 값이 함께 저장된다
      //     Score2 클래스를 변경하게 되면 이 변수의 값이 자동으로 새로 부여됨
      //     ObjectInputStream.readObject()는 
      //     score2.data 파일을 읽을 때 함께 저장된 serialVersionUID값과
      //     deSerialize할 때 사용할 Score2클래스의 serialVersionUID값을 비교하여
      //       같다면 파일의 데이터를 읽어 인스턴스를 생성하여 return 다르면 exception
      
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
}
