package com.eomcs.lms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl implements MemberDao {

  Connection con ;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Member> findAll()  {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from lms_member"); ){

      try (ResultSet rs = stmt.executeQuery(); ){

        ArrayList<Member> list = new ArrayList<Member>();
        while(rs.next()) {
          Member temp = new Member();
          temp.setNo(rs.getInt("member_id"));
          temp.setName(rs.getString("name"));
          temp.setEmail(rs.getString("email"));
          temp.setPassword(rs.getString("pwd"));
          temp.setPhoto(rs.getString("photo"));
          temp.setTel(rs.getString("tel"));
          temp.setRegisteredDate(rs.getDate("cdt"));
          list.add(temp);
        }
        return list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // findAll()


  public void insert(Member member) {
    try (PreparedStatement stmt = con.prepareStatement(
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
  } // insert()


  public Member findByNo(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from lms_member where member_id = ?"); ){

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery(); ){
        if(rs.next()) {
          Member temp = new Member();
          temp.setNo(rs.getInt("member_id"));
          temp.setName(rs.getString("name"));
          temp.setEmail(rs.getString("email"));
          temp.setPassword(rs.getString("pwd"));
          temp.setPhoto(rs.getString("photo"));
          temp.setTel(rs.getString("tel"));
          temp.setRegisteredDate(rs.getDate("cdt"));
          return temp;
        } else {
          return null;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }

  } // get()


  public int update(Member member) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_member set name = ?, email = ?, pwd = ?, photo = ?"
        + ", tel = ?, cdt = ? where member_id = ?"); ){
      
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
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_member where member_id = ?"); ){
      stmt.setInt(1, no);
      
      
      return stmt.executeUpdate();
      
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
