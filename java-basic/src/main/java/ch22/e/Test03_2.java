// 파일 입출력 ArrayList사용
package ch22.e;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test03_2 {

  public static void main(String[] args) {

    ArrayList<Score> list = new ArrayList<Score>();
    try (FileInputStream in = new FileInputStream("score.data");
        BufferedInputStream in2 = new BufferedInputStream(in);
        DataInputStream in3 = new DataInputStream(in2);){

      int len = in3.readInt();

      for(int i = 0; i < len; i++) {
        Score s = new Score();
        s.setName(in3.readUTF());
        s.setKor(in3.readInt());
        s.setEng(in3.readInt());
        s.setMath(in3.readInt());
        list.add(s);
      }

      for(Score s : list) {
        System.out.printf("%s, %d, %d, %d, %d, %f\n"
            ,s.getName(), s.getKor(), s.getEng(), s.getMath()
            , s.getSum(), s.getAver());
      }




    } catch (IOException e) {
      e.printStackTrace();
    }


    System.out.println("...");
  }
}
