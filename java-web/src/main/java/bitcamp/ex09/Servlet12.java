// 보관소에 저장된 값 꺼내기
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
@WebServlet("/ex09/s12")
public class Servlet12 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    String v1 = (String) this.getServletContext().getAttribute("v1");
    String v2 = (String) request.getSession().getAttribute("v2");
    String v3 = (String) request.getAttribute("v3");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("보관소에 저장된 값 꺼내기 /ex09/s12");
    out.printf("v1 = %s\n", v1);
    out.printf("v2 = %s\n", v2);
    out.printf("v3 = %s\n", v3);
  } // service
  
} // end of class

