package com.eomcs.lms.dao.mariadb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.util.ConnectionFactory;

public class PhotoBoardDaoImpl implements PhotoBoardDao{
  
  @Override
  public List<PhotoBoard> findAll() {
    ArrayList<PhotoBoard> list = new ArrayList<PhotoBoard>();
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo " 
            + "order by photo_id desc")){

      try( ResultSet rs = stmt.executeQuery(); ) {

        while(rs.next()) {
          PhotoBoard photoBoard = new PhotoBoard();
          photoBoard.setNo(rs.getInt("photo_id"));
          photoBoard.setTitle(rs.getString("titl"));
          photoBoard.setCreatedDate(rs.getDate("cdt"));
          photoBoard.setViewCount(rs.getInt("vw_cnt"));
          photoBoard.setLessonNo(rs.getInt("lesson_id"));

          list.add(photoBoard);
        } // while
        return (ArrayList<PhotoBoard>)list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }

  } // findAll()

  public void insert(PhotoBoard photoBoard) {
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo(titl, lesson_id) values(?, ?)", 
        Statement.RETURN_GENERATED_KEYS); ){

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getLessonNo());

      stmt.executeUpdate();

      try(ResultSet rs = stmt.getGeneratedKeys();){
        rs.next();
        photoBoard.setNo(rs.getInt(1)); // 자동 생성된 PK값을 파라미터로 받은 객체에 보관
      }


    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // add()

  
  public PhotoBoard findByNo(int no) {
    Connection con = ConnectionFactory.create();
    try{
      try(PreparedStatement stmt = con.prepareStatement(
          "update lms_photo set vw_cnt = vw_cnt+1 where photo_id = ?"); ){
        stmt.setInt(1, no);
        stmt.executeUpdate(); // 조회수 증가
      }

      try(PreparedStatement stmt = con.prepareStatement(
          "select photo_id, titl, cdt, vw_cnt, lesson_id "
              + "from lms_photo where photo_id = ?"); ){

        stmt.setInt(1, no);

        try( ResultSet rs = stmt.executeQuery(); ) {

          if(rs.next()) { // next()를 호출해야지만 서버에 요청하는 것
            PhotoBoard photoBoard = new PhotoBoard();
            photoBoard.setNo(rs.getInt("photo_id"));
            photoBoard.setTitle(rs.getString("titl"));
            photoBoard.setCreatedDate(rs.getDate("cdt"));
            photoBoard.setViewCount(rs.getInt("vw_cnt"));
            photoBoard.setLessonNo(rs.getInt("lesson_id"));
            return photoBoard;
          } else return null;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  

  public int update(PhotoBoard photoBoard) {
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?"); ){

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getNo());

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()



  public int delete(int no) {
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo where photo_id = ?"); ){

      stmt.setInt(1, no);

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
