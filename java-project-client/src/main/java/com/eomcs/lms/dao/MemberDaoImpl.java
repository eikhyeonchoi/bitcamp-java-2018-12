package com.eomcs.lms.dao;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDaoImpl implements MemberDao {


  @SuppressWarnings("unchecked")
  public List<Member> findAll()  {
    ArrayList<Member> list = new ArrayList<Member>();
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_member")) {

        try (ResultSet rs = stmt.executeQuery();) {

          while(rs.next()) {
            Member tempMember = new Member();
            tempMember.setNo(rs.getInt("member_id"));
            tempMember.setName(rs.getString("name"));
            tempMember.setEmail(rs.getString("mail"));
            tempMember.setPassword(rs.getString("password"));
            tempMember.setPhoto(rs.getString("photo"));
            tempMember.setTel(rs.getString("tel"));
            tempMember.setRegisteredDate(rs.getDate("registered_date"));
            list.add(tempMember);
          }
          return list;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Member member) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into temp_member(member_id, name, mail, password, photo, tel, registered_date) "
              + "values(?, ?, ?, ?, ?, ?, ?)")) {

        stmt.setInt(1, member.getNo());
        stmt.setString(2, member.getName());
        stmt.setString(3, member.getEmail());
        stmt.setString(4, member.getPassword());
        stmt.setString(5, member.getPhoto());
        stmt.setString(6, member.getTel());
        stmt.setDate(7, member.getRegisteredDate());

        int isInsert = stmt.executeUpdate();
        if(isInsert == 0) {
          System.out.println("insert 실패");
        } else {
          System.out.println("insert 성공");
        }

      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // add()

  public Member findByNo(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_member where member_id = ?")) {
        
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery()) {
          Member member = new Member();
          if(rs.next()) {
            member.setNo(rs.getInt("member_id"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("mail"));
            member.setPassword(rs.getString("password"));
            member.setPhoto(rs.getString("photo"));
            member.setTel(rs.getString("tel"));
            member.setRegisteredDate(rs.getDate("registered_date"));
          } else {
            System.out.println("해당 회원을 찾을 수 없습니다");
          }
          return member;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Member member) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "update temp_member set name = ?, mail = ?, password = ?, photo = ?, tel = ?,"
          + " registered_date = ? where member_id = ?")) {

        stmt.setString(1, member.getName());
        stmt.setString(2, member.getEmail());
        stmt.setString(3, member.getPassword());
        stmt.setString(4, member.getPhoto());
        stmt.setString(5, member.getTel());
        stmt.setDate(6, member.getRegisteredDate());
        stmt.setInt(7, member.getNo());

        int isUpdate = stmt.executeUpdate();
        if(isUpdate == 0) {
          System.out.println("update 실패");
        } else {
          System.out.println("update 성공");
        }
        return 1;

      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()


  public int delete(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "delete from temp_member where member_id = ?")) {
        
        stmt.setInt(1, no);


        int isDelete = stmt.executeUpdate();
        if(isDelete == 0) {
          System.out.println("delete 실패");
        } else {
          System.out.println("delete 성공");
        }
        return 1;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
