// 스프링 인터셉터 다루기
package bitcamp.app2;

import java.net.URLDecoder;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// ==> 페이지 컨트롤러를 @RestController로 선언하면
//     @ResponseBody를 붙이지 않아도 리턴 값을 HttpMessageConvertor에 의해 자동변환된다

@RequestMapping("/c05_3")
public class Controller05_3 {

  @RequestMapping(value="h1", produces="text/plain;charset=UTF-8")
  public Object handler1(
      int no,
      String title,
      String writer,
      int viewCount) {
    return String.format("%d %s %s %d", no, title, writer, viewCount);
  }
  
  @RequestMapping(value="h2", produces="text/plain;charset=UTF-8")
  public Object handler2(Board board) {
    return board.toString();
  }
  
  @RequestMapping(value="h3", produces="text/plain;charset=UTF-8")
  public Object handler3(@RequestBody String content) throws Exception {
    System.out.println(content);
    System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "ok";
  }
  
  @RequestMapping(value="h4", produces="text/plain;charset=UTF-8")
  public Object handler4(@RequestBody Map<String, Object> content) throws Exception {
    System.out.println(content);
    // System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "ok";
  }
  
  @RequestMapping(value="h5", produces="text/plain;charset=UTF-8")
  public Object handler5(@RequestBody Board board) throws Exception {
    System.out.println(board);
    return "ok";
  }
  
  
}













