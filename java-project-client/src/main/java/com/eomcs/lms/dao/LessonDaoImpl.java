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
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {

  @SuppressWarnings("unchecked")
  public List<Lesson> findAll() {
    ArrayList<Lesson> list = new ArrayList<Lesson>();
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_lesson")) {

        try (ResultSet rs = stmt.executeQuery()) {
          while(rs.next()) {
            Lesson temp = new Lesson();
            temp.setNo(rs.getInt("lesson_id"));
            temp.setTitle(rs.getString("title"));
            temp.setContents(rs.getString("contents"));
            temp.setStartDate(rs.getDate("started_date"));
            temp.setEndDate(rs.getDate("ended_date"));
            temp.setTotalHours(rs.getInt("total"));
            temp.setDayHours(rs.getInt("day"));
            list.add(temp);
          }
          return list;
          
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Lesson lesson) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into temp_lesson(lesson_id, title, contents, started_date, ended_date, total, day) "
              + "values(?, ?, ?, ?, ?, ?, ?)")) {

        stmt.setInt(1, lesson.getNo());
        stmt.setString(2, lesson.getTitle());
        stmt.setString(3, lesson.getContents());
        stmt.setDate(4, lesson.getStartDate());
        stmt.setDate(5, lesson.getEndDate());
        stmt.setInt(6, lesson.getTotalHours());
        stmt.setInt(7, lesson.getDayHours());

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


  public Lesson findByNo(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_lesson where lesson_id = ?")) {
        
        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery()) {
          Lesson temp = new Lesson();
          if(rs.next()) {
            temp.setNo(rs.getInt("lesson_id"));
            temp.setTitle(rs.getString("title"));
            temp.setContents(rs.getString("contents"));
            temp.setStartDate(rs.getDate("started_date"));
            temp.setEndDate(rs.getDate("ended_date"));
            temp.setTotalHours(rs.getInt("total"));
            temp.setDayHours(rs.getInt("day"));
          } else {
            System.out.println("해당수업을 찾을 수 없습니다");
          }
          return temp;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Lesson lesson) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "update temp_lesson set title = ?, contents = ?, started_date = ?"
          + ", ended_date = ?, total = ?, day = ? where lesson_id = ?")) {

        stmt.setString(1, lesson.getTitle());
        stmt.setString(2, lesson.getContents());
        stmt.setDate(3, lesson.getStartDate());
        stmt.setDate(4, lesson.getEndDate());
        stmt.setInt(5, lesson.getTotalHours());
        stmt.setInt(6, lesson.getDayHours());
        stmt.setInt(7, lesson.getNo());
        
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
          "delete from temp_lesson where lesson_id = ?")) {
        
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
