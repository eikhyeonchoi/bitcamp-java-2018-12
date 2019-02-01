package ch22.c;

import java.io.IOException;
import java.io.OutputStream;

// 기존 출력 기능에 버퍼 기능을 덧붙이는 플러그인 역할을 한다
// ==> 이런 역할을 하는 클래스를 "데코레이터"
//     데코레이터는 출력 클래스와 같은 조상이어야만 한다
//     기능을 덧붙이는 것이기 때문에 원래의 출력 객체를 생성자에서 받아야한다
//     
public class BufferedOutputStream extends OutputStream{
  byte[] buf = new byte[1024];
  OutputStream out;
  int size = 0;

  public BufferedOutputStream(OutputStream out) {
    this.out = out;
  }

  @Override
  public void write(int b) throws IOException {
    buf[size++] = (byte) b; // 일단 바이트 버퍼에 저장한다

    if (size >= 1024) {
      out.write(buf); // 버퍼가 꽉 차면 파일로 내보낸다
      size = 0; // 다시 버퍼를 쓸 수 있도록 사이즈를 0으로 초기화
    }
  }
  
  // 버퍼에 남아있는 데이터를 출력할 때 호출한다
  @Override
  public void flush() throws IOException {
    if(size > 0) {
      out.write(buf,0,size);
    }
  }
  
  
  
}
