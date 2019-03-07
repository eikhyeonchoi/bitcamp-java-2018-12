//l update delete 
package ch26.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/e/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Board board = new Board();
    board.setTitle("xxxxxxxx");
    board.setContents("내용입니다");

    sqlSession.insert("board.insert1", board);
    System.out.println(board);

    //l insert 한 후 자동 생성된 PK값을 알아내려면
    //l SQL매퍼 파일에 SQL문을 정의할 때 PK값을 리턴해달라고 해야한다
    sqlSession.insert("board.insert3", board);
    System.out.println(board);
    
    System.out.println("-------------------------------------");
    List<Board> boards = sqlSession.selectList("board.select1");
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
    
    
    
    
  }
}
