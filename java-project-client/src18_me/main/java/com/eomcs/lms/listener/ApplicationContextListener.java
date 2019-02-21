package com.eomcs.lms.listener;

import java.util.HashMap;

public interface ApplicationContextListener {
  void init(HashMap<String,Object> map);
  void destroy(HashMap<String,Object> map);

}
