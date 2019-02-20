// PreparedStatement를 사용해 SQL삽입공격 방지하기
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      System.out.print("제목? ");
      String title = keyboard.nextLine();
      System.out.print("내용? ");
      String contents = keyboard.nextLine();
      
      // PreparedStatement는 미리 SQL문장을 준비하여 값을 삽입하는 기법이다
      try(PreparedStatement stmt = con.prepareStatement(
          "update x_board set title = ?, contents = ? where board_id = ?")){

        // SQL 문장을 준비할 때, 값이 들어갈 자리에 ?로 표시한다
        // l?를 "in_parameter"라고 부른다
        // SQL을 서버에 전달하기 전에 in-parameter자리에 값을 넣는다
        // ==> PreparedStatement.setXXX(in-parmeter 인덱스, 값);
        //     - setXXX : 컬럼의 타입에 따라 setInt(), setString(), setDate() 등 숫자도 setString가능
        //     - in-parameter 인덱스 : ? 문자가 등장하는 순서대로 1부터 번호를 부여한다
        //     - l값 : SQL 문장에 삽입될 값이다, 실제 SQL문장과 별도로 서버에 전달되기 때문에
        //            l문자열 값 중간에 '(작은 따옴표)가 포함되더라도 SQL문에 영향을 끼치지 x
        //            l작은 따옴표를 그냥 일반 문자로 취급한다
        // ==> in-parameter 값을 설정할 때 순서대로 할 필요 x
        
        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.setInt(3, no);
        
        int isUpdate = stmt.executeUpdate();

        if(isUpdate == 0) {
          System.out.println("해당 게시물이 존재하지 않습니다");
        } else {
          System.out.println("변경했습니다");
        }
        // Statement vs PreparedStatement
        // 1) SQL 문장의 간결함 
        //      Statement : 값을 가지고 문자열로 직접 SQL문을 만들기 때문에 작성하거나 읽기 어려움
        //      PreparedStatement : SQL 문장과 값이 분리되어 있기 때문에 작성하거나 읽기 쉽다 
        // 2) SQL 삽입공격
        //      Statement : 사용자가 입력한 값을 가지고 SQL 문장을 만들기 때문에 해킹 되기쉽다
        //      PreparedStatement : SQL 문장과 값이 분리되어 다뤄지기 때문에 해킹불가
        // 3) Binary 데이터 다루기
        //      Statement : 문자열로 SQL문장을 만들기 때문에 바이트 배열의 값을 다룰 수 있다.
        //      PreparedStatement : setXXX() 메서드를 호출해 값을 설정하기 때문에 바이트배열의 값을 다룰 수 있다
        // 4) l실행속도
        //      Statement : executeUpdate()를 실행할 때 마다 SQL문을 파라미터로 전달하기 때문에 
        //                  l호출될 때 마다 매번 SQL 문법을 검사하기 때문에 반복실행의 경우 느리다
        //      PreparedStatement : 미리 SQL문을 작성한 다음에 값을 넣기 후
        //                          lexecuteUpdate() 호출한다
        //                          l따라서executeUpdate() 호출할 때마다 SQL문법을 검사하지 
        //                          l않으므로 반복 실행할 때 Statement보다 빠르다
        
        
      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();


  } // main()
} // end of class
