package com.eomcs.lms.proxy;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoProxy implements LessonDao {
  
  String serverAddr;
  int port;
  String rootPath;
  
  public LessonDaoProxy(String serverAddr, int port, String rootPath) {
    this.serverAddr = serverAddr;
    this.port = port;
    this.rootPath = rootPath;
  }

  @SuppressWarnings("unchecked")
  public List<Lesson> findAll() {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){

      System.out.println("서버와 연결됨");

      out.writeUTF(rootPath + "/list"); 
      
      out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 목록 가져오기 실패!");

      return (List<Lesson>) in.readObject();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()


  public void insert(Lesson lesson) {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){

      out.writeUTF(rootPath + "/add"); 
      out.flush();
      
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(lesson); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 가져오기 실패!");
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // add()


  public Lesson findByNo(int no) {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){

      out.writeUTF(rootPath + "/detail"); 
      out.flush();
      
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeInt(no); out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 가져오기 실패!");

      return (Lesson) in.readObject();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()

  
  public int update(Lesson lesson) {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){
      
      out.writeUTF(rootPath + "/update");
      out.flush();
      
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(lesson); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
      
      return 0;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()

  
  public int delete(int no) {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){
      
      out.writeUTF(rootPath + "/delete");
      out.flush();
      
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeInt(no); out.flush();

      String status = in.readUTF();

      if (!status.equals("OK"))
        throw new Exception("서버에서 삭제 실패!");
      return 0;
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()
  
}
