//l <sql>
package ch26.g;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{

    String resource = "ch26/g/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? : ");
    String keyWord = keyboard.nextLine();
    keyboard.close();
    
    Board board = sqlSession.selectOne("board.select1", Integer.parseInt(keyWord));
    System.out.println(board);
    
    System.out.println("-------------------------------------");
  }
}
