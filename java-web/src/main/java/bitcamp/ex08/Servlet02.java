// 리프레시2 - 클라이언트에게 다른 URL을 요청하라는 명령
package bitcamp.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ex08/s2")
public class Servlet02 extends HttpServlet {
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    
    // Refresh
    // ==> 서버로부터 응답을 받고 내용을 출력한 후 특정 URL을 자동으로 요청하도록 만들 수 있다
    // ==> 보통 웹 페이지를 자동으로 이동시키고 싶을 때 사용한다
    
    // ==> 예1 : 로그인 후 메인페이지로 자동 이동
    //     예2 : 메일을 전송한 후 메일 목록페이지로 자동 이동, 게시글도 마찬가지
    //     예3 : 결제 완료 후 결제 상태페이지로 자동 이동
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // HTML을 출력하는 경우
    // 응답 헤더가 아니라 HTML 헤더에 Refresh명령을 설정할 수 있다
    
    out.println("<html>");
    
    out.println("<head>");
    out.println("<meta http-eqiv='refresh' content='3;url=s100'>");
    out.println("</head>");
    
    out.println("<body>안녕하세요!! /ex08/s1</body>");
    
    out.println("</html>");
    
    
    // 응답 헤더에 Refresh를 추가한다
    // 위에서 벌써 클라이언트에게 응답을 했는데 어떻게 응답헤더를 출력함? 
    // ==> 잊지말자 out.println()이 출력한 것은 출력스트림 Buffer에 보관되어 있다
    //     따라서 아직 클라이언트에게 응답한 상태가 아니다!!!!!!!!
    //     그래서 다음과 같이 출력을 한 후 응답 헤더값을 추가/변경이 가능
    //     메서드 호출이 완료될 때 비로소 클라이언트로 응답헤더와 
    //     버퍼에 저장된 message-body가 출력된다
    
    // 만약 out.print*() 에서 출력한 내용이 버퍼를 꽉 채웠다면 어떻게?
    // ==> 그러면 자동으로 클라이언트에게 응답
    //     따라서 일단 클라이언트에게 응답을하면 다음의 코드는 적용 x
    //     즉 응답을 완료한 후 헤더값을 수정 불가능 
    //     버퍼를 꽉찬 후 보내진다음 header를 설정해도 소용없다는 말...
    
    // 버퍼 강제로 채워서 setHeader() 무효화 하기
    // PrintWrtier의 버퍼를 꽉채우면 자동으로 웹브라우져에게 보내지고
    // 보낸 뒤 실행한 코드는 적용되지 않는다   
//    for(int i = 0; i < 1000; i++) {
//      // 버퍼를 다 채우지 못하면 (8KB) 클라이언트로 응답을 하지 않아 setHeader()가 유효하지만
//      // 버퍼를 넘어서면 (8KB) setHeader()가 무효하다 헤더를 설정하기 전에 이미 버퍼 내용이 출력됨
//      out.println(i + " ===> 1234567890123456789012345678901234567890");
//    } 
    
  } // service
  
} // end of class

