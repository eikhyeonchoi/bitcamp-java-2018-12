// DBMS에 연결 - java.sql.Driver 구현체 등록 자동 등록하기 2
package ch25.a;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test03 {
  public static void main(String[] args) {
    
    // DriverManager의 getConnection()을 호출할 때 
    // DriverManager는 jdbcURL 정보를 바탕으로 java.sql.Driver 구현체를 찾는다
    // ==> l즉 개발자가 코드로 java.sql.Driver 구현체를 직접 등록하지 않아도,
    //     l또는 java.sql.Driver를 구현한 클래스를 로딩하지 않아도 자동로딩한다
    // ==> l어떻게?
    //     1) JVM이 알고 있는 모든 .jar파일을 찾는다
    //     2) jar파일 안에 META-INF/services/java.sql.Driver파일을 찾는다
    //     3) l이 파일에 등록된 클래스를 로딩한다 org.mariadb.jdbc.Driver 이클래스
    // ==> l그래서 개발자가 따로 java.sql.Driver구현체를 등록하지 않아도 된다
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb","bitcamp","1111");) {
      System.out.println("DBMS에 연결 성공");
      
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    
    
    
  } // main()
} // end of class;
