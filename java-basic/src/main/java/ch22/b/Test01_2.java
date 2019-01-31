// 바이너리 데이터 입출력 : FileInputStream 클래스 사용법
package ch22.b;

import java.io.FileInputStream;

public class Test01_2 {
  public static void main(String[] args) {
    
    // 파일의 바이너리 데이터 읽기 
    // ==> FileInputStream 클래스 사용
    // 1) 데이터 읽기를 담당할 객체를 생성
    try (FileInputStream in = new FileInputStream("data.bin");) {
      
      //  2) 데이터를 읽는다
      // ==> 읽은 데이터를 저장할 변수 선언
      // ==> 1바이트 값을 저장할 변수는 int형으로 선언한다 byte타입이 아니다
      // ==> 이유? 0~255까지의 값을 읽기 때문이다
      //    byte는 ~128 ~ 127까지의 값만 저장한다
      // ==> 여러 바이트를 읽을 때는 바이트 배열을 사용
      int b;
      while((b = in.read()) != -1) {
        // read()의 return값은 int 타입
        // ==> 그렇다고 4바이트를 읽어 리턴하는 것이 아니다
        // ==> 1바이트를 읽어 return
        
        /*
        b = in.read();
        if(b == -1) // 파일에 끝에 도달하면
          break;
        System.out.print(Integer.toHexString(b) + " ");
        */
        System.out.print(Integer.toHexString(b) + " ");
      }
      System.out.println();
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
