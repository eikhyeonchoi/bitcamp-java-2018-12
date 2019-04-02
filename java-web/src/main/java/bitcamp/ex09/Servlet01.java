// 보관소에 값 넣기
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
@WebServlet("/ex09/s1")
public class Servlet01 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v1", "aaa");
    
    // 2) HttpSession 보관소에 값 넣기
    // ==> 이 요청을 한 클라이언트에 HttpSession 객체가 없다면 만들어준다
    HttpSession session = request.getSession();
    session.setAttribute("v2", "bbb");
    
    request.setAttribute("v3", "cccc");
    
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("보관소에 값을 넣었습니다!! /ex09/s1");
  } // service
  
} // end of class

