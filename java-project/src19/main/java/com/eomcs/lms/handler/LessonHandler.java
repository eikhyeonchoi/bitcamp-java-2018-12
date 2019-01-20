package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

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
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0 ) {
      System.out.println("해당 번호를 찾을 수 없습니다");
    }
    Lesson showLesson = arrayList.get(ans);
    System.out.printf("수업명 : %s\n", showLesson.getTitle());
    System.out.printf("설명 : %s\n", showLesson.getContents());
    System.out.printf("시작일 : %s\n", showLesson.getStartDate());
    System.out.printf("종료일 : %s\n", showLesson.getEndDate());
    System.out.printf("총 수업시간 : %s\n", showLesson.getTotalHours());
    System.out.printf("일 수업시간 : %s\n", showLesson.getDayHours());
    
  }
  public void updateLesson() {
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0 ) {
      System.out.println("해당 번호를 찾을 수 없습니다");
    }
    Lesson les = new Lesson();
    les.setNo(ans);
    System.out.print("수업명 : ");
    les.setTitle(keyboard.nextLine());
    System.out.print("설명 : ");
    les.setContents(keyboard.nextLine());
    System.out.print("시작일 : ");
    les.setStartDate(Date.valueOf(keyboard.nextLine()));
    System.out.print("종료일 : ");
    les.setEndDate(Date.valueOf(keyboard.nextLine()));
    System.out.print("총 수업시간 : ");
    les.setTotalHours(Integer.parseInt(keyboard.nextLine()));
    System.out.print("일 수업시간 : ");
    les.setDayHours(Integer.parseInt(keyboard.nextLine()));
    arrayList.set(ans, les);
    System.out.println("upadte complete ...");
    
  }
  public void deleteLesson() {
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0 ) {
      System.out.println("해당 번호를 찾을 수 없습니다");
    }
    arrayList.remove(ans);
    System.out.println("delete complete ...");
    
  }
  
}
