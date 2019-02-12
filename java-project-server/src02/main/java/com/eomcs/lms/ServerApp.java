package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8888);){
      System.out.println("서버 시작!");
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())); 
            PrintStream out = new PrintStream(socket.getOutputStream()); ){
          System.out.println("클라이언트 연결되었음.");
          
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
