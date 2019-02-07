  // 인스턴스 출력하기 - ObjectOutputStream Decorator
package ch22.e;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test04_1 {
  public static void main(String[] args) {

    ArrayList<Score> list = new ArrayList<Score>();
    list.add(new Score("홍길동", 20, 86, 71));
    list.add(new Score("임꺽정", 91, 11, 34));
    list.add(new Score("유관순", 56, 64, 42));

    // ObjectOutputStream
    // ==> DataOutputStream 의 기능을 포함한다
    // ==> 인스턴스를 바이트배열로 만들어 출력하는 기능이 있다
    // ==>  단 클래스가 java.io.Serializable 인터페이스를 구현한 클래스 여야 한다
    

    try (FileOutputStream out = new FileOutputStream("score.data");
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        ObjectOutputStream out3 = new ObjectOutputStream(out2); ){

      out3.writeInt(list.size());

      for(Score s : list) {
        out3.writeObject(s);
      }

      out.flush(); // 버퍼 쓰는 경우 꼭 선언할 것...
    } catch (IOException e) {
      e.printStackTrace();
    }







    System.out.println("...");
  }
}
