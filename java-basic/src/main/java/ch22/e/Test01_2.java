// 인스턴스 읽기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test01_2 {

  public static void main(String[] args) {

    // score.data 파일에서 세 학생의 데이터를 읽어 Score인스턴스로 생성하라
    // ==> java.io.BufferedInputStream 사용
    // ==> java.io.DataInputStream 사용
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라
    // ==> 홍길동, 100, 100, 100, 300, 100
    try (FileInputStream in = new FileInputStream("score.data");
        BufferedInputStream in2 = new BufferedInputStream(in);
        DataInputStream in3 = new DataInputStream(in2);){

      s1 = setScore(in3.readUTF(), in3.readInt(), in3.readInt(), in3.readInt());
      System.out.printf("%s, %d, %d, %d, %d, %.2f\n"
          ,s1.getName() ,s1.getKor(), s1.getEng()
          , s1.getMath(),s1.getSum(), s1.getAver());
      
      s2 = setScore(in3.readUTF(), in3.readInt(), in3.readInt(), in3.readInt());
      System.out.printf("%s, %d, %d, %d, %d, %.2f\n"
          ,s2.getName() ,s2.getKor(), s2.getEng()
          , s2.getMath(),s2.getSum(), s2.getAver());
          
      s3 = setScore(in3.readUTF(), in3.readInt(), in3.readInt(), in3.readInt());
      System.out.printf("%s, %d, %d, %d, %d, %.2f\n"
          ,s3.getName() ,s3.getKor(), s3.getEng()
          , s3.getMath(),s3.getSum(), s3.getAver());




    } catch (IOException e) {
      e.printStackTrace();
    }


    System.out.println("...");
  }
  
  
  
  public static Score setScore(String name, int kor, int eng, int math) {
    Score temp = new Score();
    temp.setName(name);
    temp.setKor(kor);
    temp.setEng(eng);
    temp.setMath(math);
    return temp;
  }
}
