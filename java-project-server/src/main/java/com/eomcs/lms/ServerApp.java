package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerApp {
  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8888); ){
      System.out.println("서버 시작!");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){
          System.out.println("클라이언트 연결되었음.");
          
          Member member = (Member) in.readObject();
          System.out.println(member);
          
          out.writeUTF("객체를 받음");
          out.flush();
          
          System.out.println("클라이언트와 연결을 끊었음.");
        } catch (Exception e) {
          e.printStackTrace();
        }
        
      } // while
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
    
  } // main
}
