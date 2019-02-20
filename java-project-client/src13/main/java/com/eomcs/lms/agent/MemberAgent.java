package com.eomcs.lms.agent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberAgent {
  
  String serverAddr;
  int port;
  String rootPath;
  
  public MemberAgent(String serverAddr, int port, String rootPath) {
    this.serverAddr = serverAddr;
    this.port = port;
    this.rootPath = rootPath;
  }

  @SuppressWarnings("unchecked")
  public List<Member> list() throws Exception {
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

      return (List<Member>) in.readObject();
    }
  } // list()


  public void add(Member member) throws Exception {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){

      out.writeUTF(rootPath + "/add"); 
      out.flush();
      
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(member); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 가져오기 실패!");
    }
  } // add()


  public Member get(int no) throws Exception {
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

      return (Member) in.readObject();
    }
  } // get()

  
  public void update(Member member) throws Exception {
    try (Socket socket = new Socket(this.serverAddr, this.port); 
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream()) ){
      
      out.writeUTF(rootPath + "/update");
      out.flush();
      
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(member); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
    }
  } // update()

  
  public void delete(int no) throws Exception {
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
    }
  } // delete()
  
}