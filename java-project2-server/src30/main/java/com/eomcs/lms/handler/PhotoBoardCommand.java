package com.eomcs.lms.handler;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Component
public class PhotoBoardCommand {
  PhotoBoardService photoBoardService;

  public PhotoBoardCommand(PhotoBoardService photoBoardService) {
    this.photoBoardService = photoBoardService;
  }


  @RequestMapping("/photoboard/list")
  public void list(ServletRequest request, ServletResponse response) {
    List<PhotoBoard> boards = photoBoardService.list(0, null);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 목록</title></head>");
    out.println("<body><h1>사진 목록</h1>");
    out.println("<p><a href='/photoboard/form'>새 사진</a></p>");
    out.println("<table border='1'>");
    out.println("<tr><th>번호</th><th>제목</th><th>등록일</th><th>조회수</th><th>수업</th></tr>");

    for (PhotoBoard board : boards) {
      out.println(String.format(
          "<tr><td>%d</td><td><a href='/photoboard/detail?no=%1$d'>%s</a>"
              + "</td><td>%s</td><td>%d</td><td>%d</td></tr>",
              board.getNo(), 
              board.getTitle(), 
              board.getCreatedDate(), 
              board.getViewCount(),
              board.getLessonNo()));
    }
    out.println("</table>");
    out.println("<form action='/photoboard/search'>");
    out.println("수업번호: <input type='number' name='lessonNo'> ");
    out.println("검색어: <input type='text' name='keyword'> ");
    out.println("<button type='submit'>검색</button>");
    out.println("</form>");
    out.println("</body></html>");
  }


  @RequestMapping("/photoboard/add")
  public void add(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    try {

      PhotoBoard board = new PhotoBoard();
      board.setTitle(request.getParameter("title"));
      board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));

      ArrayList<PhotoFile> files = new ArrayList<>();
      for(int i = 1; i <= 5; i++) {
        String filePath = request.getParameter("photoFile"+i);
        int lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
        if(filePath == null) 
          continue;
        PhotoFile file = new PhotoFile();
        file.setPhotoBoardNo(lessonNo);
        file.setFilePath(filePath);
        files.add(file);
      }
      board.setFiles(files);

      out.println("<html><head>"
          + "<title>사진 등록</title>"
          + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
          + "</head>");
      out.println("<body><h1>사진 등록</h1>");
      if(files.size() == 0) {
        out.println("<p>최소 한개 사진파일을 입력해야 합니다</p>");
      } else {
        photoBoardService.add(board);
        out.println("<p>저장했습니다</p>");
      }

      out.println("</body></html>");

    } catch(Exception e) {
      e.printStackTrace();
      out.println("<html><head>"
          + "<title>사진 등록 오류</title>"
          + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
          + "<head>");
      out.println("<body><h1>사진 등록 오류</h1>");
      out.println("<p>최소 한개 사진파일을 입력해야 합니다</p>");
      out.println("</body></html>");
    }
  }


  @RequestMapping("/photoboard/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PhotoBoard board = photoBoardService.get(no);

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>사진 조회</title><head>");
    out.println("<body><h1>사진 조회</h1>");

    if (board == null) {
      response.println("해당 사진을 찾을 수 없습니다.");
      return;
    }
    out.println("<form action='/photoboard/update'>");
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
    
    out.println("<p><a href='/photoboard/list'> 목록 </a>"
        + "<a href='/photoboard/delete?no=" + board.getNo() + "'> 삭제 </a>"
        + "<button type='submit'> 변경 </button>"
        + "</p>");
    out.println("</form>");
    out.println("</body></html>");
  }


  @RequestMapping("/photoboard/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));


    ArrayList<PhotoFile> list = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      String filePath = request.getParameter("filePath"+i);
      
      if(filePath == null)
        continue;
      
      PhotoFile file = new PhotoFile();
      file.setPhotoBoardNo(board.getNo());
      file.setFilePath(filePath);
      list.add(file);
    } // for
    
    board.setFiles(list);

    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>사진 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
        + "</head>");
    out.println("<body><h1>사진 변경</h1>");

    if (list.size() == 0) {
      out.println("<p>최소 한 개의 사진 파일을 등록해야 합니다.</p>");

    } else {
      photoBoardService.update(board);
      out.println("<p>변경하였습니다.</p>");
    }
    out.println("</body></html>");

  }

  @RequestMapping("/photoboard/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>사진정보 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=/photoboard/list'>"
        + "<head>");
    out.println("<body><h1>수업정보 삭제</h1>");

    if (photoBoardService.delete(no) == 0) {
      out.println("<p>해당 번호의 수업이 없습니다</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }

    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/search")
  public void search(ServletRequest request, ServletResponse response) {
    PrintWriter out = response.getWriter();
    int lessonNo = Integer.parseInt(request.getParameter("lessonNo"));
    String isExistWord = null;
    String keyword = request.getParameter("keyword");
    if(keyword != null) {
      isExistWord = keyword;
    }

    List<PhotoBoard> photoBoards = photoBoardService.list(lessonNo, isExistWord);

    out.println("<html><head><title>사진 목록</title><head>");
    out.println("<body><h1>사진 목록</h1>");
    out.println("<p><a href='/photoboard/list'>목록으로 돌아가기</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>제목</th> <th>등록일</th> <th>조회수</th> <th>수업번호</th> </tr>");
    for (PhotoBoard photoBoard : photoBoards) {
      out.println(
          String.format("<tr> "
              + "<td>%d</td> "
              + "<td><a href='/photoboard/detail?no=%1$d'>%s</a></td> "
              + "<td>%s</td> "
              + "<td>%d</td> "
              + "<td>%d</td> "
              + "</tr>",
              photoBoard.getNo(),
              photoBoard.getTitle(),
              photoBoard.getCreatedDate(),
              photoBoard.getViewCount(),
              photoBoard.getLessonNo()));
    }
    out.println("</table>");
    out.println("</body></html>");
  }

  @RequestMapping("/photoboard/form")
  public void form(ServletRequest request,ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>새 사진</title></head>");
    out.println("<body>");
    out.println("<h1>새 사진</h1>");
    out.println("<form action='/photoboard/add'>");
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
    out.println("<a href='/photoboard/list'>목록</a>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }


} // end of class
