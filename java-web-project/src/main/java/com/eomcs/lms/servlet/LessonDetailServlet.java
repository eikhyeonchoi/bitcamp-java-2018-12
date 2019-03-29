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
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet{
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    LessonService lessonService =
        ServerApp.iocContainer.getBean(LessonService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));

    Lesson lesson = lessonService.get(no);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>수업 조회</title><head>");
    out.println("<body><h1>수업 조회</h1>");
    
    if (lesson == null) {
      out.println("<p>해당 번호의 수업이 없습니다.</p>");
      return;
    }
    
    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='text' name='no' value='%d' readonly></td>"
        + "</tr>\n",no);
    out.println(String.format(
              "<tr>"
            + "<th>제목</th>"
            + "<td><input type='text' name='title' value='%s'></td>"
            + "</tr>", lesson.getTitle()));
    out.println(String.format(
        "<tr>"
            + "<th>내용</th>"
            + "<td><textarea name='contents' rows='3' cols='30'>%s</textarea></td>"
            + "</tr>", lesson.getContents()));
    out.println(String.format(
        "<tr>"
            + "<th>수업 시작일</th>"
            + "<td><input type='date' name='startDate' value='%s'></td>"
            + "</tr>", lesson.getStartDate()));
    out.println(String.format(
        "<tr>"
            + "<th>수업 종료일</th>"
            + "<td><input type='date' name='endDate' value='%s'></td>"
            + "</tr>", lesson.getEndDate()));
    out.println(String.format(
        "<tr>"
            + "<th>총 수업 시간</th>"
            + "<td><input type='number' name='totalHours' value='%d'></td>"
            + "</tr>", lesson.getTotalHours()));
    out.println(String.format(
        "<tr>"
            + "<th>일 수업 시간</th>"
            + "<td><input type='number' name='dayHours' value='%d'></td>"
            + "</tr>", lesson.getDayHours()));

    out.println("</table>");
    
    out.println("<p><a href='list'> 목록 </a>"
        + "<a href='delete?no="+lesson.getNo()+"'> 삭제 </a>"
        + "<button type='submit'> 변경 </button>"
        + "</p>");
    out.println("</form>");
    out.println("</body></html>");
  }
  
  
  
}
