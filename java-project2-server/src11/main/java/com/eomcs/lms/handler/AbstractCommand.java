package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import com.eomcs.lms.ApplicationInitializer;
import com.eomcs.util.ConnectionFactory;

public abstract class AbstractCommand implements Command{

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    // 정상적으로 작업이 끝났을 경우
    // 클라이언트 요청을 처리한 후 커넥션을 자동으로 close()하도록 선언
    try ((Connection con = ConnectionFactory.create())){
      execute(new Response(in, out));
      // 현재 스레드에 보관된 Connection객체를 꺼냄
      // 그리고 그 Connection객체를 통해 수행했던 모든 데이터 변경 작업을 Commit 
      ConnectionFactory.create().commit();

    }catch (Exception e) {
      try {
        ConnectionFactory.create().rollback();
      }catch(Exception e2) {
      }
      out.printf(String.format("실행 오류 : %s\n", e.getMessage()));
    }

  }

  public void execute(Response respose) throws Exception {
    // 서브 클래스에서 오버라이딩 해야할 메서드
    // 추상메서드로 선언하지 않아서 오버라이딩을 강요하지 않는다
    // 왜? 서브클래스는 Command의 execute(BufferedReader, PrintWriter)를 오버라이딩 할 지도 몰라서
  }
}
