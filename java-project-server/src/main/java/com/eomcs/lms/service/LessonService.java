package com.eomcs.lms.service;
import com.eomcs.lms.domain.Lesson;

//클라이언트의 요청을 처리하는 클래스라는 의미
//~~~Service
public class LessonService extends AbstractService<Lesson> {
  
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
    this.list.add((Lesson)in.readObject());
    out.writeUTF("OK"); 
  } // add()

  private void list() throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");
    out.writeObject(this.list);
    // Collection 객체도 보낼 수 있음 
  } // list()

  private void detail() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    for(Lesson m : this.list) {
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
    for(Lesson m : this.list) {
      if(m.getNo() == lesson.getNo()) {
        this.list.set(index, lesson);
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
    for(Lesson m : this.list) {
      if(m.getNo() == no) {
        this.list.remove(index);
        out.writeUTF("OK");
        return;
      } else {
        out.writeUTF("FAIL");
        
      }
      index++;
    } // for
    
  } // delete()


}
