// 인스턴스 출력하기
package ch22.e;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01_1 {

  public static void main(String[] args) {

    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장
    // ==> java.io.BufferedOutputStream 사용
    // ==> java.io.DataOutputStream 사용
    Score s1 = new Score("홍길동",100,100,100);
    Score s2 = new Score("임꺽정",90,90,90);
    Score s3 = new Score("유관순",80,80,80);

    try (FileOutputStream out = new FileOutputStream("score.data");
        BufferedOutputStream out2 = new BufferedOutputStream(out);
        DataOutputStream out3 = new DataOutputStream(out2); ){

      out3.writeUTF(s1.getName());
      out3.writeInt(s1.getKor());
      out3.writeInt(s1.getEng());
      out3.writeInt(s1.getMath());

      out3.writeUTF(s2.getName());
      out3.writeInt(s2.getKor());
      out3.writeInt(s2.getEng());
      out3.writeInt(s2.getMath());

      out3.writeUTF(s3.getName());
      out3.writeInt(s3.getKor());
      out3.writeInt(s3.getEng());
      out3.writeInt(s3.getMath());

      out.flush(); // 버퍼 쓰는 경우 꼭 선언할 것...


    } catch (IOException e) {
      e.printStackTrace();
    }







    System.out.println("...");
  }
}
