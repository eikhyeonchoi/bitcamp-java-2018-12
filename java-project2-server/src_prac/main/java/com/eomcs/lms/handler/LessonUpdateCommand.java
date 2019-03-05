package com.eomcs.lms.handler;
import java.sql.Date;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {
  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(Response response) throws Exception  {

    int no = response.requestInt("번호 ? : ");
    Lesson lesson = lessonDao.findByNo(no);
    if(lesson == null) {
      response.println("해당 수업은 존재하지 않습니다");
      return;

    }

    Lesson temp = lesson.clone();

    String input = response.requestString(
        String.format("제목(%s) : ", temp.getTitle()));
    if(input.length() > 0)
      temp.setTitle(input);

    input = response.requestString(
        String.format("내용(%s) : ", temp.getContents()));
    if(input.length() > 0)
      temp.setContents(input);

    input = response.requestString(
        String.format("시작일(%s) : ", temp.getStartDate()));
    if(input.length() > 0)
      temp.setStartDate(Date.valueOf(input));

    input = response.requestString(
        String.format("종료일(%s) : ", temp.getEndDate()));
    if(input.length() > 0)
      temp.setEndDate(Date.valueOf(input));

    input = response.requestString(
        String.format("총 수업 시간(%d) : ", temp.getTotalHours()));
    if(input.length() > 0)
      temp.setTotalHours(Integer.parseInt(input));

    input = response.requestString(
        String.format("일 수업 시간(%d) : ", temp.getDayHours()));
    if(input.length() > 0)
      temp.setDayHours(Integer.parseInt(input));


    lessonDao.update(temp);

    response.println("갱신 완료");
  } // execute()

}
