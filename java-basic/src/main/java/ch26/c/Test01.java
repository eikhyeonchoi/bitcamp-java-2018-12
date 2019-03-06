//l Mybatis 설정 3
//l ==> 도메인 클래스에 별명 부여
//l ==> SQL 매퍼 파일에서 데이터를 리턴하거나 파라미터로 데이터를 받을 때
//l     클래스의 전체 이름(패키지 이름 포함)을 지정 해야한다
//l ==> 패키지이름이 길 경우 사용하기 번거로움
//l     그래서 클래스 전체 이름에 대해 별명을 지정하여 사용
package ch26.c;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{
    
    //l 1) mybatis-config.xml 변경
    //l     - 클래스 전체 이름에 대해 별명 지정
    //l 2) BoardMapper.xml 변경
    //l     - 결과를 담을 클래스를 지정할 때 클래스 전체 이름을 사용하는 대신
    //l     - mybatis 설정 파일에 등록된 별명을 사용할 수 있다
    
    String resource = "ch26/c/mybatis-config.xml";
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
