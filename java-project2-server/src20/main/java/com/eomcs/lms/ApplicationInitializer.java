package com.eomcs.lms;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.mybatis.DaoFactory;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

// App 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면 
// ApplicationContextListener 규격에 따라 작성해야 한다.
public class ApplicationInitializer implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      // Mybatis의 SqlSessionFactory 준비
      SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
            "com/eomcs/lms/conf/mybatis-config.xml"));
      
      //l SqlSessionFactory 구현체의 Proxy 만듬
      SqlSessionFactoryProxy sqlSessionFactoryProxy = 
          new SqlSessionFactoryProxy(sqlSessionFactory);
      
      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);
      
      DaoFactory daoFactory = new DaoFactory(sqlSessionFactoryProxy);
      
      //l Dao 인터페이스의 구현체를 자동으로 생성하기
      BoardDao boardDao = daoFactory.create(BoardDao.class);
      LessonDao lessonDao = daoFactory.create(LessonDao.class);
      MemberDao memberDao = daoFactory.create(MemberDao.class);
      PhotoBoardDao photoBoardDao = daoFactory.create(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = daoFactory.create(PhotoFileDao.class);
      
      //l ServerApp이 사용할 객체를 객체 보관소인 ApplicationContext에 담아 return
      //l ==> Command객체가 사용할 DAO구현체 준비
      HashMap<String, Object> beans = new HashMap<String, Object>();
      beans.put("boardDao", boardDao);
      beans.put("lessonDao", lessonDao);
      beans.put("memberDao", memberDao);
      beans.put("photoBoardDao", photoBoardDao);
      beans.put("photoFileDao", photoFileDao);
      beans.put("txManager", txManager);
      
      //l ==> 이 클래스에서 준비한 인스턴스 목록과
      //l     ApplicationContext에서 준비할 인스턴스 패키지 이름을 넘긴다 
      ApplicationContext appCtx = new ApplicationContext("com.eomcs.lms", beans);
      
      //l ServerApp쪽에서 사용할 수 있게 ApplicationContext를 Map에 저장한다
      context.put("applicationContext", appCtx);
      
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}






