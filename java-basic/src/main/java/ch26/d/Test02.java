//l select 결과 값을 자바 인스턴스에 담는 규칙
package ch26.d;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/d/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l mybatis의 SqlSession "board.select3" SQL문을 실행한 후 
    //l 그 결과는 SQL 매퍼 파일에 지정된 대로 ch26.d.Board2인스턴스에 담아 return
    Board2 board = sqlSession.selectOne("board.select3");
    System.out.println(board);
    
    //l mybatis에서 select 결과를 자바 인스턴스에 담을 때에 규칙
    //l ==> 컬럼 이름과 같은 프로퍼티를 찾아서 값을 담는다 
    //l ==> 자바에서의 프로퍼티란 ??
    //l     setter/getter를 가리키는 용어이다
    //l ==> 프로퍼티 이름?
    //l     setter/getter 이름에서 set/get을 제거한 후, 나머지이름
    //l     단, 첫 알파벳을 소문자로 
    //l ==> 주의 ! 필드이름이 프로퍼티가 아님
    //l                 프로퍼티                      프로퍼티이름
    //l     예) setContents()/getContents() ==>    contents
    
    //l 결론!
    //l Board2 클래스의 프로퍼티이름을 보면 no,title,contents,createdDate,viewCount
    //l 이 프로퍼티중 컬럼이름과 같은 프로퍼티는 title, contents
    //l 그래서 mybatis는 컬럼 이름과 같은 title, contents 프로퍼티에 대해서만 결과값을 매핑
    //l Board2 객체 출력시 title, contents값만 정상 출력
    
    //l 해결책?
    //l ==> 컬럼이름과 프로퍼티이름을 동일하게 하면 되지 않나 
    //l     - DB의 이름 짓는 규칙과 자바의 이름 짓는 규칙은 다르다
    //l     - 또, DBMS마다 이름 짓는 규칙이 다름
    //l     - 자바 프로퍼티 이름을 지을 때 특정 DBMS에 종속되게 지어서는 안됨
    //l     - 자바는 자바규칙대로 DB는 DB 규칙대로
    //l ==> 그럼 우째 ?
    //l     - select시 as 문법으로 자바 프로퍼티이름으로 별명
    //l
    
    
  }
}
