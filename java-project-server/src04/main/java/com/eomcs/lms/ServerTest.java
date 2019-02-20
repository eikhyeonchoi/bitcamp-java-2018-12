package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerTest {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); ){
      System.out.println("서버와 연결되었음.");
      
      Member member = new Member();
      member.setNo(1);
      member.setName("홍길동");
      member.setEmail("hong@test.com");
      member.setPassword("1111");
      member.setPhoto("hong.gif");
      member.setTel("1111-1111");
      
      out.writeObject(member);
      out.flush();
      
      System.out.println(in.readUTF());
      
      
      System.out.println("서버와 연결 끊었음.");
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
  } // main
}