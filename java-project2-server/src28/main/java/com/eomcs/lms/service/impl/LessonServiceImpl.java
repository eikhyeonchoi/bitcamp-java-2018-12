package com.eomcs.lms.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

//l @Component : 일반 
//l @Service : Business logic
//l @Controller : MVC
//l @Repository : Dao
@Service
public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;

  public LessonServiceImpl(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public List<Lesson> list() {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return lessonDao.findAll();
  }

  @Override
  public int add(Lesson lesson) {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return lessonDao.insert(lesson);
  }

  @Override
  public Lesson get(int no) {
    Lesson lesson = lessonDao.findByNo(no);
    if(lesson !=null)
      return lesson;
    else return null;
  }

  @Override
  public int update(Lesson lesson) {
    if (lesson.getTitle() != null
        || lesson.getContents() != null
        || lesson.getStartDate() != null
        || lesson.getEndDate() != null
        || lesson.getTotalHours() > 0
        || lesson.getDayHours() > 0) {

      return lessonDao.update(lesson);
      
    } else {
      return 0;
    }
  }
  
  @Override
  public int delete(int no) {
    return lessonDao.delete(no);
  }


}
