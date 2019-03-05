package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

// 커넥션을 빌려주고 return 받는일
public class ConnectionFactory {

  // 커넥션 객체를 현재 스레드에 보관할 수 있도록 주머니 준비
  static ThreadLocal<Connection> conLocal = new ThreadLocal<Connection>();
  
  public static Connection create() {
    try {
      Connection con = conLocal.get();
      
      // 현재 스레드 주머니에 들어 있는 커넥션 객체 꺼내기
      if (con == null) {
        con =  DriverManager.getConnection(
            "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
        con.setAutoCommit(false);
        conLocal.set(con);
      }
      return con;
      
    } catch(Exception e) {
      throw new RuntimeException(e);
    }

  }
  
  public void returnConnection() {
    
  }

}
