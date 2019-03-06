//l selectOne(), selectList()
//l ==>
package ch26.d;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{
    
    String resource = "ch26/d/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l selectList() 
    //l ==> 여러 개의 결과 값을 리턴하는 select를 실행할 때 사용
    //l ==> select 실행으로 생성된 row의 값은 resultType에 지정한 클래스의 인스턴스에 저장된다
    //l ==> 그리고 그 인스턴스는 List구현체에 담겨 return
    List<Board> list = sqlSession.selectList("board.select1");
    for(Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    //l selectOne()
    //l ==> 한 개의 결과 값을 리턴하는 select를 실행하는데 사용
    //l ==> 만약 결과값이 여러개면 예외
//    Board board = sqlSession.selectOne("board.select1");
    Board board = sqlSession.selectOne("board.select2");
    
    //l 정리
    //l select 결과가 한 개의 row? ==> selectOne()
    //l select 결과가 여러 개의 row? ==> selectList()
    
    System.out.println(board);
    
    
    
  }
}
