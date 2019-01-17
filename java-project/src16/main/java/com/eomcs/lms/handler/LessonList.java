package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  Lesson[] lessons;
  int lessonIdx = 0;

  public LessonList() {
    lessons = new Lesson[10];
  }
  
  public LessonList(int length) {
    if (length < 10) {
      lessons = new Lesson[10];
    } else {
      lessons = new Lesson[length];
    }
  }

  public Lesson[] toArray() {
    return Arrays.copyOf(lessons, lessonIdx);
  }

  public void add(Lesson l) {
    if (lessonIdx >= lessons.length) {
      lessons = Arrays.copyOf(lessons, lessons.length + (lessons.length >>1));
      System.out.println("배열을 증가했습니다 배열 length : " + lessons.length);
    }
    lessons[lessonIdx] = l;
    lessonIdx++;
  } 


}
