// 버퍼 사용후
package ch22.c;
import java.io.FileOutputStream;

public class Test02_2 {
  public static void main(String[] args) {
    FileOutputStream out = null;

    try  {
      out = new FileOutputStream("data.bin");
      System.out.println("data writing ...");
      long start = System.currentTimeMillis();

      byte[] buf = new byte[1024];
      int size = 0;

      for (int i = 0; i< 1000000; i++) {
        buf[size++] = 0x55; // 일단 바이트 버퍼에 저장한다

        if (size >= 1024) {
          out.write(buf); // 버퍼가 꽉 차면 파일로 내보낸다
          size = 0; // 다시 버퍼를 쓸 수 있도록 사이즈를 0으로 초기화
          continue;
        }
      }


      // 마지막으로 버퍼에 남아 있는 바이트를 출력한다
      out.write(buf, 0, size);

      long end = System.currentTimeMillis();
      System.out.println("걸린시간(ms) = " + (end - start));

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {out.close();} catch(Exception e) {}

    }

    System.out.println("complete ...");




  }
}
