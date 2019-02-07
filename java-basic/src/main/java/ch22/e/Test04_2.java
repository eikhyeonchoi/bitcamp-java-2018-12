// 인스턴스 입력하기 - ObjectInputStream Decorator
package ch22.e;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {

  public static void main(String[] args) {

    ArrayList<Score> list = new ArrayList<Score>();

    // ObjectInputStream
    // ==> DataInputStream의 기능을 포함한다
    // ==> ObjectOutputStream.writeObject()f로 출력한 바이트 배열을 읽어
    //       인스턴스를 생성하는 기능이 있다
    // ==> 단 클래스가 java.io.Serializable 인터페이스를 구현한 클래스 여야 한다
    //     출력할 때 버전과 읽을 때 클래스 버전이 같아야 한다
    // ==> 인스턴스 필드를 생성한 후 직접 필드에 값을 저장한다
    try (FileInputStream in = new FileInputStream("score.data");
        BufferedInputStream in2 = new BufferedInputStream(in);
        ObjectInputStream in3 = new ObjectInputStream(in2);){

      int len = in3.readInt();

      for(int i = 0; i < len; i++) {
        // 저장한 인스턴스 필드 값을 그대로 읽을 것이기 때문에
        // sum과 aver필드 값도 그대로 읽을 것이다
        // 따라서 comput()는 따로 호출할 필요가 없다
        // compute();
        list.add((Score)in3.readObject());
      }

      for(Score s : list) {
        System.out.printf("%s, %d, %d, %d, %d, %f\n"
            ,s.getName(), s.getKor(), s.getEng(), s.getMath()
            , s.getSum(), s.getAver());
      }




    } catch (Exception e) {
      e.printStackTrace();
    }


    System.out.println("...");
  }
}
