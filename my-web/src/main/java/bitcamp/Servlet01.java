//l 서블릿 만들기 - javax.servlet.Servlet 인터페이스 구현
package bitcamp;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet01 implements Servlet{
  
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    //l 서블릿 객체를 생성한 후 생성자 다음에 이 메서드가 호출된다
    //l ==> 서블릿을 실행할 때 사용할 자원을 이 메서드에서 준비한다
    //l ==> 파라미터로 받은 ServletConfig객체는 인스턴스 변수에 보관해 두었다가 필요할 때 사용
    this.config = config;
    System.out.println("Servlet01.init()");
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet01.service(ServletRequest, ServletResponse)");
  }
  
  @Override
  public void destroy() {
    System.out.println("Servlet01.destroy()");
  }
  
  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet01.getServletConfig()");
    return this.config;
  }
  
  @Override
  public String getServletInfo() {
    System.out.println("Servlet01.getServletInfo()");
    return "Servlet01";
  }
  
}
