package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.PhotoFile;

public interface PhotoFileDao {

  public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo);
  public void insert(PhotoFile photoFile);
  public void deleteByPhotoBoardNo(int photoBoardNo);
  
}
