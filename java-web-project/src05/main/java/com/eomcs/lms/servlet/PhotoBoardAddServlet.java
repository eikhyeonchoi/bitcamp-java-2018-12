package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.PhotoBoardService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
@WebServlet("/photoboard/add")
@SuppressWarnings("serial")
public class PhotoBoardAddServlet extends HttpServlet {

  String uploadDir; 

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath(
        "/upload/photoboard");
  } // init

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LessonService lessonService = ((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(LessonService.class);

    response.setContentType("text/html;charset=UTF-8");
    List<Lesson> lessons = lessonService.list();
    
    request.setAttribute("lessons", lessons);
    request.getRequestDispatcher("form.jsp").include(request, response);
  } // doGet

  
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService =
        ((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);

    PhotoBoard board = new PhotoBoard();
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

    ArrayList<PhotoFile> files = new ArrayList<>();
    Collection<Part> photos = request.getParts();

    for (Part photo : photos) {
      if (photo.getSize() == 0 || !photo.getName().equals("photo")) 
        continue;

      String filename = UUID.randomUUID().toString();
      photo.write(uploadDir + "/" + filename);

      PhotoFile file = new PhotoFile();
      file.setFilePath(filename);
      files.add(file);
    }
    board.setFiles(files);

    if (files.size() > 0) {
      photoBoardService.add(board);
      response.sendRedirect("list");
      return;
    } 

    response.setContentType("text/html;charset=UTF-8");
    request.setAttribute("error.title", "사진 등록 오류");
    request.setAttribute("error.content", "최소 한 개의 사진 파일을 등록해야 합니다");
    request.getRequestDispatcher("../error.jsp").include(request, response);
  } // doPost
  
  

}