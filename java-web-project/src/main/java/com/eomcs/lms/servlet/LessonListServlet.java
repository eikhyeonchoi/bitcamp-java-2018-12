package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@SuppressWarnings("serial")
@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet{
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    LessonService lessonService =
        ServerApp.iocContainer.getBean(LessonService.class);
    
    PrintWriter out = response.getWriter();
    List<Lesson> lessons = lessonService.list();

    out.println("<html><head><title>수업 목록</title><head>");
    out.println("<body><h1>수업 목록</h1>");
    out.println("<p><a href='add'> 새 수업 </a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>제목</th> <th>등록일</th> <th>조회수</th> <th>수업 번호</th> </tr>");
    for (Lesson lesson : lessons) {
      out.println(
          String.format("<tr> "
              + "<td>%d</td> "
              + "<td><a href='detail?no=%1$d'>%s</a></td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "<td>%d</td> "
              + "</tr>",
              lesson.getNo(),
              lesson.getTitle(),
              lesson.getStartDate(),
              lesson.getEndDate(),
              lesson.getTotalHours()));
    }
    out.println("</table>");
    out.println("</body></html>");
  }
  
  
}
