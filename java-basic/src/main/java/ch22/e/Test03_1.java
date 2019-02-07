// 파일 입출력 ArrayList사용
package ch22.e;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test03_1 {
  public static void main(String[] args) {

    ArrayList<Score> list = new ArrayList<Score>();
    list.add(new Score("홍길동",100,100,100));
    list.add(new Score("임꺽정",90,90,90));
    list.add(new Score("유관순",80,80,80));


    try (FileOutputStream out = new FileOutputStream("score.data");
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        DataOutputStream out3 = new DataOutputStream(out2); ){

      out3.writeInt(list.size());

      for(Score s : list) {
        out3.writeUTF(s.getName());
        out3.writeInt(s.getKor());
        out3.writeInt(s.getEng());
        out3.writeInt(s .getMath());
      }

      out.flush(); // 버퍼 쓰는 경우 꼭 선언할 것...
    } catch (IOException e) {
      e.printStackTrace();
    }







    System.out.println("...");
  }
}
