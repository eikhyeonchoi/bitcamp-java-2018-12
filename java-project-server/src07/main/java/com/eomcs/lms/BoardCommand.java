package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Board;

public class BoardCommand {

  static ArrayList<Board> boards;
  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void service(String request) throws Exception {
    switch(request) {
      case "/board/add" : add(); break;
      case "/board/list" : list(); break;
      case "/board/detail" : detail(); break;
      case "/board/update" : update(); break;
      case "/board/delete" : delete(); break;
      default :
        out.writeUTF("FAIL"); 
    }
    out.flush();
  } // service()

  static void add() throws Exception {
    out.writeUTF("OK"); out.flush();
    boards.add((Board)in.readObject());
    out.writeUTF("OK"); 
  } // add()

  static void list() throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");
    out.writeObject(boards);
    // Collection 객체도 보낼 수 있음 
  } // list()

  static void detail() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    for(Board m : boards) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    } // for

    out.writeUTF("FAIL");
  } // detail()

  static void update() throws Exception {
    out.writeUTF("OK"); out.flush();
    Board board = (Board)in.readObject();

    int index = 0;
    for(Board m : boards) {
      if(m.getNo() == board.getNo()) {
        boards.set(index, board);
        out.writeUTF("OK");
        return;
      }
      index ++;
    } // for

    out.writeUTF("FAIL");
  } // update()


  static void delete() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    int index = 0;
    for(Board m : boards) {
      if(m.getNo() == no) {
        boards.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    } // for

    out.writeUTF("FAIL");
  } // delete()


}
