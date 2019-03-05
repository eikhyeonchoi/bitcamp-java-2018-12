// 프록시 패턴적용
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao{
  void insert(PhotoBoard board);
  List<PhotoBoard> findAll();
  PhotoBoard findByNo(int no);
  int update(PhotoBoard board);
  int delete(int no);
} // end of class
