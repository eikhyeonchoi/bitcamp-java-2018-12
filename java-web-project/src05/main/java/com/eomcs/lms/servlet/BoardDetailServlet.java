package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    // 
    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.
    
    BoardService boardService = ((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Board board = boardService.get(no);
    
    // JSP가 사용할 수 있게 ServletRequest보관소에 저장한다
    request.setAttribute("board", board);
    request.getRequestDispatcher("/board/detail.jsp").include(request, response);
    
  }

}










