//l Mybatis 설정 2
//l ==> DB 접속 정보를 mybatis 설정 파일로부터 분리해 저장한다
//l ==> DB 접속 정보를 분리하면 DB 접속 정보가 변경 되었을 때
//l     설정 파일에 영향을 주지않고 바꿀 수 있어 실무에서 사용
package ch26.b;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{
    
    //l 1) jdbc.properties 파일을 추가한다
    //l    ==> 이 파일에 DB 접속 정보를 저장
    //l 2) mybatis-config.xml 변경
    //l    ==> DB 접속 정보를 설정할 때 jdbc-properties파일의 데이터를 사용
    //l 3) BoardMapper.xml 변경 
    //l    ==> 클래스의 패키지명을 변경
    String resource = "ch26/b/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    List<Board> list = sqlSession.selectList("board.select1");
    for(Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getBoard_id(),
          b.getTitle(),
          b.getContents(),
          b.getCreated_date(),
          b.getView_count());
    }
    
    
    
  }
}
