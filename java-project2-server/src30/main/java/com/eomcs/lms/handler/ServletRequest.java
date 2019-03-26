package com.eomcs.lms.handler;

import java.net.URLDecoder;
import java.util.HashMap;

public class ServletRequest {
  HashMap<String, String> paramMap = new HashMap<>();
  
  public void setQueryString(String qs) {
    //l ex) name=aaa&email=aaa@test.com
    String[] params = qs.split("&");
    
    for(String param : params) {
      //l ex) name=aaa
      String[] values = param.split("=");
      try { // 웹 브라우저가 보낸 값을 보관할 때 URL디코딩하여 보관한다
        paramMap.put(
            values[0], 
            URLDecoder.decode(values[1], "UTF-8"));
      } catch(Exception e) { // 디코딩하다 오류발생시 무시
      }
      
    } // for
  } // setQueryString
  
  
  public String getParameter(String name) {
    return paramMap.get(name);
  } // getParameter
}
