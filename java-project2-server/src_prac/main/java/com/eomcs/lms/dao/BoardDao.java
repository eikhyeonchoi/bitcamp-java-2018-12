// 프록시 패턴적용
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao{
  void insert(Board board);
  
  List<Board> findAll();
  
  Board findByNo(int no);
  
  int update(Board board);
  
  int delete(int no);
  
} // end of class
