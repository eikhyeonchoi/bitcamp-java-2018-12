// JDBC 드라이버 준비 및 DBMS에 연결
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
  public static void main(String[] args) {
    // DBMS에 연결하기
    // ==> MariaDB에 연결을 대행하는 클래스를 사용한다 (프록시)
    // ==> 이 클래스는 JDBC API 규칙에 따라 작성되었음
    // ==> 이 클래스는 JDBC Driver 파일(*.jar)에 들어있음
    // ==> 이 클래스를 사용하려면 먼저 이 JDBC Driver파일을 다운로드 받아
    //     프로젝트의 CLASSPATH에 등록해야함
    // ==> 절차
    //    1) mvnrepository.com에서 mariadb jdbc drive검색
    //     2) 라이브러리 정보를 build.gradle파일에 설정
    //    3) gradle을 이용해 eclipse 설정 파일을 갱신한다 
    //            > gradle eclipse :
    //                 - 다운로드 받지 않은 라이브러리가 있다면 자동으로 서버에서 받는다
    //                 - 라이브러리 정보가 변경되었다면 라이브러리를 다시받음
    //      4) 새로고침ㄱ Referenced Libraries 추가되었는지 확인
    
    
    // coding
    // 1) java.sql.Driver 구현체를 생성해서 JDBC 드라이버 관리자에 등록
    // ==> Driver 구현체는 JDBC에 정보를 제공하는 클래스
    // ==> l또 DBMS에 연결을 수행하는 객체
    // ==> MariaDB의 JDBC 드라이버에서 org.mariadb.jdbc.Driver 클래스가 이 구현체임
    try {
      DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
      
    } catch (SQLException e) {
      System.out.println("MariaDB의 java.sql.Driver 구현체를 등록하는 중 오류발생");
      e.printStackTrace();
    }
    
    // 2) Driver구현체를 이용해 DBMS에 연결
    // ==> DBMS에 연결되면 소켓정보를 갖고있는 java.sql.Connection 구현체를 return;
    // ==> DriverManager에게 요청한다 + 어느 서버에 접속할 것인지 정보를 제공해야함
    // ==> DriverManager는 이전에 등록된 Driver 구현체에게 위임한다
    // ==> Driver 구현체(org.mariadb.jdbc.Driver 객체)는 DBMS와 연결한 후 소켓 정보를 
    //     java.sql.Connection 구현체에 담아 return
    // ==> DriverManager.getConnection(jdbcurl, username, password);
    //     jdbcUrl = jdbc:(mysql또는mariadb)://서버주소:포트번호/데이터베이스명 
    //     l포트번호를 지정하지 않으면 기본이 3306
    //     username = 데이터베이스를 사용할 수 있는 DBMS에 등록된 사용자
    //     password = 암호
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb","bitcamp","1111");) {
      System.out.println("DBMS에 연결 성공");
      
    } catch(Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생");
      e.printStackTrace();
    }
    
    
    
  } // main()
} // end of class;
