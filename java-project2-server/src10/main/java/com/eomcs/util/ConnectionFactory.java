package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

// 커넥션을 빌려주고 return 받는일
public class ConnectionFactory {
  
  public static Connection create() {
    try {
    return DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
    } catch(Exception e) {
      throw new RuntimeException(e);
    }

  }
  
  public void returnConnection() {
    
  }

}
