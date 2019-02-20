// java.sql.Statement - 삭제하기
package ch25.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test11 {
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      try(Statement stmt = con.createStatement()){

        // update 문장은 executeUpdate()를 사용하여 서버에 전달
        int count = stmt.executeUpdate(
            "delete from x_board where board_id > 5");
        // return 값은 delete한 레코드갯수
        System.out.println(count);

      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }



  } // main()
} // end of class;
