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
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
  
  
  @Override
  public void init() throws ServletException {
    System.out.println("BoardListServlet.init()");
  }
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("BoardListServlet.doGet()");
    
    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.
    BoardService boardService = ((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(BoardService.class);
    
    List<Board> boards = boardService.list();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html><head><title>게시물 목록</title></head>");
    out.println("<body>");
    
    request.getRequestDispatcher("/header").include(request, response);
    
    out.println("<h1>게시물 목록</h1>");
    out.println("<p><a href='add'>새 글</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>제목</th> <th>등록일</th> <th>조회수</th> </tr>");
    for (Board board : boards) {
      out.println(String.format(
          "<tr><td>%d</td> <td><a href='detail?no=%1$d'>%s</a></td> <td>%s</td> <td>%d</td></tr>", 
            board.getNo(), 
            board.getContents(), 
            board.getCreatedDate(), 
            board.getViewCount()));
    }
    out.println("</table>");
    out.println("<a href='../index.html'>처음화면</a>");
    out.println("</body></html>");
    
  }

}










