// Statement 와 SQL삽입공격
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {
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

        // SQL삽입공격
        // ==> 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위

        /*
         번호? 2
         제목? okok
         내용? test', view_count = 300, created_date = '2019-3-3
         */

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
