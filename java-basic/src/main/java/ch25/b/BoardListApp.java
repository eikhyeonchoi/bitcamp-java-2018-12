// 연습 - 게시물 목록 출력
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardListApp {
  public static void main(String[] args) {

    // 다음과 같이 게시물 목록을 출력
    // 게시물 번호를 내림차순
    //-----------------------------------------------
    // 번호, 제목, 등록일, 조회수
    // 2, aaa, 2019-1-1, 2
    // 1, bbb, 2019-12-31, 3
    //-----------------------------------------------
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");

      try(Statement stmt = con.createStatement()){

        try( ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc"); ) {

          while(rs.next()) {
            System.out.printf("%s, %s, %s, %s, %s\n",
                rs.getString("board_id"), 
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getString("created_date"),
                rs.getString("view_count"));
          } // while
        }


      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }




  } // main()
} // end of class
