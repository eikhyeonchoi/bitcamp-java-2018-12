// 2단계: 클라이언트의 연결을 승인한다.

// 3단계: 클라이언트와 서버 간에 간단한 문자열 데이터를 주고 받는다.

// 4단계: 클라이언트와 서버 간에 인스턴스를 주고 받는다.

// 5단계: 클라이언트가 보낸 add, list, quit 명령을 받아 처리한다.

// 6단계: 클라이언트가 보낸 회원 관리 명령어(/member/*)를 처리한다.

// 7단계: 클라이언트의 연결을 승인한다.
// 7단계: 클라이언트에서 요청한 /board/* 명령을 처리한다.
// 7단계: 클라이언트에서 요청한 /member/* 명령을 처리한다.
// 7단계: 클라이언트에서 요청한 /lesson/* 명령을 처리한다.

// 8단계: 클라이언트 요청을 처리하는 클래스에 대해 리팩토링 수행
// 클라이언트의 요청을 처리하는 클래스라는 의미로 
// 클래스명을 *Service로 변경한다.

// 9단계: 클라이언트 요청을 처리하는 서비스 클래스를 별도의 패키지로 분류하기

// 10단계: 데이터를 파일로 관리한다.

// ======================================================================
// 11단계 부터 클라이언트를 다른 프로젝트에서 실행할 것

// 11단계: 서비스 클래스의 일반화(상속)를 수행한다.
// 11단계: AbstractService 상속 받기

// 12단계: Service 클래스에서 데이터 처리 코드를 별도의 클래스(DAO)로 분리

// 13단계 statful -> stateless
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
