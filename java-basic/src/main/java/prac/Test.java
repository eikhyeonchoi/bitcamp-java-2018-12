package prac;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
  public static void main(String[] args) throws Exception{
    String resource = "prac/mybatis-config.xml";

    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    List<Board> list = sqlSession.selectList("board.selectAll");
    for(Board temp : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          temp.getNo(),
          temp.getTitle(),
          temp.getContents(),
          temp.getCreatedDate(),
          temp.getViewCount());
    }

    System.out.println("-----------------------------------------");

    Board board = sqlSession.selectOne("board.selectOne");
    System.out.println(board);

    System.out.println("-----------------------------------------");

    List<Map> maps = sqlSession.selectList("board.selectAllToMap");
    for(Map map : maps) {
      System.out.println(map.get("title"));
    }
    
    System.out.println("-----------------------------------------");
    
    Map tempMap = sqlSession.selectOne("board.selectOneToMap");
    System.out.println(tempMap.get("title"));
    
    System.out.println("-----------------------------------------");
    
    Board tempBoard = sqlSession.selectOne("board.selectParameter",9);
    System.out.println(tempBoard);
    
    System.out.println("-----------------------------------------");
    
    Board insertBoard = new Board();
    insertBoard.setTitle("Commit ");
    insertBoard.setContents("테스트 입니다");
    int count = sqlSession.insert("board.insertGo", insertBoard);
    System.out.println(count);
    sqlSession.commit();
    
    


    
    
    
    


  } // main
} // end of class
