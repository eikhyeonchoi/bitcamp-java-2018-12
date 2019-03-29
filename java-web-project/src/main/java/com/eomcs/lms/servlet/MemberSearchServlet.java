package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.ServerApp;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/search")
public class MemberSearchServlet extends HttpServlet{
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    MemberService memberService = 
        ServerApp.iocContainer.getBean(MemberService.class);
    PrintWriter out = response.getWriter();
    
    String keyword = request.getParameter("memberSearch");
    
    List<Member> members = memberService.findByKeyword(keyword);

    out.println("<html><head><title>회원 목록</title><head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='list'>목록으로 돌아가기</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>전화</th> <th>가입일</th> </tr>");
    for (Member member : members) {
      out.println(
          String.format("<tr> "
              + "<td>%d</td> "
              + "<td><a href='detail?no=%1$d'>%s</a></td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "</tr>",
              member.getNo(),
              member.getName(),
              member.getEmail(),
              member.getTel(),
              member.getRegisteredDate()));
    }
    out.println("</table>");
    out.println("</body></html>");
  }
  
  
}
