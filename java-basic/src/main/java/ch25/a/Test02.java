// DBMS에 연결 - java.sql.Driver 구현체 등록 자동 등록하기
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test02 {
  public static void main(String[] args) {
    try {
      // java.sql.Driver 인터페이스를 구현한 클래스를 로딩하면
      // l해당 클래스에서 자신을 자동으로 DriverManager에게 등록할 것이다
      //    org.mariadb.jdbc.Driver 소스코드 확인할것 
      //    static블록 확인 Driver객체를 만들어 DriverManager에 등록
      // l이 방식의 장점은 소스코드에 특정 클래스를 지정하기 않는다는 것
      // l클래스 이름을 문자열로 전달할 수 있기 때문에
      // l특정 클래스에 종속되지 않게 작성할 수 있다 Test01보다 이방법이 좋음
      Class.forName("org.mariadb.jdbc.Driver");
      
    } catch (Exception e) {
      System.out.println("MariaDB의 java.sql.Driver 구현체를 등록하는 중 오류발생");
      e.printStackTrace();
    }
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb","bitcamp","1111");) {
      System.out.println("DBMS에 연결 성공");
      
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    
    
    
  } // main()
} // end of class;
