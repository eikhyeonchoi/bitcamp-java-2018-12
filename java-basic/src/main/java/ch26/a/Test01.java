//l Mybatis 설정
//l 1) Mybatis 라이브러리 파일을 프로젝트에 등록
//l    - Maven Repository 에서 mybatis 검색해 라이브러리 정보 알아내기
//l    - build.gradle 파일에 의존 라이브러리 정보 추가
//l    - 'gradle eclipse' 실행해서 라이브러리 다운로드
//l    - 이클립스 프로젝트를 리프레시

//l 2) Mybatis 설정 파일준비
//l    - mybatis.org 에서 문서 페이지 참조
//l    - Mybatis 설정 파일(ex.mybatis-config.xml)을 생성
//l    - 문서 페이지를 참조하여 설정 파일의 내용을 변경

//l 3) SQL 매퍼 파일준비
//l    - SQL이 저장된 파일 준비
//l    - mybatis.org 에서 문서 페이지 참조
//l    - SQL이 들어있는 파일(예: BoardMapper.xml)을 생성한다
//l    - 문서 페이지를 참조해 매퍼 파일의 내용을 변경한다

//l 4) select 결과를 저장할 클래스 정의
//l    - ch26.a.Board 클래스 생성
//l    - 필드는 컬럼의 이름과 같게 한다

//l 5) select SQL을 실행
//l    - mybatis.org 에서 문서 페이지 참조
//l    - 관련 객체를 생성하고 사용하여 SQL문을 실행한다
package ch26.a;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {
  public static void main(String[] args) throws Exception{
    
    //l 1) mybatis 설정 파일을 읽을 때 사용할 도구를 준비한다
    //l     ==> 파일 입력 스트림 객체 준비
    //l     ==> FileInputStream 객체를 직접 생성해도 되지만
    //l         직접 생성하려면 설정 파일의 전체 경로를 정확하게 지정해야한다
    //l         만약 경로가 바뀌면 소스의 경로를 다시 변경해야 하는 문제가있다
    //l     ==> mybatis 설정 파일이 자바 클래스 파일(.class)처럼 CLASSPATH에 있다면
    //l         Resources.getResourceAsStream()을 호출해 입력스트림 준비하는 것이 좋다 
    String resource = "ch26/a/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    
    //l 2) mybatis 설정 파일에 따라 동작할 SQL 실행도구를 준비
    //l     ==> SqlSessionFactoryBuilder : SqlSessionFactory를 만들어 주는 일
    //l         - builder 디자인 패턴 적용 
    //l         - 여러 객체를 조립해 한 객체를 생성하는 경우 직접 하는 대신에 빌더를 통해 생성
    
    //l     ==> SqlSessionFactory : SqlSession를 만들어 주는 일
    //l         - Factory Method디자인 패턴적용
    
    //l     ==> SqlSession : SQL매퍼 파일에 보관된 SQL을 찾아 실행해주는 일
    
    //l Builder가 Factory 객체 만들고 Factory가 Session 객체 만들고 Session이 SQL찾아 실행
    //l Builder가 Factory의 공장 Factory가 Session의 공장
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    //l 3) 팩토리 메서드를 통해 객체 생성
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    //l 4) SQL 매퍼 파일에 보관된 SQL 문을 찾아 실행한다
    //l     - 파라미터 값은 SQL문의 id이다
    //l     - SQL 매퍼 파일의 namespace 값과 SQL ID 값을 결합 해서 지정한다
    //l     - selectList()의 리턴 값은 SQL 매퍼 파일의 resultType에 지정된 객체를 담고 있는
    //l       List객체이다
    
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
