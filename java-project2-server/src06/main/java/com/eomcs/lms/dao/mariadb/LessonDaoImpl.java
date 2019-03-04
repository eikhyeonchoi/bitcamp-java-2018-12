package com.eomcs.lms.dao.mariadb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {

  Connection con;
  
  public LessonDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Lesson> findAll() {
    ArrayList<Lesson> list = new ArrayList<Lesson>();
    try(PreparedStatement stmt = con.prepareStatement(
        "select * from lms_lesson " 
            + "order by lesson_id desc")){

      try( ResultSet rs = stmt.executeQuery(); ) {

        while(rs.next()) {
          Lesson lesson = new Lesson();
          lesson.setNo(rs.getInt("lesson_id"));
          lesson.setContents(rs.getString("conts"));
          lesson.setTitle(rs.getString("titl"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalHours(rs.getInt("tot_hr"));
          lesson.setDayHours(rs.getInt("day_hr"));
          list.add(lesson);

        } // while
        return (ArrayList<Lesson>)list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Lesson lesson) {
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_lesson(conts, titl, sdt, edt, tot_hr, day_hr)"
            + " values(?, ?, ?, ?, ?, ?)"); ){

      stmt.setString(1, lesson.getContents());
      stmt.setString(2, lesson.getTitle());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalHours());
      stmt.setInt(6, lesson.getDayHours());

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // add()


  public Lesson findByNo(int no) {
    try(PreparedStatement stmt = con.prepareStatement(
        "select * from lms_lesson where lesson_id = ?"); ){

      stmt.setInt(1, no);

      try( ResultSet rs = stmt.executeQuery(); ) {

        if(rs.next()) { // next()를 호출해야지만 서버에 요청하는 것
          Lesson lesson = new Lesson();
          lesson.setNo(rs.getInt("lesson_id"));
          lesson.setTitle(rs.getString("titl"));
          lesson.setContents(rs.getString("conts"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalHours(rs.getInt("tot_hr"));
          lesson.setDayHours(rs.getInt("day_hr"));
          return lesson;
        } else return null;
      }
    }catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Lesson lesson) {
    try(PreparedStatement stmt = con.prepareStatement(
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
    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_lesson where lesson_id = ?"); ){

      stmt.setInt(1, no);

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
