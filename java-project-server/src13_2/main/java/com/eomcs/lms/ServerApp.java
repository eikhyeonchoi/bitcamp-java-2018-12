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

  -ServerApp과정
   -switch vs if 단순한건 switch 복잡한건 if
   -(String).startsWith(" ");
   -

★★★★★★★★★★★★★★★★★★★★★★★★★★★★
★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 */
package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.Service;

public class ServerApp {

  static BoardDao boardDao = null;
  static MemberDao memberDao = null;
  static LessonDao lessonDao = null;

  public static void main(String[] args) {

    try {
      boardDao = new BoardDao("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }
    try {
      memberDao = new MemberDao("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }
    try {
      lessonDao = new LessonDao("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }

    HashMap<String, Service> serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardService(boardDao));
    serviceMap.put("/member/", new MemberService(memberDao));
    serviceMap.put("/lesson/", new LessonService(lessonDao));

    Set<String> keySet = serviceMap.keySet();

    try(ServerSocket serverSocket = new ServerSocket(8888); ){
      System.out.println("서버 시작!");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){

          System.out.println("클라이언트 연결되었음.");

          String request = in.readUTF();
          System.out.println(request);
          
          String serviceName = null;
          for (String key : keySet) {
            if(request.startsWith(key)) {
              serviceName = key;
              break;
            }
          }
          if(serviceName == null) {
            out.writeUTF("FAIL");
            
          } else {
            Service service = serviceMap.get(serviceName);
            service.execute(request, in, out);
          }
          
          out.flush();

          System.out.println("클라이언트와 연결을 끊었음.");
        } catch (Exception e) {
          e.printStackTrace();
        }

      } // while

    } catch(Exception e) {
      e.printStackTrace();
    }

  } // main()


}
