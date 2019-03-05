package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import com.eomcs.lms.ApplicationInitializer;
import com.eomcs.util.DataSource;

public abstract class AbstractCommand implements Command{
  
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try{
      execute(new Response(in, out));
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  } // execute(BufferedReader, PrintWriter)
  
  public void execute(Response respose) throws Exception {
    // 서브 클래스에서 오버라이딩 해야할 메서드
    // 추상메서드로 선언하지 않아서 오버라이딩을 강요하지 않는다
    // 왜? 서브클래스는 Command의 execute(BufferedReader, PrintWriter)를 오버라이딩 할 지도 몰라서
  } // execute(Response)
} // end of class
