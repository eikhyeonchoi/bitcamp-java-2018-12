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
@RequestMapping("/c04_2")
public class Controller04_2 {

  @GetMapping("h1") 
  @ResponseBody 
  public void handler1(
      PrintWriter out,
      ServletRequest request,
      @RequestParam(value = "name") String name1,
      @RequestParam(name = "name") String name2,
      @RequestParam("name") String name3,
      String name
      ) {
    
    out.printf("name= %s\n", request.getParameter("name"));
    out.printf("name = %s\n", name1);
    out.printf("name = %s\n", name2);
    out.printf("name = %s\n", name3);
    out.printf("name = %s\n", name);
  }
  
  @GetMapping("h2") 
  @ResponseBody 
  public void handler2(
      PrintWriter out,
      @RequestParam("name1") String name1,
      String name2,
      @RequestParam(value = "name3", required = false) String name3,
      @RequestParam(value = "name4", defaultValue = "ohora") String name4
      ) {
    out.printf("name1 = %s\n", name1);
    out.printf("name2 = %s\n", name2);
    out.printf("name3 = %s\n", name3);
    out.printf("name4 = %s\n", name4);
  }
  
}
