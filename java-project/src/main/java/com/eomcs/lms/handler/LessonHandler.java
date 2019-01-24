package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {
  public Scanner keyboard;
  ArrayList<Lesson> arrayList;

  public LessonHandler(Scanner key) {
    this.keyboard = key;
    this.arrayList = new ArrayList<>();
  }
  

  public void listLesson() {
    Lesson[] lessons = arrayList.toArray(new Lesson[0]);
    for (Lesson tempLesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          tempLesson.getNo(), tempLesson.getTitle(), tempLesson.getStartDate(), 
          tempLesson.getEndDate(), tempLesson.getTotalHours());
    }
  }

  
  public void addLesson() {
    Lesson lesson = new Lesson();
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("수업명? ");
    lesson.setTitle(this.keyboard.nextLine()); 
    System.out.print("설명? ");
    lesson.setContents(this.keyboard.nextLine()); 
    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(this.keyboard.nextLine())); 
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(this.keyboard.nextLine()));
    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(this.keyboard.nextLine()));
    arrayList.add(lesson);
    System.out.println("add complete ...");
  }

  
  public void detailLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if(!validate(index)) return;
    
    Lesson lesson = arrayList.get(index);
    if (lesson == null) {
      System.out.println("not find number ...");
      return;
    }
    System.out.printf("수업명 : %s\n", lesson.getTitle());
    System.out.printf("설명 : %s\n", lesson.getContents());
    System.out.printf("시작일 : %s\n", lesson.getStartDate());
    System.out.printf("종료일 : %s\n", lesson.getEndDate());
    System.out.printf("총 수업시간 : %s\n", lesson.getTotalHours());
    System.out.printf("일 수업시간 : %s\n", lesson.getDayHours());
  }
  
  
  public void updateLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if(!validate(index)) return;
    
    Lesson les = arrayList.get(index);
    Lesson tmp = new Lesson();
    
    tmp.setNo(les.getNo());
    System.out.printf("수업명(%s) : ", les.getTitle());
    String input = keyboard.nextLine();
    tmp.setTitle(input.length() > 0 ?
        input : les.getTitle());
    
    System.out.printf("설명(%s) : ", les.getContents());
    input = keyboard.nextLine();
    tmp.setContents(input.length() > 0 ?
        input : les.getContents());
    
    System.out.printf("시작일(%s) : ", les.getStartDate());
    input = keyboard.nextLine();
    tmp.setStartDate(input.length() > 0 ?
        Date.valueOf(input) : les.getStartDate());
    
    System.out.printf("종료일(%s) : ", les.getEndDate());
    input = keyboard.nextLine();
    tmp.setEndDate(input.length() > 0 ?
        Date.valueOf(input) : les.getEndDate());
    
    System.out.printf("총 수업시간(%d) : ", les.getTotalHours());
    input = keyboard.nextLine();
    tmp.setTotalHours(input.length() > 0 ?
        Integer.parseInt(input) : les.getTotalHours());
    
    System.out.printf("일 수업시간(%d) : ", les.getDayHours());
    input = keyboard.nextLine();
    tmp.setDayHours(input.length() > 0 ?
        Integer.parseInt(input) : les.getDayHours());
    
    arrayList.set(index, tmp);
    System.out.println("update complete ...");
  }
  
  
  public void deleteLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if(!validate(index)) return;
    
    arrayList.remove(index);
    System.out.println("delete complete ...");
  }
  
  
  private int indexOf(int lessonNo) {
    for (int k = 0; k < arrayList.getSize(); k++) {
      Lesson item = arrayList.get(k);
      if (item.getNo() == lessonNo) {
        return k;
      }
    }
    return -1;
  }
  
  
  private int promptLessonNo() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    return no;
  }
  
  
  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("not find num ...");
      return false;
    }
    return true;
  }

  
}
