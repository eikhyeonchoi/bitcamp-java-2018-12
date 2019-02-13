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
        Scanner keyboard = new Scanner(System.in)){
      System.out.println("서버와 연결되었음.");
      ServerTest.in = in;
      ServerTest.out = out;
      
      add(new Member(1, "홍길동"));
      add(new Member(2, "임꺽정"));
      
      out.writeUTF("asdasd"); out.flush();
      System.out.println(in.readUTF());
      
      list();
      quit();
      
      System.out.println("서버와 연결 끊었음.");
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
  } // main
  
  static void add(Member member) throws Exception {
    out.writeUTF("add"); out.flush();
    out.writeObject(member); out.flush();
    System.out.println(in.readUTF());
  } // add()
  
  static void list() throws Exception {
    out.writeUTF("list"); out.flush();
    @SuppressWarnings({"unchecked", "unused"})
    List<Member> members = (List<Member>) in.readObject();
    for(Member m : members) System.out.println(m);
  } // list()
  
  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  } // quit()
  
}
