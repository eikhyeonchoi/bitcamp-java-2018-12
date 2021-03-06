package com.eomcs.lms.handler;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonDeleteCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(Response response) throws Exception  {
    int no = response.requestInt("번호 ? : ");

    if(lessonDao.delete(no) == 0) {
      response.println("해당 수업이 존재하지 않습니다");
      return;
    }
    response.println("데이터를 삭제했습니다.");

  } // execute()

}
