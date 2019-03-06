//l select 결과 값을 자바 인스턴스에 담는 규칙
package ch26.d;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/d/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    
    //l select 문제엇 컬럼 값을 자바 인스턴스의 프로퍼티와 맞추기 위해
    //l 별명을 부여하는 방식은 번거로움
    //l 특히 컬럼개수가 많으면 번거로움
    //l 이를 해결하기 위해 컬럼의 이름과 프로퍼티 이름을 연결해주는 문법제공
    Board2 board = sqlSession.selectOne("board.select5");
    System.out.println(board);
    
    
  }
}
