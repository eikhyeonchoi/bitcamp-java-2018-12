package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.ArrayList;

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
  }
  
  public void detailLesson() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    int res = -1;   
    Lesson[] lessons = arrayList.toArray(new Lesson[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (lessons[k].getNo() == no) {
        res = k;
        break;
      }
    }
    if (res == -1) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    }
    Lesson detail = arrayList.get(res);
    System.out.printf("수업명 : %s\n", detail.getTitle());
    System.out.printf("설명 : %s\n", detail.getContents());
    System.out.printf("시작일 : %s\n", detail.getStartDate());
    System.out.printf("종료일 : %s\n", detail.getEndDate());
    System.out.printf("총 수업시간 : %d\n", detail.getTotalHours());
    System.out.printf(" 수업시간 : %d\n", detail.getDayHours());
  }
  
  public void updateLesson() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    int res = -1;   
    Lesson[] lessons = arrayList.toArray(new Lesson[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (lessons[k].getNo() == no) {
        res = k;
        break;
      }
    }
    if (res == -1) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    }
    Lesson originalLesson = arrayList.get(res);
    Lesson newLesson = new Lesson();
    newLesson.setNo(originalLesson.getNo());
    System.out.printf("수업명(%s) : ", originalLesson.getTitle());
    String input = keyboard.nextLine();
    newLesson.setTitle(input.length() > 0 ?
        input : originalLesson.getTitle());
    
    System.out.printf("설명(%s) : ", originalLesson.getContents());
    input = keyboard.nextLine();
    newLesson.setContents(input.length() > 0 ?
        input : originalLesson.getContents());
    
    System.out.printf("시작일(%s) : ", originalLesson.getStartDate());
    input = keyboard.nextLine();
    newLesson.setStartDate(input.length() > 0 ?
        Date.valueOf(input) : originalLesson.getStartDate());
    
    System.out.printf("종료일(%s) : ", originalLesson.getEndDate());
    input = keyboard.nextLine(); 
    newLesson.setEndDate(input.length() > 0 ?
        Date.valueOf(input) : originalLesson.getEndDate());
    
    System.out.printf("총 수업시간(%d) : ", originalLesson.getTotalHours());
    input = keyboard.nextLine();
    newLesson.setTotalHours(input.length() > 0 ?
        Integer.parseInt(input) : originalLesson.getTotalHours());
    
    System.out.printf("일 수업시간(%d) : ", originalLesson.getDayHours());
    input = keyboard.nextLine();
    newLesson.setDayHours(input.length() > 0 ?
        Integer.parseInt(input) : originalLesson.getDayHours());
    
    arrayList.set(res, newLesson);
    System.out.println("수정이 완료되었습니다 ...");
    
  }
  
  public void deleteLesson() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    int res = -1;   
    Lesson[] lessons = arrayList.toArray(new Lesson[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (lessons[k].getNo() == no) {
        res = k;
        break;
      }
    }
    if (res == -1) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    }
    arrayList.remove(res);
    System.out.println("삭제가 완료되었습니다 ...");
  }
  
}
