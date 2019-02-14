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
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

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

    BoardService boardService = new BoardService(boardDao);
    MemberService memberService = new MemberService(memberDao);
    LessonService lessonService = new LessonService(lessonDao);

    try(ServerSocket serverSocket = new ServerSocket(8888); ){
      System.out.println("서버 시작!");

      while (true) {
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){
          boardService.init(in, out);
          memberService.init(in, out);
          lessonService.init(in, out);

          System.out.println("클라이언트 연결되었음.");
          ServerApp.in = in;
          ServerApp.out = out;

          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            if (request.startsWith("/member/")) {
              memberService.execute(request);

            } else if (request.startsWith("/lesson/")) {
              lessonService.execute(request);

            } else if (request.startsWith("/board/")) {
              boardService.execute(request);

            } else if(request.equals("quit")) {
              quit(); 
              break loop;

            } else {
              out.writeUTF("FAIL"); 
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
    try {
      boardDao.saveData();
    } catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    try {
      lessonDao.saveData();
    } catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    try {
      memberDao.saveData();
    } catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    out.writeUTF("종료"); out.flush();
  } // quit()

}
