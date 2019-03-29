package com.eomcs.lms.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/photoboard/detail")
public class PhotoBoardDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PhotoBoardService photoBoardService = 
        ServerApp.iocContainer.getBean(PhotoBoardService.class);
    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 조회</title><head>");
    out.println("<body><h1>사진 조회</h1>");

    if (board == null) {
      out.println("<p>해당 사진을 찾을 수 없습니다.</p>");
      return;
    }
    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='number' name='no' value='%d' readonly></td>"
        + "</tr>\n",no);
    out.println(String.format(
        "<tr>"
            + "<th>제목</th>"
            + "<td><input type='text' name='title' value='%s'></td>"
            + "</tr>", board.getTitle()));

    out.println(String.format(
        "<tr>"
            + "<td><input type='hidden' name='lessonNo' value='%d'></td>"
            + "</tr>", board.getNo()));

    out.println(String.format(
        "<tr>"
            + "<th>등록일</th>"
            + "<th>%s</th>"
            + "</tr>", board.getCreatedDate()));
    
    out.println(String.format(
        "<tr>"
            + "<th>조회수</th>"
            + "<th>%d</th>"
            + "</tr>", board.getViewCount()));

    out.println(String.format(
        "<tr>"
            + "<th>수업</th>"
            + "<th>%s(%s~%s)</th>"
            + "</tr>", 
            board.getLesson().getTitle(),
            board.getLesson().getStartDate(), 
            board.getLesson().getEndDate()));
    out.println("<tr>");
    out.println("  <th>사진 파일</th>");
    out.println("  <td>");
    
    List<PhotoFile> files = board.getFiles();
    
    for(int i = 0; i < 5; i++) {
      if (files.size() > i) {
        out.printf("<input type='text' name='filePath%d' value='%s'><br>\n", 
            i, files.get(i).getFilePath());
      } else {
        out.printf("<input type='text' name='filePath%d'><br>\n", i);
      }
    } // for
    
    out.println("</td></tr>");
    out.println("</table>");
    
    out.println("<p><a href='list'> 목록 </a>"
        + "<a href='delete?no=" + board.getNo() + "'> 삭제 </a>"
        + "<button type='submit'> 변경 </button>"
        + "</p>");
    out.println("</form>");
    out.println("</body></html>");
  }



} // end of class
