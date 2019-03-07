//l dynamic SQL 다루기 - 조건문
package ch26.f;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{

    String resource = "ch26/f/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l dynamic SQL
    //l ==> 조건에 따라 SQL이 변경되는것
    //l ==> mybatis는 이를 위해 조건문, 반복문 등을 다룰 수 있게 특별한 태그를 제공
    
    //l 조건문 사용
    //l ==> 검색어의 여부에 따라 where절을 추가할지 말지 결정
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? : ");
    String keyWord = keyboard.nextLine();
    keyboard.close();
    
    List<Board> boards = null;
    try {
      boards = sqlSession.selectList("board.select1", Integer.parseInt(keyWord));
      
    } catch(Exception e) {
      boards = sqlSession.selectList("board.select1");
    }
    
    for(Board b : boards) {
      System.out.println(b);
    }
    System.out.println("-------------------------------------");
  }
}
