package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao{

  Connection con;
  
  public PhotoFileDaoImpl(Connection con) {
    this.con = con;
  } // con
  
  @Override
  public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo) {
    ArrayList<PhotoFile> list = new ArrayList<PhotoFile>();
    try(PreparedStatement stmt = con.prepareStatement(
        "select * from lms_photo_file where photo_id = ?") ){
      stmt.setInt(1, photoBoardNo);
      
      try(ResultSet rs = stmt.executeQuery()) {
        while(rs.next()) {
          PhotoFile file = new PhotoFile();
          file.setNo(rs.getInt("photo_file_id"));
          file.setFilePath(rs.getString("file_path"));
          file.setPhotoBoardNo(rs.getInt("photo_id"));
          list.add(file);
        }
        return list;
      }
      
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
    
  } // findByPhotoBoardNo(int)

  @Override
  public void insert(PhotoFile photoFile) {
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo_file(photo_id, file_path) values(?, ?)"); ){
      
      stmt.setInt(1, photoFile.getPhotoBoardNo());
      stmt.setString(2, photoFile.getFilePath());
      
      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // insert(PhotoFile)

  @Override
  public void deleteByPhotoBoardNo(int photoBoardNo) {
    try(PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo_file where photo_id = ?"); ){

      stmt.setInt(1, photoBoardNo);

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

}
