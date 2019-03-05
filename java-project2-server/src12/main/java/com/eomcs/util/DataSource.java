package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

// 커넥션을 빌려주고 return 받는일
public class DataSource {

  String driver;
  String jdbcUrl;
  String username;
  String password;

  public DataSource(String d, String j, String u, String p) {
    this.driver = d;
    this.jdbcUrl = j;
    this.username = u;
    this.password = p;
  }

  // 한 번 생성된 DB Connection 객체를 보관하는 저장소
  ArrayList<Connection> list = new ArrayList<>();

  // 커넥션 객체를 현재 스레드에 보관할 수 있도록 주머니 준비
  ThreadLocal<Connection> conLocal = new ThreadLocal<Connection>();

  public Connection getConnection() {
    try {
      // 현재 스레드 주머니에 들어 있는 커넥션 객체 꺼내기
      Connection con = conLocal.get();
      if (con == null) { // 스레드 주머니에도 Connection 객체가 없고
        if (list.size() == 0) { // 리스트에도 Connection 객체가 없으면
          System.out.println("새로운 DB Connection 생성");
          con =  DriverManager.getConnection( // 새로 Connection 객체생성
              "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
          con.setAutoCommit(false);
        } else { // 리스트에 Connection 객체가 있다면 ?
          System.out.println("Connection Pool에 보관된 것 리턴");
          con = list.remove(0); // 리스트에서 Connection 객체를 꺼냄
        }
        // 일단 준비된 Connection 객체는 현재 스레드에서 사용할 수 있도록 주머니에 보관
        conLocal.set(con);
      } else {
        System.out.println("Thread 주머니에 보관된 Connection 객체 리턴");
      }
      return con;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // getConnection()

  public void returnConnection(Connection con) {
    // 다 사용한 Connection 객체는 다시 재활용할 수 있도록 목록에 보관
    list.add(con);

  } // returnConnection(Connection)

}
