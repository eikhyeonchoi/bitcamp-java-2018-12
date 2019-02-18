// Data Access Object = DAO = 데이터처리 클래스
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl extends AbstractDao<Lesson> implements LessonDao{

  public LessonDaoImpl(String filepath) {
    this.filepath = filepath;
  }

  public void insert(Lesson lesson) {
    try {
      list.add(lesson);
      this.saveData(); 
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
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
    try {
      int index = 0;
      for(Lesson b : this.list) {
        if(b.getNo() == lesson.getNo()) {
          this.list.set(index, lesson);
          this.saveData();
          return 1;
        }
        index ++;
      } // for
      return 0;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()

  public int delete(int no) {
    try {
      int index = 0;
      for(Lesson b : this.list) {
        if(b.getNo() == no) {
          this.list.remove(index);
          this.saveData();
          return 1;
        }
        index++;
      } // for
      return 0; 
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()


}
