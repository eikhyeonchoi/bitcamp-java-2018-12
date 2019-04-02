// 리프레시 또는 리다이렉트 최종 요청 페이지
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex08/s100")
public class Servlet100 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // 이 서블릿은 직접 실행할 용도로 만든 것이 아니다
    // Refresh / Redirect 요청페이지 용도
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("##########반갑습니다!! /ex08/s100");
  } // service
  
} // end of class

