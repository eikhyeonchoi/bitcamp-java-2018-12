package com.eomcs.mybatis;

import java.sql.Connection;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

//l SqlSessisonFactory의 작업을 대행하는 역할
//l ==> SqlSession 객체를 달라고 요청을 받으면 무조건 SqlSession객체를 새로 만들어 보내는 것이 아닌
//l     스레드에 보관된 SqlSession 객체를 return하는 일을 함
//l ==> 처음에는 ThreadLocal에 SqlSession이 없으니까 SqlSessionFactory로부터 SqlSession을 만듬
//l ==> 트랜잭션 지원하기
//l     트랜잭션 시작할 때 수동 커밋의 SqlSession 객체를 미리 만들어 스레드에 보관;
//l     트랜잭션을 종료할 때 SqlSession객체를 close()
public class SqlSessionFactoryProxy implements SqlSessionFactory{

  SqlSessionFactory original;
  //l 스레드 로컬에 저장하는 것은 실제 SqlSessionProxy 객체이다
  //l SqlSessionProxy에는 트랜잭션 여부에 따라 close()동작을 다르게 수행
  //l 트랜잭션에 속한 상태일떄는 close()무시
  //l 트랜잭션에 속한 상태가 아닐떄는 close()  
  ThreadLocal<SqlSession> sqlSessionLocal = new ThreadLocal<>();

  public SqlSessionFactoryProxy(SqlSessionFactory original) {
    //l MyBatis에서 제공하는 SqlSessionFactory 구현체를 필드에 보관해 두었다가
    //l 외부에서 요청이 오면 이 객체를 사용해 SqlSession을 만든다
    this.original = original;
  }

  //l 트랜잭션 관리자가 트랜잭션을 시작시키면
  //l 기본적으로 auto-commit이 false인 sqlSession 객체를 미리 만들어 스레드에 보관
  public void prePareForTransaction() {
    //l auto-commit이 false인 SqlSession객체를 준비한다
    SqlSession sqlSession = this.openSession(false);

    //l 트랜잭션을 완료할 때 까지 close()하지 않게 SqlSessionProxy로 포장
    SqlSessionProxy sessionProxy = new SqlSessionProxy(sqlSession, true);

    //l 스레드에 오리지널 sqlSesion객체를 보관하는 것이 아닌
    //l 트랜잭션에 상태에 따라 close() 여부를 결정하는 SqlSessionProxy 객체를 미리 보관
    sqlSessionLocal.set(sessionProxy);
  }

  //l 트랜잭션을 완료한 다음에 SqlSession객체를 스레드에서 제거하기
  public void releaseForTransaction() {
    try {
      //l 트랜잭션을 완료한 다음에 SqlSession 객체를 꺼낸다
      SqlSessionProxy sqlSessionProxy = (SqlSessionProxy) sqlSessionLocal.get();
      
      sqlSessionLocal.remove();

      //l 트랜잭션 사용여부를 false로 설정한다 true로 설정되면 닫지못함 
      sqlSessionProxy.setUseTransaction(false);
      sqlSessionProxy.close();
    } catch(Exception e) {
    }
  }

  //l 스레드에 SqlSession이 보관되어 있으면 그 객체를 return
  //l 없으면 원래대로 SqqlSession객체를 만들어 return
  //l 스레드에 sqlSession이 보관되는 경우는?
  //l ==> 트랜잭션을 시작할 때 auto-commit이 false인 SqlSession
  public SqlSession openSession() {
    SqlSession sqlSession = sqlSessionLocal.get();
    if(sqlSession != null) {
      return sqlSession;
    } else {
      return original.openSession(true); //기본이 auto-commit true
    }
  }
  
  
  

  public SqlSession openSession(boolean autoCommit) {
    return original.openSession(autoCommit);
  }

  public SqlSession openSession(Connection connection) {
    return original.openSession(connection);
  }

  public SqlSession openSession(TransactionIsolationLevel level) {
    return original.openSession(level);
  }

  public SqlSession openSession(ExecutorType execType) {
    return original.openSession(execType);
  }

  public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
    return original.openSession(execType, autoCommit);
  }

  public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
    return original.openSession(execType, level);
  }

  public SqlSession openSession(ExecutorType execType, Connection connection) {
    return original.openSession(execType, connection);
  }

  public Configuration getConfiguration() {
    return original.getConfiguration();
  }






}
