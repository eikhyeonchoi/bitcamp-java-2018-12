package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eomcs.lms.service.FaceBookService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서 
// 비즈니스 로직을 담당하는 객체는 
// 특별히 그 역할을 표시하기 위해 @Component 대신에 @Service 애노테이션을 붙인다.
// 이렇게 애노테이션으로 구분해두면 나중에 애노테이션으로 객체를 찾을 수 있다.
@Service
public class FacebookServiceImpl implements FaceBookService {
  
  @SuppressWarnings("unchecked")
  @Override
  public Map getLoginUser(String accessToken) {
    // Facebook의 Graph API 실행하기
    // => HTTP 요청을 할 때 스프링에서 제공하는 RestTemplate을 사용하라! 
    RestTemplate restTemplate = new RestTemplate();
    
    HashMap<String,String> values = new HashMap<>();
    values.put("v1", accessToken);
    values.put("v2", "id,name,email");
    
    // 원격 서버에서 보낸 JSON 문자열을 Map 객체로 자동 변환하려면
    // JSON 문자열을 처리하는 라이브러리를 추가해 둬야 한다.
    // 따로 코드를 추가할 필요는 없다.
    // => Gson 또는 Jackson 라이브러리
    // 
    @SuppressWarnings("rawtypes")
    Map response = restTemplate.getForObject(
        "https://graph.facebook.com/v3.3/me?access_token={v1}&fields={v2}", 
        Map.class, // 서버에서 리턴받을 타입을 지정하는 것
        // accessToken,
        // "id,name,email"
        values);
    
    
    return response;
  }
  
  
}







