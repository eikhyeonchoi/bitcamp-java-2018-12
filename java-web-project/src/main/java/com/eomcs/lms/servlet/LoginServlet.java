package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  static final String REFERER_URL = "refererUrl";

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    HttpSession session = request.getSession();
    session.setAttribute(REFERER_URL, request.getHeader("Referer"));

    Cookie[] cookies = request.getCookies();
    String email = "";
    if (cookies != null) {
      for (Cookie c : cookies) {
        if (c.getName().equals("email")) {
          email = c.getValue();
          break;
        } // if
      } // for
    } // if

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("login.jsp").include(request, response);

  } // doGet


  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    System.out.println("LoginServlet.doPost()");

    // 이메일 저장을 처리한다. 
    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15); // 15일간 쿠키를 보관한다.
    } else {
      cookie = new Cookie("email", "");
      cookie.setMaxAge(0); // 기존의 쿠키를 제거한다.
    }
    response.addCookie(cookie);

    // 도대체 어느 페이지에서 이리로 보냈나?
    System.out.println(request.getHeader("Referer"));

    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.

    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");

    MemberService memberService = iocContainer.getBean(MemberService.class);

    Member member = memberService.get(
        request.getParameter("email"),
        request.getParameter("password"));

    response.setContentType("text/html;charset=UTF-8");
    if (member == null) {
      response.setHeader("Refresh", "1;url=login");
      request.setAttribute("error.title", "로그인 오류");
      request.setAttribute("error.content", "아이디 또는 비밀번호를 확인해주세요.");
      request.getRequestDispatcher("../error.jsp").include(request, response);
      return;
    }

    HttpSession session = request.getSession();

    // 세션에 로그인 사용자의 정보를 보관한다.
    session.setAttribute("loginUser", member);

    // 로그인 성공하면 다시 메인 화면으로 보낸다.
    String refererUrl = (String) session.getAttribute(REFERER_URL);
    
    if (refererUrl == null || refererUrl.contains("/auth/login")) {
      response.sendRedirect("../");

    } else {
      response.sendRedirect(refererUrl);

    }
  } // doPost


}










