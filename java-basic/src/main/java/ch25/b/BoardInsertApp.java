// 연습 - 게시물 등록
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardInsertApp {
  public static void main(String[] args) {
    // 다음과 깉이 게시물을 등록하는 프로그램을 작성하라
    //-----------------------------------------------
    // 제목 ? aaa
    // 내용 ? bbb
    // 등록하시겠습니까? (Y/n) 엔터치거나 y 또는 Y 입력하면
    // 등록하였습니다
    //-----------------------------------------------
    Scanner keyboard = new Scanner(System.in);
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");

      try(Statement stmt = con.createStatement()){
        
        System.out.print("제목? ");
        String title = keyboard.nextLine();
        System.out.print("내용? ");
        String contents = keyboard.nextLine();
        
        System.out.print("등록 하시겠습니까 ?(Y/n)");
        String answer = keyboard.nextLine();
        
        if (answer.equalsIgnoreCase("y") | answer.length() == 0) {
          String query = String.format("insert into x_board(title, contents)"
              + " values('%s', '%s')", title, contents);
          stmt.executeUpdate(query);
          System.out.println("등록하였습니다");
          
        } else {
          System.out.println("등록을 취소함");
          
        }
        

      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();
  } // main()
} // end of class
