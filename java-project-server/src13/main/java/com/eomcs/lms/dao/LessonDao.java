// Data Access Object = DAO = 데이터처리 클래스
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDao extends AbstractDao<Lesson>{

  public LessonDao(String filepath) {
    this.filepath = filepath;
  }
  
  public void insert(Lesson lesson){
    list.add(lesson);
  } // insert()

  public List<Lesson> findAll() {
    return list;
  } // findAll()

  public Lesson findByNo(int no) {
    for(Lesson b : this.list) {
      if(b.getNo() == no) {
        return b;
      }
    } // for
    return null;
  } // findByNo()

  public int update(Lesson lesson) {
    int index = 0;
    for(Lesson b : this.list) {
      if(b.getNo() == lesson.getNo()) {
        this.list.set(index, lesson);
        return 1;
      }
      index ++;
    } // for
    return 0;
  } // update()

  public int delete(int no) {
    int index = 0;
    for(Lesson b : this.list) {
      if(b.getNo() == no) {
        this.list.remove(index);
        return 1;
      }
      index++;
    } // for
    return 0;
  } // delete()


}
