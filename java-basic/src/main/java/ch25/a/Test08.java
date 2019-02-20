// java.sql.ResultSet객체 - 서버에서 select의 결과를 가져오기 2
package ch25.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test08 {
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      try(Statement stmt = con.createStatement()){

        try (ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc"); ){
          System.out.println("입력성공");

          while(rs.next()) {
            // l레코드에서 컬럼 값을 꺼낼 때 컬럼 번호를 지정하는 것 보다
            // l이름을 지정하는것이 유지보수에 좋음
            System.out.printf("%d, %s, %s, %s, %s\n",
                rs.getInt("board_id"), 
                rs.getString("title"), 
                rs.getString("contents"), 
                rs.getDate("created_date"),
                rs.getInt("view_count"));
          } // while
        }
      }

    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }



  } // main()
} // end of class;
