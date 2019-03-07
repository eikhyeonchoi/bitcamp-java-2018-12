//l 조인 데이터 다루기 - 사용 후
package ch26.h;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {
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
    
    //l 조인을 사용할 경우 부모 객체 안에 자식 테이블의 정보를 받을 수 있다
    //l 작업 :
    //l 1) 부모 테이블의 데이터를 받는 클래스(ex: Board)에 
    //l    하위 테이블의 데이터를 받는 필드를 선언
    //l 2) SQL매퍼 파일에서 <resultMap>에 조인정보 추가
    
    Board board = sqlSession.selectOne("board.selectBoardWithAttachFile", no);
    System.out.println(board);
    
    for (AttachFile f : board.getAttachFiles()) {
      System.out.println(" ==> "+f);
    }
    
    System.out.println("-------------------------------------");
  }
}
