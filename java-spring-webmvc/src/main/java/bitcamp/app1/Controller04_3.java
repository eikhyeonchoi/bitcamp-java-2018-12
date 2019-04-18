// request handler를 구분하는 방법 - 파라미터 이름으로 구분하기
package bitcamp.app1;

import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/c04_3")
public class Controller04_3 {

  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      String model,
      String maker,
      int capacity,
      boolean auto,
      Car car
      ) {
    
    out.printf("model= %s\n", model);
    out.printf("maker = %s\n", maker);
    out.printf("capacity = %d\n", capacity);
    out.printf("auto = %b\n", auto);
    out.printf("car = %s\n", car);
  }
  
}
