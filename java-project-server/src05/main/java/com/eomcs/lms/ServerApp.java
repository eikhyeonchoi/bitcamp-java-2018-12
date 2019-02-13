package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;
  static ArrayList<Member> members = new ArrayList<Member>();

  public static void main(String[] args) {


    try(ServerSocket serverSocket = new ServerSocket(8888); ){
      System.out.println("서버 시작!");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){
          System.out.println("클라이언트 연결되었음.");

          members.clear();
          ServerApp.in = in;
          ServerApp.out = out;

          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            switch(request) {
              case "quit" : quit(); break loop;
              case "add" : add(); break;
              case "list" : list(); break;
              default :
                out.writeUTF("명령어 처리 불가"); 
            }
            out.flush();
          } // while loop


          System.out.println("클라이언트와 연결을 끊었음.");
        } catch (Exception e) {
          e.printStackTrace();
        }

      } // while

    } catch(Exception e) {
      e.printStackTrace();
    }

  } // main()

  static void quit() throws Exception{
    out.writeUTF("종료"); 
    out.flush(); 
  } // quit()

  static void add() throws Exception {
    members.add((Member)in.readObject());
    out.writeUTF("Ok"); 
  } // add()

  static void list() throws Exception {
    out.writeObject(members); // Collection 객체도 보낼 수 있음 
  } // list()


}
