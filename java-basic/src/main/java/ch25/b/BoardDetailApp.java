// 연습 - 게시물 조회
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetailApp {
  public static void main(String[] args) {

    // 다음과 깉이 게시물을 조회하는 프로그램을 작성하라
    //-----------------------------------------------
    // 번호? 1
    // 제목 : aaa
    // 내용 : aaaa
    // 등록일 : 2019-4-4
    // 조회수 : 2

    // (또는)

    // 번호 ? 100
    // 해당 번호의 게시물이 존재하지 않습니다
    // 반복문xxxx
    //-----------------------------------------------
    Scanner keyboard = new Scanner(System.in);
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");

      try(Statement stmt = con.createStatement()){

        System.out.print("번호? ");
        int no = Integer.parseInt(keyboard.nextLine());
        String query = String.format(
            "select * from x_board where board_id = %d", no);
        
        try( ResultSet rs = stmt.executeQuery(query); ) {
          if(rs.next()) {
            System.out.printf("%s, %s, %s, %s\n",
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getString("created_date"),
                rs.getString("view_count"));
          } else {
            System.out.println("해당 게시글을 찾을 수 없습니다");
          }
        }
      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();




  } // main()
} // end of class
