package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.service.PhotoBoardService;

@WebServlet("/photoboard/delete")
@SuppressWarnings("serial")
public class PhotoBoardDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PhotoBoardService photoBoardService =((ApplicationContext) this.getServletContext().getAttribute("iocContainer")).getBean(PhotoBoardService.class);

    response.setContentType("text/html;charset=UTF-8");
    
    int no = Integer.parseInt(request.getParameter("no"));

    if(photoBoardService.delete(no) > 0) {
      response.sendRedirect("list");
      return;
    }
    
    request.setAttribute("error.title", "사진 등록 오류");
    request.setAttribute("error.content", "최소 한 개의 사진 파일을 등록해야 합니다");
    request.getRequestDispatcher("../error.jsp").include(request, response);

  } // doGet

}