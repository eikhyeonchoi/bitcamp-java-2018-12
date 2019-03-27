//l 서블릿 만들기 - javax.servlet.Servlet 인터페이스 구현
package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet03 extends HttpServlet{
  private static final long serialVersionUID = 1L;
  ServletConfig config;
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet03.doGet(HttpServletRequest, HttpServletResponse)");
  }
  
}
