// 프록시 패턴 적용 - LessonDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {
  List<Lesson> findAll();
  List<Lesson> findAll(HashMap<String, Object> params);
  int insert(Lesson lesson);
  Lesson findByNo(int no);
  int update(Lesson lesson);
  int delete(int no);
  int countAll();
}







