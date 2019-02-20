// java.sql.Startement객체 - SQL을 DBMS서버에 전달한다
package ch25.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test06 {
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      
      // Connection객체를 통해 SQL을 DBMS에 전달할 때 사용할 도구를 얻는다
      // ==> java.sql.Statement 구현체
      try(Statement stmt = con.createStatement()){
        
        // Statement구현체를 이용해 SQL문을 서버에 전달
        // executeUpdate() : insert, update, delete 등 DDL, DML 문법을 전달
        // executeQuery() : select문법을 전달
        // execute() : 모든 SQLans 전달
        // executeBatch() : 여러개의 SQL문을 전달
        int count = stmt.executeUpdate("insert into x_board(title, contents)"
            +" values('JDBC이용해서 넣음','내용')");
        
        
        // executeUpdate()의 return 값은 SQL을 실행한 후 입력, 변경, 삭제된 
        // row(record)의 갯수이다 
        System.out.println(count);
        System.out.println("입력성공");
        
        
      }
      
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    
    
    
  } // main()
} // end of class;
