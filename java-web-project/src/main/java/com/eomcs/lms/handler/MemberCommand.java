package com.eomcs.lms.handler;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Component
public class MemberCommand {

  MemberService memberService;

  public MemberCommand(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/list")
  public void list(ServletRequest request, ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();
    List<Member> members = memberService.list();

    out.println("<html><head><title>회원 목록</title><head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='form'> 새 회원 </a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>전화</th> <th>가입일</th> </tr>");
    for (Member member : members) {
      out.println(
          String.format("<tr> "
              + "<td>%d</td> "
              + "<td><a href='detail?no=%1$d'>%s</a></td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "</tr>",
              member.getNo(),
              member.getName(),
              member.getEmail(),
              member.getTel(),
              member.getRegisteredDate()));
    }
    out.println("</table>");
    out.println("<form action='search'>");
    out.println("<input type='text' name='memberSearch' placeholder='검색어 입력'> ");
    out.println("<button type='submit''> 검색 </button>");
    out.println("</form>");
    out.println("</body></html>");
  }

  @RequestMapping("/member/add")
  public void add(ServletRequest request, ServletResponse response) throws Exception {
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));

    memberService.add(member);
    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>회원 등록</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "<head>");
    out.println("<body><h1>회원 등록</h1>");
    out.println("<p>저장했습니다</p>");
    out.println("</body></html>");
  }

  @RequestMapping("/member/detail")
  public void detail(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(no);
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>회원 조회</title><head>");
    out.println("<body><h1>회원 조회</h1>");
    
    if (member == null) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
      return;
    }
    
    out.println("<form action='update'>");
    out.println("<table border='1'>");
    out.printf("<tr>"
        + "<th>번호</th>"
        + "<td><input type='number' name='no' value='%d' readonly></td>"
        + "</tr>\n",no);
    out.println(String.format(
              "<tr>"
            + "<th>이름</th>"
            + "<td><input type='text' name='name' value='%s'></td>"
            + "</tr>", member.getName()));
    out.println(String.format(
        "<tr>"
            + "<th>이메일</th>"
            + "<td><input type='email' name='email' value='%s'></td>"
            + "</tr>", member.getEmail()));
    out.println(String.format(
        "<tr>"
            + "<th>비밀번호</th>"
            + "<td><input type='password' name='password' value='%s'></td>"
            + "</tr>", member.getPassword()));
    out.println(String.format(
        "<tr>"
            + "<th>전화번호</th>"
            + "<td><input type='number' name='tel' value='%s'></td>"
            + "</tr>", member.getTel()));
    out.println(String.format(
        "<tr>"
            + "<th>사진</th>"
            + "<td><input type='text' name='photo' value='%s'></td>"
            + "</tr>", member.getPhoto()));
    out.println(String.format(
        "<tr>"
            + "<th>가입일</th>"
            + "<td>%s</td>"
            + "</tr>", member.getRegisteredDate()));

    out.println("</table>");
    
    out.println("<p><a href='list'> 목록 </a>"
        + "<a href='delete?no="+member.getNo()+"'> 삭제 </a>"
        + "<button type='submit'> 변경 </button>"
        + "</p>");

    out.println("</form>");
    out.println("</body></html>");
  }

  @RequestMapping("/member/update")
  public void update(ServletRequest request, ServletResponse response) throws Exception {
    
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    member.setPhoto(request.getParameter("photo"));
    
    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>회원정보 변경</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "<head>");
    out.println("<body><h1>회원정보 변경</h1>");

    if (memberService.update(member) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
    } else {
      out.println("<p>변경했습니다.</p>");
    }
    out.println("</body></html>");
  }

  @RequestMapping("/member/delete")
  public void delete(ServletRequest request, ServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    out.println("<html><head>"
        + "<title>회원정보 삭제</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "<head>");
    out.println("<body><h1>회원정보 삭제</h1>");
    
    if (memberService.delete(no) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다</p>");
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
    
    out.println("</body></html>");
  }

  
  @RequestMapping("/member/search")
  public void search(ServletRequest request, ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();
    String keyword = request.getParameter("memberSearch");
    
    List<Member> members = memberService.findByKeyword(keyword);

    out.println("<html><head><title>회원 목록</title><head>");
    out.println("<body><h1>회원 목록</h1>");
    out.println("<p><a href='list'>목록으로 돌아가기</a></p>");
    out.println("<table border='1'>");
    out.println("<tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>전화</th> <th>가입일</th> </tr>");
    for (Member member : members) {
      out.println(
          String.format("<tr> "
              + "<td>%d</td> "
              + "<td><a href='detail?no=%1$d'>%s</a></td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "<td>%s</td> "
              + "</tr>",
              member.getNo(),
              member.getName(),
              member.getEmail(),
              member.getTel(),
              member.getRegisteredDate()));
    }
    out.println("</table>");
    out.println("</body></html>");
  }
  
  @RequestMapping("/member/form")
  public void form(ServletRequest request,ServletResponse response) throws Exception {
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>새 회원</title></head>");
    out.println("<body>");
    out.println("<h1>새 회원</h1>");
    out.println("<form action='add'>");
    out.println("<table border='1'>");
    
    out.println("<tr>");
    
    out.println("<tr>");
    out.println("<th>이름</th>");
    out.println("<td><input type='text' name='name'><</textarea></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>이메일</th>");
    out.println("<td><input type='email' name='email'><</textarea></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>비밀번호</th>");
    out.println("<td><input type='password' name='password'><</textarea></td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>전화번호</th>");
    out.println("<td><input type='number' name='tel'><</td>");
    out.println("</tr>");
    
    out.println("<tr>");
    out.println("<th>사진</th>");
    out.println("<td><input type='text' name='photo'><</td>");
    out.println("</tr>");
    
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
}
