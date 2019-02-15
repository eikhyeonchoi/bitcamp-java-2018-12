package com.eomcs.lms.service;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonService implements Service{

  // LessonService가 작업을 수행할 때 사용할 객체 (의존 객체; dependancy)
  LessonDao lessonDao;

  public LessonService(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(String request
      ,ObjectInputStream in, ObjectOutputStream out) throws Exception {
    switch(request) {
      case "/lesson/add" : add(in, out); break;
      case "/lesson/list" : list(in, out); break;
      case "/lesson/detail" : detail(in, out); break;
      case "/lesson/update" : update(in, out); break;
      case "/lesson/delete" : delete(in, out); break;
      default :
        out.writeUTF("FAIL"); 
    }
    out.flush();
  } // service()

  private void add(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    lessonDao.insert((Lesson)in.readObject());
    out.writeUTF("OK");

  } // add()

  private void list(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");

    out.writeUnshared(lessonDao.findAll());
  } // list()

  private void detail(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    Lesson b = lessonDao.findByNo(no);
    if (b == null) {
      out.writeUTF("FAIL");
      return;
    }

    out.writeUTF("OK");
    out.writeObject(b);

  } // detail()

  private void update(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    Lesson lesson = (Lesson)in.readObject();

    if (lessonDao.update(lesson) == 0) {
      out.writeUTF("FAIL");
      return;
    }

    out.writeUTF("OK");
  } // update()


  private void delete(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    if (lessonDao.delete(no) == 0) {
      out.writeUTF("FAIL");
      return;
    }
    
    out.writeUTF("OK");
  } // delete()


}
