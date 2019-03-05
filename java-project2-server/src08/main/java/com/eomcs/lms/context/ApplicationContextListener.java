// 어플리케이션의 상태 변경을 보고 받는 옵저버가 구현해야 할 규칙
package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  // App시작시 
  void contextInitialized(Map<String, Object> context) throws ApplicationContextException;
  
  // App 종료시
  void contextDestroyed(Map<String, Object> context) throws ApplicationContextException;
}
