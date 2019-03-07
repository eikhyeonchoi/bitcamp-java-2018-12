//l 조인 데이터 다루기 - 사용 전
package ch26.h;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{

    String resource = "ch26/h/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l 조인안하고 자식 테이블 조회 시 sql 두번이상 실행 해야함 ㅈㄴ 귀찮음
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? : ");
    int no = Integer.parseInt(keyboard.nextLine());
    keyboard.close();
    
    Board board = sqlSession.selectOne("board.selectBoard", no);
    System.out.println(board);
    
    List<AttachFile> files = sqlSession.selectList("board.selectAttachFile", no);
    for (AttachFile f : files) {
      System.out.println(" ==> "+f);
    }
    
    System.out.println("-------------------------------------");
  }
}
