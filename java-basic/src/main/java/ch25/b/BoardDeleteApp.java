// 연습 - 게시물 조회
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteApp {
  public static void main(String[] args) {
    // 다음과 깉이 게시물을 삭제하는 프로그램을 작성하라
    //-----------------------------------------------
    // 번호? 1
    // 삭제했습니다
    // (또는)
    // 해당 번호의 게시물이 존재하지 않습니다
    //-----------------------------------------------
    Scanner keyboard = new Scanner(System.in);
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");

      try(Statement stmt = con.createStatement()){
        
        System.out.print("번호? ");
        int no = Integer.parseInt(keyboard.nextLine());
        
        String query = String.format(
            "delete from x_board where board_id = %d",no);
        
        int isDelete = stmt.executeUpdate(query);
        if(isDelete == 0) {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다");
        } else {
          System.out.println("삭제 했습니다");
        }
        

      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();
























  } // main()
} // end of class
