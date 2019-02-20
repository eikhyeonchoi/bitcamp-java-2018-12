// 연습 - 게시물 조회
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardUpdateApp {
  public static void main(String[] args) {
    // 다음과 깉이 게시물을 변경하는 프로그램을 작성하라
    //-----------------------------------------------
    // 번호? 1
    // 제목? xxx
    // 내용? xxx
    // 변경했습니다

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
        System.out.print("제목? ");
        String title = keyboard.nextLine();
        System.out.print("내용? ");
        String contents = keyboard.nextLine();


        String query = String.format("update x_board set title='%s', contents='%s' "
            + "where board_id=%d", title, contents, no);
        int isUpdate = stmt.executeUpdate(query);

        if(isUpdate == 0) {
          System.out.println("해당 게시물이 존재하지 않습니다");
        } else {
          System.out.println("변경했습니다");
        }

      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();


  } // main()
} // end of class
