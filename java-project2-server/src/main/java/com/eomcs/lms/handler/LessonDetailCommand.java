package com.eomcs.lms.handler;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand extends AbstractCommand {
  LessonDao lessonDao;

  public LessonDetailCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(Response response) throws Exception  {
    int no = response.requestInt("번호 ? : ");

    Lesson lesson = lessonDao.findByNo(no);
    if (lesson == null) {
      response.println("해당 수업이 존재하지 않습니다");
      return;
    }
    response.println(String.format("제목: %s", lesson.getTitle()));
    response.println(String.format("내용: %s", lesson.getContents()));
    response.println(String.format("시작일: %s", lesson.getStartDate()));
    response.println(String.format("종료일: %s", lesson.getEndDate()));
    response.println(String.format("총 수업 시간: %d", lesson.getTotalHours()));
    response.println(String.format("일 수업 시간: %d", lesson.getDayHours()));

  } // execute()
}
