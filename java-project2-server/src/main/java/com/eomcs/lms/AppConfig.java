package com.eomcs.lms;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

//l 특정 패키지를 탐색하여 @Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성하게 만드는 애노테이션
@ComponentScan(basePackages = "com.eomcs.lms")

//l .properties 파일을 로딩시키는 애노테이션
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")

//l Spring에서 트랜잭션 관리자를 활성화 시킬 때 사용한다
@EnableTransactionManagement

//l mybatis에서 DAO 구현체를 자동 생성하게 할 때 사요앟ㄴ다
@MapperScan("com.eomcs.lms.dao") // DAO 인터페이스가 있는 패키지를 지정한다
public class AppConfig {

  //l @Autowired
  //l ==> 빈 컨테이너에서 지정한 타입의 값을 꺼내 필드에 넣으라는 명령이다
  //l ==> 예) 다음은 빈 컨테이너에서 Environment 타입의 객체를 찾아 env라는 필드에 주소를 주입하라는 뜻
  @Autowired Environment env;
  //l Environment 객체?
  //l @PropertySource 애노테이션에서 지정한 .properties 파일의 값을 꺼내는 일

  //l @Bean
  //l ==> 객체를 생성해주는 메서드(팩토리 메서드)를 표시할 때 사용
  //l ==> Spring IoC 컨테이너는 이 애노테이션이 붙은 메서드를 호출해 그 리턴 값을 보관한다
  //l ==> 객체를 보관할 때 사용할 이름은 Bean애노테이션에 지정한 이름이다
  //l     만약 Bean애노테이션에 이름을 지정하지 않으면 메서드 이름을 사용하여 객체를 보관한다

  //l DB 커넥션 풀 기능을 수행할 DataSource객체를 생성하는 메서드
  //l ==> Spring IoC컨테이너

  @Bean
  public DataSource dataSource() {
    //l DBMS 정보는 jdbc.properties 파일에 있다
    //l Spring IoC 컨테이너에서 주입 받은 env 객체를 사용하여 이 파일의 값을 꺼내면 된다 
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(env.getProperty("jdbc.driver"));
    ds.setUrl(env.getProperty("jdbc.url"));
    ds.setUsername(env.getProperty("jdbc.username"));
    ds.setPassword(env.getProperty("jdbc.password"));
    return ds;
  }

  //l Connection의 commit/rollback을 관리할 트랜잭션 관리자를 생성하는 메서드
  //l ==> 트랜잭션 매니저의 이름은 "transactionManager" 이어야한다
  //l     만약 다른 이름을 사용한다면, 트랜잭션 매니저를 다룰 때 마다
  //l     정확하게 그 이름을 지정해야함    번거로움
  //l ==> Spring은 트랜잭션 관리자로서 PlatformTransactionManager 구현체를 사용함
  //l ==> 트랜잭션 관리자는 Connection을 다루는 일을 하고
  //l     Connection은 DataSource로부터 얻음
  //l     따라서 트랜잭션 관리자를 만드려면 DataSource 객체가 있어야한다
  //l ==> 메서드의 파라미터로 DataSoucre 객체를 요구하라
  //l     그러면 Spring IoC컨테이너가 메서드를 호출할 때 파라미터 값으로 주입해 줄 것이당
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }



  // SqlSessionFactory를 생성하는 메서드
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext appCtx) throws Exception {
    //l mybatis에서 SqlSessionFactory를 생성할 때 사용하라고 제공하는 객체
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

    //l SqlSessionFactory 객체를 생성하는데 필요한 객체를 주입한다
    factoryBean.setDataSource(dataSource);

    //l 도메인 클래스의 별명을 자동으로 생성하도록
    //l 도메인 클래스가 들어 있는 패키지를 지정한다
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");

    //l SQL 매퍼 파일이 있는 패키지를 등록한다
    factoryBean.setMapperLocations(
        appCtx.getResources("classpath:/com/eomcs/lms/mapper/*.xml"));

    return factoryBean.getObject();
  }

  /*ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
  //l DAO 구현체 자동 생성하기  방법 1


  //l ==> mybatis에서 Spring과 함께 사용하라고 제공해주는 SqlSessionTemplete을 사용
  //l ==> @MapperScan 애노테이션을 사용하면 더 간단히 DAO구현체를 생성할 수 있다
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  // BoardDao 객체를 만들어 주는 메서드
  @Bean
  public BoardDao boardDao(SqlSessionTemplate sessionTemplate) throws Exception {
    return sessionTemplate.getMapper(BoardDao.class);
  }

  //MemberDao 객체를 만들어 주는 메서드
  @Bean
  public MemberDao memberDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(MemberDao.class);
  }

  //LessonDao 객체를 만들어 주는 메서드
  @Bean
  public LessonDao lessonDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(LessonDao.class);
  }

  //PhotoBoardDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoBoardDao photoBoardDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoBoardDao.class);
  }

  //PhotoFileDao 객체를 만들어 주는 메서드
  @Bean
  public PhotoFileDao photoFileDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoFileDao.class);
  }
  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

}
