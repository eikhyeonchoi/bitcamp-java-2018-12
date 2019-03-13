package com.eomcs.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DaoFactory {

  SqlSessionFactory sqlSessionFactory;

  public DaoFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @SuppressWarnings("unchecked")
  public <T> T create(Class<T> type) {
    return (T) Proxy.newProxyInstance(
        type.getClassLoader(), 
        new Class[] {type}, 
        invocationHandler);
  }
  


  InvocationHandler invocationHandler = 
      (Object proxy, Method method, Object[] args) -> {
        //l Dao 인터페이스의 메서드를 호출할 때 마다 이 메서드가 호출됨 
        //l 이 메서드에서 할 일은 매퍼파일에서 적절한 SQL을 찾아 실행하는 것

        //l 1) 실행할 SQL 아이디를 준비하기
        //l    SQL 아이디 = 인터페이스명.메서드명
        //l ==> 파라미터로 받은 프록시 객체로부터 인터페이스 이름을 알아낸다
        String sqlId = String.format("%s.%s", 
            proxy.getClass().getInterfaces()[0].getName(),
            method.getName());

        //l 2) 메서드의 return 타입알아낸다
        Class<?> returnType = method.getReturnType();

        //l 3) Sql 문을 실행할 SqlSession객체를 준비한다
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
          System.out.println(sqlId + " 의 SQL을 실행한다");

          //l 4) 리턴 타입에 따라 적절한 SqlSession의 메서드를 호출
          if(returnType == List.class) {
            if(args == null)
              return sqlSession.selectList(sqlId);
            else 
              return sqlSession.selectList(sqlId);

          } else if (returnType == int.class) {
            if(args == null)
              return sqlSession.update(sqlId);
            else
              return sqlSession.update(sqlId, args[0]);

          } else {
            if(args == null)
              return sqlSession.selectOne(sqlId);
            else
              return sqlSession.selectOne(sqlId, args[0]);
          }
        } // try 
      }; // invoke

}


