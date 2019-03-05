package com.eomcs.lms.dao.mariadb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.ConnectionFactory;

public class PhotoFileDaoImpl implements PhotoFileDao{

  @Override
  public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo) {
    ArrayList<PhotoFile> list = new ArrayList<PhotoFile>();
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "select photo_file_id, photo_id, file_path from lms_photo_file" 
            + " where photo_id = ?"
            + " order by photo_file_id asc")){

      stmt.setInt(1, photoBoardNo);

      try( ResultSet rs = stmt.executeQuery(); ) {

        while(rs.next()) {
          PhotoFile photoFile = new PhotoFile();
          photoFile.setNo(rs.getInt("photo_file_id"));
          photoFile.setPhotoBoardNo(rs.getInt("photo_id"));
          photoFile.setFilePath(rs.getString("file_path"));

          list.add(photoFile);
        } // while
        return (ArrayList<PhotoFile>)list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }

  } // findByPhotoBoardNo()


  @Override
  public void insert(PhotoFile photoFile) {
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo_file(file_path, photo_id) values(?, ?)"); ){

      stmt.setString(1, photoFile.getFilePath());
      stmt.setInt(2, photoFile.getPhotoBoardNo());

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // insert()


  public int deleteByPhotoBoardNo(int no) {
    Connection con = ConnectionFactory.create();
    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo_file where photo_id = ?"); ){

      stmt.setInt(1, no);

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // deleteByPhotoBoardNo()

}
