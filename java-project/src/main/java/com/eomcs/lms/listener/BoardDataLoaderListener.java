package com.eomcs.lms.listener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.domain.Board;

public class BoardDataLoaderListener implements ApplicationContextListener {

  @Override
  public void init(HashMap<String, Object> context) {
    try (ObjectInputStream in =
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("board3.data")))){

      context.put("boardList", in.readObject());
      
    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("boardList", new ArrayList<Board>());
    }
  }


  @Override
  public void destroy(HashMap<String, Object> context) {
    try (ObjectOutputStream out =
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("board3.data")))) {
      out.writeObject(context.get("boardList"));
    } catch (Exception e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }



}
