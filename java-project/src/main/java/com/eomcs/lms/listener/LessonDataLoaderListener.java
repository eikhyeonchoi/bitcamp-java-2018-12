package com.eomcs.lms.listener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.domain.Lesson;

public class LessonDataLoaderListener implements ApplicationContextListener {
  @Override
  public void init(HashMap<String, Object> context) {
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

  
  
  
  @Override
  public void destroy(HashMap<String, Object> context) {
    try (ObjectOutputStream out =
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("lesson3.data")))) {

      out.writeObject(context.get("lessonList"));

    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }


}