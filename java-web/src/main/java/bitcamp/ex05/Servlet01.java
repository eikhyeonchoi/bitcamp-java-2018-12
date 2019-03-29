package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s1")
public class Servlet01 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // ServletRequest 의 값으로 HttpServletRequest
    // ServletReponse 의 값으로 HttpServletResponse
    // 따라서 service() 메서드의 파라미터 값은 원래
    // HttpServletRequest와 HttpServletResponse이다
    // 이들 객체는 HTTP 프로토콜을 다루는 메서드가 추가되어 있다
    // 따라서 HTTP 프로토콜을 다루고 싶다면 파라미터 값을
    // 원래의 타입으로 변환해야한다
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    if (httpReq.getMethod().equals("GET")) {
      out.println("GET 요청입니다");
    } else if (httpReq.getMethod().equals("POST")) {
      out.println("POST 요청입니다");
    } else {
      out.println("다루지 못하는 요청방식 입니다");
    }
    
    
  } // service
  
} // end of class




