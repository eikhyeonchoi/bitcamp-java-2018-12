// 바이너리 데이터 입출력 : FileOutputStream 클래스 사용법 - 배열단위출력
package ch22.b;

import java.io.FileOutputStream;

public class Test02_1 {
  public static void main(String[] args) {
    
    // 배열 단위로 출력
    // 기존의 파일을 덮어쓴다는 점
    try (FileOutputStream out = new FileOutputStream("data.bin");){
     byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66};
     // write(byte[]) : 배열의 값 전체를 출력한다
     // write(byte[], 시작위치, 갯수) : 시작위치부터 지정된 갯수를 출력한다
     out.write(bytes); // 배열 전체를 출력한다
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
