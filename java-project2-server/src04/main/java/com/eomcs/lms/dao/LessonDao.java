// 프록시 패턴적용
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao{
  void insert(Lesson lesson);
  
  List<Lesson> findAll();
  
  Lesson findByNo(int no);
  
  int update(Lesson lesson);
  
  int delete(int no);
  
} // end of class
