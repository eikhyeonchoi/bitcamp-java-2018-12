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

      detail(1);
      
      update(new Member(1, "변경된 홍길동"));
      
      detail(1);
      
      delete(2);
      
      add(new Member(3, "아무개"));
      list();
      
      quit();
      
      System.out.println("서버와 연결 끊었음.");
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
  } // main
  
  
  static void add(Member member) throws Exception {
    out.writeUTF("/member/add"); out.flush();
    out.writeObject(member); out.flush();
    
    String status = in.readUTF();
    if (status.equals("OK"))
      System.out.println("데이터 추가 성공");
    else 
      System.out.println("데이터 추가 실패");
    
  } // add()
  
  
  static void list() throws Exception {
    out.writeUTF("/member/list"); out.flush();
    
    String status = in.readUTF();
    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패");
      return;
    }
    @SuppressWarnings("unchecked")
    List<Member> members = (List<Member>) in.readObject();
    for(Member m : members) System.out.println(m);
  } // list()
  
  
  static void detail(int no) throws Exception {
    out.writeUTF("/member/detail"); out.flush();
    out.writeInt(no); out.flush();
    
    String status = in.readUTF();
    if (!status.equals("OK")) {
      System.out.println("데이터 목록 가져오기 실패");
      return;
    }
    Member member = (Member) in.readObject();
    System.out.println(member);
    
  } // detail()
  
  
  static void update(Member member) throws Exception {
    out.writeUTF("/member/update"); out.flush();
    out.writeObject(member); out.flush();
    
    String status = in.readUTF();
    if (status.equals("OK"))
      System.out.println("데이터 변경 성공");
    else 
      System.out.println("데이터 변경 실패");
    
  } // update()
  
  
  static void delete(int no) throws Exception {
    out.writeUTF("/member/delete"); out.flush();
    out.writeInt(no); out.flush();
    
    String status = in.readUTF();
    if (status.equals("OK"))
      System.out.println("데이터 삭제 성공");
    else 
      System.out.println("데이터 삭제 실패");
    
  } // delete()
  
  
  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  } // quit()
  
}
