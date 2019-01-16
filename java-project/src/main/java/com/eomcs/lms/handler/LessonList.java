package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  int LENGTH;
  public Scanner keyboard;
  Lesson[] lessons;
  int lessonIdx = 0;
  
  public LessonList() {
    lessons = new Lesson[10];
  }
  public LessonList(int length) {
    this.LENGTH = length;
    lessons = new Lesson[LENGTH];
  }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(lessons, lessonIdx);
  }
  
  public void add(Lesson l) {
     l = new Lesson();
    System.out.print("번호? ");
    l.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("수업명? ");
    l.setTitle(this.keyboard.nextLine()); 

    System.out.print("설명? ");
    l.setContents(this.keyboard.nextLine()); 

    System.out.print("시작일? ");
    l.setStartDate(Date.valueOf(this.keyboard.nextLine())); 
    
    System.out.print("종료일? ");
    l.setEndDate(Date.valueOf(this.keyboard.nextLine()));

    System.out.print("총수업시간? ");
    l.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("일수업시간? ");
    l.setDayHours(Integer.parseInt(this.keyboard.nextLine()));

    // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
    this.lessons[this.lessonIdx] = l;
    this.lessonIdx++;

    System.out.println("저장하였습니다.");
  }
  
  
}
