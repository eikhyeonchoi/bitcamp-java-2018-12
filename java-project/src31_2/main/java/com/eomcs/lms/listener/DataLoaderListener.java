package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class DataLoaderListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void startApp(Map<String, Object> context) {
    loadLessonData(context);
    loadMemberData(context);
    loadBoardData(context);
    System.out.println("startApp()...");
    
  }

  @Override
  public void endApp(Map<String, Object> context) {
    saveLessonData(context);
    saveMemberData(context);
    saveBoardData(context);
    System.out.println("endApp()...");
    
  }
  
  @SuppressWarnings("unchecked")
  private static void loadLessonData(Map<String, Object> context) {
    try(ObjectInputStream in = 
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("lesson3.data")));) {
      
      context.put("lessonList", in.readObject());
      
    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("lessonList", new ArrayList<Lesson>());
    }
  }

  private static void saveLessonData(Map<String, Object> context) {
    try (ObjectOutputStream out =
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("lesson3.data")))) {
      
      out.writeObject(context.get("lessonList"));

    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
  

  @SuppressWarnings("unchecked")
  private static void loadMemberData(Map<String, Object> context) {
    try (ObjectInputStream in =
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("member3.data")))){
      
      context.put("memberList", in.readObject());

    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("memberList", new LinkedList<Member>());
    }
  }
  

  private static void saveMemberData(Map<String, Object> context) {
    try (ObjectOutputStream out  = 
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("member3.data")))) {
      
      out.writeObject(context.get("memberList"));

    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }

  
  @SuppressWarnings("unchecked")
  private static void loadBoardData(Map<String, Object> context) {
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

  
  private static void saveBoardData(Map<String, Object> context) {
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
