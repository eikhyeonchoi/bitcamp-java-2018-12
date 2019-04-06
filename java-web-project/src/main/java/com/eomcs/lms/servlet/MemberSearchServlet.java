package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/search")
public class MemberSearchServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = ((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(MemberService.class);
    
    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.list(keyword);

    request.setAttribute("members", members);
    
    response.setContentType("text/html;charset=UTF-8");
    
    if (members.size() == 0) {
      request.setAttribute("error.title", "게시물 변경");
      request.setAttribute("error.content", "해당 번호의 게시물이 없습니다.");
      request.getRequestDispatcher("../error.jsp").include(request, response);
      return;
    }
    
    
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("search.jsp").include(request, response);
    
  }
  
}
