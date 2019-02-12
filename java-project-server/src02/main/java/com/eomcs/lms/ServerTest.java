package com.eomcs.lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTest {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost",8888); 
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())); 
        PrintStream out = new PrintStream(socket.getOutputStream()); ) {
      System.out.println("서버와 연결되었음.");
      
      
      System.out.println("서버와 연결 끊었음.");
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
  } // main
}
