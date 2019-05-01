// 스프링 인터셉터 다루기
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;


// Controller05_1, 2
// 클라이언트쪽으로 JSON데이터로 보내는 것 
@Controller 
@RequestMapping("/c05_1")
public class Controller05_1 {

  ArrayList<Board> list = new ArrayList<>();
  
  public Controller05_1() {
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
  
  // 1) JSP에서 JSON형식의 콘텐트 출력 // 쌩으로 출력하기
  @GetMapping("h1")
  public void handler1(Model model) {
    model.addAttribute("list", this.list);
  }

  // gson 라이브러리 사용 1
  @GetMapping(value="h2", produces="text/plain; charset=UTF-8")
  @ResponseBody // return하는 String이 jsp주소가 아니라 클라이언트로 출력하라는 명령
  public String handler2() {
    return new Gson().toJson(this.list);
  }

  // gson 라이브러리 사용 2
  // 페이지 컨트롤러의 리턴 값이 String이 아니면
  // 프론트 컨트롤러가 (GSON 또는 Jackson)라이브러리를 사용해 
  // 자동으로 JSON 형식의 문자열로 만들어 클라로 출력
  @GetMapping("h3")
  @ResponseBody // return하는 String이 jsp주소가 아니라 클라이언트로 출력하라는 명령
  public Object handler3() {
    // JSON 형식의 문자열은 자동으로 UTF-8로 인코딩
    return this.list; 
  }
}













