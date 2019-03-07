//l SQL 실행할때 파라미터 값 넘기기 - 도메인 객체 넘기기 
package ch26.e;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/e/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l insert 문을 실행할 때는 insert() 메서드 호출
    //l ==> 그러나 update(), delete() 메서드를 호출해도 된다
    //l     왜? insert,update,delete 모두 JDBC에서 executeUpdate()를 호출하기 때문임
    //l ==> 하지만 SQL의 명령과 메서드 이름을 가능한 같게하라
    Board board = new Board();
    board.setTitle("제목입니다");
    board.setContents("내용입니다");

    //l insert(sql id, 객체) return값은 insert된 row갯수
    int count = sqlSession.insert("board.insert1", board);
    System.out.println(count);
    System.out.println("-------------------------------------");
    
    //l insert할 때 파라미터를 맵 객체에 담아 넘겨도 된다
    //l ==> Map 객체에 값을 저장할 때 사용하는 key 값은 SQL맵퍼에서 프로퍼티명임
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("title", "제제제제목목목목");
    map.put("contents", "내내내내용용용용");
    count = sqlSession.insert("board.insert2",map);
    System.out.println(count);
    System.out.println("-------------------------------------");
    
    //l 주의 !!
    //l ==> mybatis는 auto-commit이 false이다
    //l ==> 데이터 변경 작업을 수행한 후 반드시 commit을 호출해야함
    sqlSession.commit();
    
    List<Board> boards = sqlSession.selectList("board.select1");
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
