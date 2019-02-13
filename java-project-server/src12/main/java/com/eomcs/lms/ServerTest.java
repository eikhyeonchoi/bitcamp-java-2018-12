/*
★★★★★★★★★★★★★★★★★★★★★★★★★★★★
★★★★★★★★★★★★★★★★★★★★★★★★★★★★

-src06 -> src07 과정 차례대로 코딩할 것
  -ServerTest 과정
    -메서드 리팩토링
    -클래스 리팩토링
    -접근 제한자 + static vs instance
    -생성자
   -Lesson, Board에도 적용 복붙적용

★★★★★★★★★★★★★★★★★★★★★★★★★★★★
★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 */
package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class ServerTest {
  
  static ObjectOutputStream out;
  static ObjectInputStream in;
  
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Scanner keyboard = new Scanner(System.in) ){
      System.out.println("서버와 연결되었음.");
      ServerTest.in = in;
      ServerTest.out = out;
      
      new MemberTest(out, in).test();
      System.out.println("==========================");
      new LessonTest(out, in).test();
      System.out.println("==========================");
      new BoardTest(out, in).test();
      System.out.println("==========================");

      quit();
      System.out.println("서버와 연결 끊었음.");
    } catch(Exception e) {
      e.printStackTrace();
    }
  } // main
  
  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  } // quit()
  
}
