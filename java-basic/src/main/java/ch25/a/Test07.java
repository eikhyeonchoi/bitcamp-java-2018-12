// java.sql.ResultSet객체 - 서버에서 select의 결과를 가져오기
package ch25.a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test07 {
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111"); ){
      System.out.println("DBMS에 연결 됨");
      try(Statement stmt = con.createStatement()){

        // executeQuery()의 return값은 ResultSet 구현체
        // ResultSet 객체?
        // ==> l서버의 select 실행결과를 가져올 때 사용하는 도구
        // ==> l단 한 개씩 가져옴 , 한번에 가져오는것이 아님
        try (ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");){
          System.out.println("입력성공");

          // next() : 서버에서 한 개의 row(record)를 가져옴
          //          l만약 가져올 레코드가 없으면 false return;
          while(rs.next()) {
            // l서버에서 받아 온 레코드에서 컬럼 값 꺼내기 
            // ==> getXXX(컬럼명) 또는 getXXX(컬럼번호)
            // ==> l정수 값 컬럼 : getInt(), varchar/char/text 문자열 컬럼 : getString()
            // ==> select 문자에서 컬럼의 이름을 지정하는 대신 *를 사용하면
            //     l컬럼의 순서는 테이블을 생성할 때 지정한 컬럼 순서와 같음 즉 테이블의 컬럼순서와 동일
            // ==> l컬럼의 인덱스는 1부터임
            System.out.printf("%d, %s, %s, %s, %s\n",
                rs.getInt("board_id"), 
                rs.getString(2), 
                rs.getString("contents"), 
                rs.getDate(4),
                rs.getInt(5));
          }
        }
      }
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }



  } // main()
} // end of class;
