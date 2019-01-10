package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.Lesson;

public class App {
  static int count = 1;
  public static void main(String[] args) {
    final int L = 10;
    
    Scanner key = new Scanner(System.in);
    Lesson[] les = new Lesson[10];
    
    for (int k = 0; k < L; k++) {
      Lesson temp = new Lesson();
      System.out.print("제목 : ");
      temp.title = key.nextLine();
      System.out.print("내용 : ");
      temp.content = key.nextLine();
      System.out.print("강사 : ");
      temp.teacherName = key.nextLine();
      System.out.print("시작일 : ");
      temp.stDate = Date.valueOf(key.nextLine());
      System.out.print("종료일 : ");
      temp.edDate = Date.valueOf(key.nextLine());
      System.out.print("총 수업시간 : ");
      temp.totTime = Integer.parseInt(key.nextLine());
      System.out.print("하루 수업 시간");
      temp.dayTime = Integer.parseInt(key.nextLine());
      
      les[k] = temp;
      
      System.out.print("\n 계속 ? (y/n) : ");
      String ans = key.nextLine();
      if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        printList(les);
        break;
      } else {
        count++;
        continue;
      }
      
      
    }
  }
  
  static void printList(Lesson[] les) {
    for(int a = 0; a < count; a++) {
      System.out.printf("%s, %s, %s, %s, %s, %d, %d\n"
          ,les[a].title, les[a].content, les[a].teacherName, les[a].stDate
          ,les[a].edDate, les[a].totTime, les[a].dayTime);
    }
  }
}
