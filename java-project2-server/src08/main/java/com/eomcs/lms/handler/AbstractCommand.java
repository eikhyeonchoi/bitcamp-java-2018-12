package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.eomcs.lms.ApplicationInitializer;

public abstract class AbstractCommand implements Command{
  
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    // 정상적으로 작업이 끝났을 경우
    try {
      execute(new Response(in, out));
      ApplicationInitializer.con.commit();
    }catch (Exception e) {
      
      // 예외가 발생하면 커넥션을 통해 데이터 변경 작업을 했던 것을 모두 취소한다
      // 임시 DB clear
      try {
        ApplicationInitializer.con.rollback();
      } catch (SQLException e1) {
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
