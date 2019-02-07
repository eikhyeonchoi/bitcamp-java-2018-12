package com.eomcs.lms.listener;

import java.util.Map;

public interface ApplicationContextListener {
  void startApp(Map<String, Object> context);
  void endApp(Map<String, Object> context);
  

}
