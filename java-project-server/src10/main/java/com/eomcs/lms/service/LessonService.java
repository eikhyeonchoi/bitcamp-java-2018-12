package com.eomcs.lms.service;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

//클라이언트의 요청을 처리하는 클래스라는 의미
//~~~Service
public class LessonService {

  List<Lesson> lessons;
  ObjectInputStream in;
  ObjectOutputStream out;
  String filepath;
  
  public void init(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }
  
  @SuppressWarnings("unchecked")
  public void loadData(String filepath) {
    this.filepath = filepath;
    try (ObjectInputStream in =
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream(this.filepath)))){

      lessons = (List<Lesson>) in.readObject();

    } catch (Exception e) {
      lessons = new ArrayList<Lesson>();
      throw new RuntimeException("수업 파일 로딩 오류!", e);
    }
  } // loadData()

  public void saveData() throws Exception{
    try (ObjectOutputStream out =
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream(this.filepath)))) {

      out.writeObject(lessons);

    } catch (Exception e) {
      throw new Exception("수업 파일 저장 오류!", e);
    }
  } // saveData()

  public void execute(String request) throws Exception {
    switch(request) {
      case "/lesson/add" : add(); break;
      case "/lesson/list" : list(); break;
      case "/lesson/detail" : detail(); break;
      case "/lesson/update" : update(); break;
      case "/lesson/delete" : delete(); break;
      default :
        out.writeUTF("FAIL"); 
    }
    out.flush();
  } // service()

  private void add() throws Exception {
    out.writeUTF("OK"); out.flush();
    lessons.add((Lesson)in.readObject());
    out.writeUTF("OK"); 
  } // add()

  private void list() throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");
    out.writeObject(lessons);
    // Collection 객체도 보낼 수 있음 
  } // list()

  private void detail() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    for(Lesson m : lessons) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    } // for

    out.writeUTF("FAIL");
  } // detail()

  private void update() throws Exception {
    out.writeUTF("OK"); out.flush();
    Lesson lesson = (Lesson)in.readObject();

    int index = 0;
    for(Lesson m : lessons) {
      if(m.getNo() == lesson.getNo()) {
        lessons.set(index, lesson);
        out.writeUTF("OK");
        return;
      }
      index ++;
    } // for

    out.writeUTF("FAIL");
  } // update()


  private void delete() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    int index = 0;
    for(Lesson m : lessons) {
      if(m.getNo() == no) {
        lessons.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    } // for

    out.writeUTF("FAIL");
  } // delete()


}
