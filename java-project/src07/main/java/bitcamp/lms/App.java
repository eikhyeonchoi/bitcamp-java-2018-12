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
    /*
    for (int i = 0; i < les.length; i++ ) {
      les[i] = new Lesson();
    }
    이 방법도 가능하지만 이 방법은 미리 메모리(인스턴스, 객체)를 만들기 때문에
    쓰이지 않아도 메모리를 쓸데 없이 점유 하고있어 좋은방법은 아니다
    딱 사용할 메모리만 만드는게 메모리 관리에 효율적이다.
    
    임시 인스턴스를 만들고 임시 레퍼런스로 주소 값을 받아 
    그 임시 레퍼런스의 주소값을 레퍼런스 배열의 각 항목에
    임시 레퍼런스 주소를 넣어주면 필요한 만큼만 만들 수 있어 좋다
    
    임시 인스턴스를 하나만 만들면 안됨 그렇게하면은
    레퍼런스 배열의 모든 항목이 한 인스턴스의 주소를 받기 때문에
    모두 값이 같아지는 문제가 발생
    임시로 만든 인스턴스도 필요한 레퍼런스 배열의 각 항목 만큼의 갯수를
    만들어야함 그렇게 하지 않으면 값이 덮어쓰여 지게 되기 때문에
    가장 마지막에 입력한 값만 존재하게 되는것
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    레퍼런스 배열의 각 항목은 주소값임 값을 주는게 아님!!!!!!!!!!!!!!!!!!!!!!!!!
    값를 넣는게 아니라 레퍼런스 배열의 각 항목에 레퍼런스(주소)를 넣는것
    lessons[index] = temp;
    lessons[index] 이것도 레퍼런스, temp 이것도 레퍼런스 주소를 이어주는것
    
    ==> 내가 한 실수
    
    */
    
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
