package com.eomcs.lms.servlet2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board2")
public class BoardServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<htm>");
    out.println("<head><title>게시물 관리</title></head>");
    out.println("<body>");

    out.println("<header>");
    out.println("  <img src='http://bitcamp.co.kr/img/logo.jpg' style='height:50px'>");
    out.println("</header>");

    String command = request.getParameter("command");
    RequestDispatcher rd = null;

    if(command == null)
      command="list";
    
    switch(command) {
      case "add":
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/add"); break;
      case "form":
        rd = request.getRequestDispatcher("/board2/form"); break;
      case "detail":
        rd = request.getRequestDispatcher("/board2/detail"); break;
      case "update":
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/update"); break;
      case "delete":
        response.setHeader("Refresh", "1;url=board2?command=list");
        rd = request.getRequestDispatcher("/board2/delete"); break;
      default :
        rd = request.getRequestDispatcher("/board2/list"); 
    } // switch
    rd.include(request, response);

    out.println("<footer>");
    out.println("<hr>");
    out.println("  비트캠프, <address>비트캠프 서울시 서초구 서초동 1327-15 비트아카데미빌딩</address>");
    out.println("</footer>");

    out.println("</body>");
    out.println("</html>");
  }

}










