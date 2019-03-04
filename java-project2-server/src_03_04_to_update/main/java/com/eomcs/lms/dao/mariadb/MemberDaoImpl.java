package com.eomcs.lms.dao.mariadb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl implements MemberDao {
  
  Connection con;
  
  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Member> findAll()  {
    ArrayList<Member> list = new ArrayList<Member>();

    try(PreparedStatement stmt = con.prepareStatement(
        "select * from lms_member " 
            + "order by member_id desc")){

      try( ResultSet rs = stmt.executeQuery(); ) {

        while(rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_id"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPassword(rs.getString("pwd"));
          member.setPhoto(rs.getString("photo"));
          member.setTel(rs.getString("tel"));
          member.setRegisteredDate(rs.getDate("cdt"));
          list.add(member);

        } // while
        return (ArrayList<Member>)list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()
  
  @Override
  public List<Member> findByKeyword(String keyword)  {
    ArrayList<Member> list = new ArrayList<Member>();

    try(PreparedStatement stmt = con.prepareStatement(
        "select * from lms_member"
        + " where name like concat('%', ?, '%')"
        + " or email like concat('%', ?, '%')"
        + " or tel like concat('%', ?, '%')"
        + " order by name asc")){
      stmt.setString(1, keyword);
      stmt.setString(2, keyword);
      stmt.setString(3, keyword);

      try( ResultSet rs = stmt.executeQuery(); ) {

        while(rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_id"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPassword(rs.getString("pwd"));
          member.setPhoto(rs.getString("photo"));
          member.setTel(rs.getString("tel"));
          member.setRegisteredDate(rs.getDate("cdt"));
          list.add(member);

        } // while
        return (ArrayList<Member>)list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Member member) {
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_member(name, email, pwd, photo, tel)"
            + " values(?, ?, password(?), ?, ?)"); ){

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // add()


  public Member findByNo(int no) {
    try{

      try(PreparedStatement stmt = con.prepareStatement(
          "select * from lms_member where member_id = ?"); ){

        stmt.setInt(1, no);

        try( ResultSet rs = stmt.executeQuery(); ) {

          if(rs.next()) { // next()를 호출해야지만 서버에 요청하는 것
            Member member = new Member();
            member.setNo(rs.getInt("member_id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setPassword(rs.getString("pwd"));
            member.setPhoto(rs.getString("photo"));
            member.setTel(rs.getString("tel"));
            member.setRegisteredDate(rs.getDate("cdt"));
            return member;
          } else return null;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Member member) {
    try(PreparedStatement stmt = con.prepareStatement(
        "update lms_member set name = ?, email = ?, pwd = password(?), photo = ?,"
            + " tel = ?, cdt = ? where member_id = ?"); ){

      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());
      stmt.setDate(6, member.getRegisteredDate());
      stmt.setInt(7, member.getNo());

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()


  public int delete(int no) {
    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_member where member_id = ?"); ){

      stmt.setInt(1, no);

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
