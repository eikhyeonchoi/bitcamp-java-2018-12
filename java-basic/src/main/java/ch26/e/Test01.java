//l SQL 실행할때 파라미터 값 넘기기
package ch26.e;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/e/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    // in-parameter 값을 넘기지 않고 SQL 실행하기 
    List<Board> boards = sqlSession.selectList("board.select1");
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
    
    //l in-parameter에 int 값 넘기기
    //l selectOne(sql, in_parameter)
    //l in-parameter는 Object이고 오토박싱되어 mybatis에 전달
    Board board = sqlSession.selectOne("board.select2",5);
    System.out.println(board);
    
    System.out.println("-------------------------------------");
    
    List<Board> boards2 = sqlSession.selectList("board.select3","용");
    for(Board b : boards2) {
      System.out.println(b);
    }
    
  }
}
