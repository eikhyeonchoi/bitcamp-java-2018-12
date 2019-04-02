// 보관소에 값 넣기 - forward 서블릿끼리 ServletRequest 공유 테스트
package bitcamp.ex09;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ex09/s11")
public class Servlet11 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "xxx");
    
    // 2) HttpSession 보관소에 값 넣기
    // ==> 이 요청을 한 클라이언트에 HttpSession 객체가 없다면 만들어준다
    HttpSession session = request.getSession();
    session.setAttribute("v2", "yyy");
    
    request.setAttribute("v3", "zzzz");

    // 주목! 
    // ==> forward(include)할 때 이 서블릿이 파라미터로 받은
    //     ServletRequest와 ServletResponse를 전달한다
    // ==> 따라서 forward/include 서블릿들은 응답을 완료할 때 까지 공유한다
    request.getRequestDispatcher("s12").forward(request, response);
    
   
    
  } // service
  
} // end of class

