// 데코레이터 여러 연결하기
package ch22.c;
import java.io.FileInputStream;

public class Test04_3 {
  public static void main(String[] args) {
    
    // 데코레이터의 장점
    // ==> 기능을 붙이고 떼기가 쉽다
    try (FileInputStream in  = new FileInputStream("data.bin");
        // 버퍼단위로 읽는 데코레이터를 붙인다 ==> 읽기 속도 빨라진다
        BufferedInputStream in1 = new BufferedInputStream(in);
        // primitive type변환 데코레이터를 붙인다 ==> 특정 타입의 값을 출력하기 편하다
        DataInputStream in2 = new DataInputStream(in1);) {
      
      // 바이너리 데이터를 읽을 때는 저장한 순서(파일 포맷)에 맞춰 읽어야한다
      int no = in2.readInt();
      String name = in2.readUTF();
      int age = in2.readInt();
      
      System.out.printf("%d, %s, %d\n", no, name, age);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    
    
    
    
    System.out.println("complete ...");
  }
}
