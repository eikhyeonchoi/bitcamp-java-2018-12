//l #{}, ${}
package ch26.f;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07 {
  public static void main(String[] args) throws Exception{
    String resource = "ch26/f/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    HashMap<String, Object> params = new HashMap<String, Object>();

    Scanner keyboard = new Scanner(System.in);
    System.out.print("정렬할 컬럼? : ");
    String column = keyboard.nextLine();
    if(column.length() > 0) { 
      params.put("column", column);
    }

    System.out.print("정렬방식? : ");
    String sort = keyboard.nextLine();
    if(sort.length() > 0) {
      params.put("sort", sort);
    }

    keyboard.close();
    
    //l 정렬할 컬럼 이름과 정렬방식을 값을 전달할 수 없다
    // List<Board> boards = sqlSession.selectList("board.select7_error", params);

    //l 컬럼 이름과 정렬 방식과 같은 SQL키워드를 값으로 전달하려면
    //l SQL 매퍼 파일에서 # 대신 ${프로퍼티명}을 사용 해야함
    //l 문제는 우리가 한 것 처럼(Test07) 사용자 입력값을 그대로 전달하면 SQL삽입 공격에 노출되므로
    //l 절대로 직접 전달해서는 안된다 // 자바 코드에서 만들어 전달할 것 Test07_2 gogo
    List<Board> boards = sqlSession.selectList("board.select7_ok", params);

    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
  }
}
