// 썸네일 이미지 만들기
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024*1024*10)
@WebServlet("/ex04/s8")
public class Servlet08 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;
  private String uploadDir;
  
  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;
    
    httpReq.setCharacterEncoding("UTF-8");
    httpRes.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = httpRes.getWriter();
    
    out.println("<html>");
    out.println("<head><title>servlet0</title></head>");
    out.println("<body><h1>파일 업로드 결과</h1>");
    
    // 일반 폼 데이터를 원래 하던 방식대로 값을 꺼낸다.
    out.printf("이름=%s<br>\n", httpReq.getParameter("name"));
    out.printf("나이=%s<br>\n", httpReq.getParameter("age"));
    
    // 파일 데이터는 getPart()를 이용한다.
    Part photoPart = httpReq.getPart("photo");
    
    String filename = "";
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
    }
    Thumbnails
      .of(this.uploadDir + "/" + filename)
      .size(20, 20)
      .outputFormat("jpg")
      .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
    
    out.printf("사진=%s<br>\n", filename);
    out.printf("<img src='../upload/%s'><br>\n", filename);
    out.println("</body></html>");
  }
}

