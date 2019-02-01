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
      
      System.out.println(in3.readUTF());
      System.out.println(in3.readUTF());
      System.out.println(in3.readUTF());


    } catch (IOException e) {
      e.printStackTrace();
    }


    System.out.println("...");
  }
}
