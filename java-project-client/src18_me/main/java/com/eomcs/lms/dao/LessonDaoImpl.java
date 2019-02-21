package com.eomcs.lms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {

  Connection con ;
  public LessonDaoImpl(Connection con) {
    this.con = con;
  }

  @SuppressWarnings("unchecked")
  public List<Lesson> findAll() {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from lms_lesson"); ){

      try (ResultSet rs = stmt.executeQuery(); ){

        ArrayList<Lesson> list = new ArrayList<Lesson>();
        while(rs.next()) {
          Lesson temp = new Lesson();
          temp.setNo(rs.getInt("lesson_id"));
          temp.setTitle(rs.getString("titl"));
          temp.setContents(rs.getString("conts"));
          temp.setStartDate(rs.getDate("sdt"));
          temp.setEndDate(rs.getDate("edt"));
          temp.setTotalHours(rs.getInt("tot_hr"));
          temp.setDayHours(rs.getInt("day_hr"));
          list.add(temp);
        }
        return list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Lesson lesson) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_lesson(titl, conts, sdt, edt, tot_hr, day_hr)"
            + " values(?, ?, ?, ?, ?, ?)"); ){
      stmt.setString(1, lesson.getTitle());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalHours());
      stmt.setInt(6, lesson.getDayHours());

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // insert()


  public Lesson findByNo(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from lms_lesson where lesson_id = ?"); ){

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery(); ){
        if(rs.next()) {
          Lesson temp = new Lesson();
          temp.setNo(rs.getInt("lesson_id"));
          temp.setTitle(rs.getString("titl"));
          temp.setContents(rs.getString("conts"));
          temp.setStartDate(rs.getDate("sdt"));
          temp.setEndDate(rs.getDate("edt"));
          temp.setTotalHours(rs.getInt("tot_hr"));
          temp.setDayHours(rs.getInt("day_hr"));
          return temp;
        } else {
          return null;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Lesson lesson) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_lesson set titl = ?, conts = ?, sdt = ?, edt = ?,"
        + " tot_hr = ?, day_hr = ? where lesson_id = ?"); ){
      
      stmt.setString(1, lesson.getTitle());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalHours());
      stmt.setInt(6, lesson.getDayHours());
      stmt.setInt(7, lesson.getNo());

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()


  public int delete(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_lesson where lesson_id = ?"); ){
      stmt.setInt(1, no);
      
      
      return stmt.executeUpdate();
      
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()



}
