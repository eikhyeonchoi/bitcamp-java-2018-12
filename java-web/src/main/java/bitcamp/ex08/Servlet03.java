// 리다이렉트 - 응답할 때 콘텐트를 보내지 않는다 바로 다른페이지를 요청하라고 명령한다
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex08/s3")
public class Servlet03 extends HttpServlet {

  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
          throws ServletException, IOException {

    // Redirect
    // ==> 클라이언트의 요청을 받은 후 콘텐트를 보내는 대신
    //     다른 페이지의 URL을 알려줄 때 사용한다
    // ==> 웹 브라우져는 응답받는 즉시 해당 페이지를 요청한다
    //     웹 서버로 부터 콘텐트를 받지 않았기 때문에 어떤 것도 출력하지
    //     않고 바로 다른 페이지로 이동한다
    // ==> 리프레시와 달리 서버는 콘텐트(meesage-body)를 보내지 않는다
    // ==> 사용 예 : 
    //     로그인 후 로그인 결과를 출력하지 않고 즉시 메인화면으로 보내고 싶을 때
    //     결제 완료 후 결과를 출력하지 않고 즉시 결제 상태페이지로 보내고 싶을 때

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // HTML을 출력하는 경우
    // 응답 헤더가 아니라 HTML 헤더에 Refresh명령을 설정할 수 있다

    out.println("<html>");

    out.println("<head>");
    out.println("<title>리다이렉트</title>");
    out.println("</head><body>");
    out.println("안녕하세요!! /ex08/s1");
    out.println("</body></html>");

    // 웹서버 root : 8080 다음 "/" ==> 이건 브라우져가 보는 주소
    // 웹어플리케이션 root == 컨텍스트 root : java-web 다음 "/" ==> 이건 서블릿이 보는주소
    
    // 클라이언트에게 URL을 알려줄 때 상대 경로를 지정할 수 있다
    // forward / include 와 달리 '/' 는 컨텍스트 루트가 아닌 웹서버 루트를 의미한다
    response.sendRedirect("/java-web/ex08/s100"); // 상대 경로 지정가능
    
    // 리다이렉트를 하는 순간 이전까지 버퍼로 출력된 내용을 모두 버려진다
    // 왜? 리다이렉트를 클라이언트로 콘텐트를 보내지 않는다
    // 만약 출력한 내용이 버퍼를 꽉 채워서 자동으로 응답을 하면 
    // response.sendRedirect()는 적용되지 않는다        
  } // service

} // end of class

