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
@WebServlet("/photoboard/add")
public class PhotoBoardAddServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>새 사진</title></head>");
    out.println("<body>");
    out.println("<h1>새 사진</h1>");
    out.println("<form action='add' method='post'>");
    out.println("<table border='1'>");

    out.println("<tr>");

    out.println("<tr>");
    out.println("<th>제목</th>");
    out.println("<td><input type='text' name='title'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업 번호</th>");
    out.println("<td><input type='number' name='lessonNo'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td colspan='2'>최소 한개의 사진을 입력해야 합니다</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업사진 1</th>");
    out.println("<td><input type='text' name='photoFile1'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업사진 2</th>");
    out.println("<td><input type='text' name='photoFile2'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업사진 3</th>");
    out.println("<td><input type='text' name='photoFile3'></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<th>수업사진 4</th>");
    out.println("<td><input type='text' name='photoFile4'></td>");
    out.println("</tr>");
    out.println("<tr>");

    out.println("<th>수업사진 5</th>");
    out.println("<td><input type='text' name='photoFile5'></td>");
    out.println("</tr>");
    out.println("<tr>");

    out.println("</tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("<button type='submit'>등록</button>");
    out.println("<a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PhotoBoardService photoBoardService = 
        ServerApp.iocContainer.getBean(PhotoBoardService.class);
    
    PrintWriter out = response.getWriter();
    
      PhotoBoard board = new PhotoBoard();
      board.setTitle(request.getParameter("title"));
      int lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
      board.setLessonNo(lessonNo);

      ArrayList<PhotoFile> files = new ArrayList<>();
      for(int i = 1; i <= 5; i++) {
        String filePath = request.getParameter("photoFile"+i);
        if(filePath.length() == 0) 
          continue;
        PhotoFile file = new PhotoFile();
        file.setPhotoBoardNo(lessonNo);
        file.setFilePath(filePath);
        files.add(file);
      }
      board.setFiles(files);

      out.println("<html><head>"
          + "<title>사진 등록</title>"
          + "<meta http-equiv='Refresh' content='1;url=list'>"
          + "</head>");
      out.println("<body><h1>사진 등록</h1>");
      if(files.size() == 0) {
        out.println("<p>최소 한개 사진파일을 입력해야 합니다</p>");
      } else {
        photoBoardService.add(board);
        out.println("<p>저장했습니다</p>");
      }

      out.println("</body></html>");

  }
  

  


} // end of class
