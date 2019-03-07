//l update delete 
package ch26.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/e/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Board board = new Board();
    board.setNo(5);
    board.setTitle("xxxxxxxx");
    board.setContents("내용입니다");

    int count = sqlSession.delete("board.delete", 41);
    System.out.println(count);
    System.out.println("-------------------------------------");
    
    sqlSession.commit();
    
    List<Board> boards = sqlSession.selectList("board.select1");
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
