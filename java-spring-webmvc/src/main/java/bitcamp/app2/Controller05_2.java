// 스프링 인터셉터 다루기
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// ==> 페이지 컨트롤러를 @RestController로 선언하면
//     @ResponseBody를 붙이지 않아도 리턴 값을 HttpMessageConvertor에 의해 자동변환된다

@RequestMapping("/c05_2")
public class Controller05_2 {

  ArrayList<Board> list = new ArrayList<>();
  
  public Controller05_2() {
    list.add(new Board(1, "제목1", "내용1", "홍길동1", 101, Date.valueOf("2019-05-01")));
    list.add(new Board(2, "제목2", "내용2", "홍길동2", 102, Date.valueOf("2019-05-02")));
    list.add(new Board(3, "제목3", "내용3", "홍길동3", 103, Date.valueOf("2019-05-03")));
    list.add(new Board(4, "제목4", "내용4", "홍길동4", 104, Date.valueOf("2019-05-04")));
    list.add(new Board(5, "제목5", "내용5", "홍길동5", 105, Date.valueOf("2019-05-05")));
    list.add(new Board(6, "제목6", "내용6", "홍길동6", 106, Date.valueOf("2019-05-06")));
    list.add(new Board(7, "제목7", "내용7", "홍길동7", 107, Date.valueOf("2019-05-07")));
    list.add(new Board(8, "제목8", "내용8", "홍길동8", 108, Date.valueOf("2019-05-08")));
    list.add(new Board(9, "제목9", "내용9", "홍길동9", 109, Date.valueOf("2019-05-09")));
    list.add(new Board(10, "제목10", "내용10", "홍길동10", 110, Date.valueOf("2019-05-10")));
    list.add(new Board(11, "제목11", "내용11", "홍길동11", 111, Date.valueOf("2019-05-11")));
    list.add(new Board(12, "제목12", "내용12", "홍길동12", 112, Date.valueOf("2019-05-12")));
    list.add(new Board(13, "제목13", "내용13", "홍길동13", 113, Date.valueOf("2019-05-13")));
    list.add(new Board(14, "제목14", "내용14", "홍길동14", 114, Date.valueOf("2019-05-14")));
    list.add(new Board(15, "제목15", "내용15", "홍길동15", 115, Date.valueOf("2019-05-15")));
  }
  
  @GetMapping("h1")
  public Object handler1() {
    return this.list; 
  }
  
  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  public String handler2() {
    return "안녕하세요";
  }
  
  @GetMapping("h3")
  public int handler3() {
    return 100;
  }
  
  @GetMapping("h4")
  public Object handler4() {
    HashMap<String, Object> content = new HashMap<>();
    content.put("v1", 100);
    content.put("v2", "hello");
    return content;
  }
}













