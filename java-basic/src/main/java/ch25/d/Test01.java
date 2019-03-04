// insert 한 뒤 auto increment PK값 return 받기 
package ch25.d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      
      System.out.print("제목? ");
      String title = keyboard.nextLine();
      System.out.print("내용? ");
      String contents = keyboard.nextLine();
      
      // 입력한 후 PK값을 리턴 받고 싶다면,
      // PreparedStatement 객체를 얻을 때 다음과 같은 옵션지정
      // ==> PreparedStatement(sql, 0자동생성된 PK값 리턴 여부)
      try(PreparedStatement stmt = con.prepareStatement(
          "insert into x_board(title, contents) values(?, ?)", 
          Statement.RETURN_GENERATED_KEYS)){
        
        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.executeUpdate();
        
        // insert 수행 후 자동 생성된 PK값을 요구 해야한다
        int no = 0;
        try(ResultSet rs = stmt.getGeneratedKeys();) {
          // insert를 한 개만 했기 때문에 PK도 한 개만 생성되었다
          // 따라서 ResultSet에 대해 여러번 반복 x
          rs.next();
          
          // 자동 생선된 PK값을 꺼낼 때는 따로 컬럼 이름이 없기 때문에 컬럼인덱스로 꺼낸다
          no = rs.getInt(1);
        }
        
        System.out.println("입력 성공");
        System.out.println("입력된 게시물 번호 : " + no);
      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    keyboard.close();


  } // main()
} // end of class
