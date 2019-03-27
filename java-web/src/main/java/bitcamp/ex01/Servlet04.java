//l 서블릿 만들기 - javax.servlet.Servlet 인터페이스 구현
package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex01/s04")
public class Servlet04 extends GenericServlet{
  private static final long serialVersionUID = 1L;
  ServletConfig config;
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet04.service(ServletRequest, ServletResponse)");
  }
  
}
