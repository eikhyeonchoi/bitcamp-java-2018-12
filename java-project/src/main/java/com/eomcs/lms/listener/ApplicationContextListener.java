package com.eomcs.lms.listener;

import java.util.HashMap;

public interface ApplicationContextListener {
  void init(HashMap<String, Object> context);
  void destroy(HashMap<String, Object> context);
}
