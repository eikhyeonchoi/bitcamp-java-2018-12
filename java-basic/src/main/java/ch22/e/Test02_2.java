// 파일 입출력 배열 활용
package ch22.e;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test02_2 {

  public static void main(String[] args) {
    Score[] students = null;
    
    try (FileInputStream in = new FileInputStream("score.data");
        BufferedInputStream in2 = new BufferedInputStream(in);
        DataInputStream in3 = new DataInputStream(in2);){
      
      students = new Score[in3.readInt()];
      for(int i = 0; i < students.length; i++) {
        Score s = new Score();
        s.setName(in3.readUTF());
        s.setKor(in3.readInt());
        s.setEng(in3.readInt());
        s.setMath(in3.readInt());
        students[i] = s;
      }
      
      for(Score s : students) {
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
