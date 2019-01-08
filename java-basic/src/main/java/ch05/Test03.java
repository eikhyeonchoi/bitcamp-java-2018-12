// 흐름 제어문 - if ~ else if ~ else if ~ else
package ch05;

public class Test03 {

  public static void main(String[] args) {
    
    int age = 70;
    if (age < 8)
      System.out.println("유아입니다");
    else {
      if(age >=8 && age < 14) 
        System.out.println("어린이입니다");
      else {
        if(age >=14 && age < 65)
          System.out.println("성년입니다");
        else 
          System.out.println("노인입니다.");
      }
    }
    
    // 변형1
    // if ~ else는 한 문장이다
    // 따라서 if ~ else만 있을 때는 중괄호로 묶지 않아도 된다
    
    if (age < 8)
      System.out.println("유아입니다");
    else 
      if (age >=8 && age < 14) 
        System.out.println("어린이입니다");
      else 
        if (age >=14 && age < 65)
          System.out.println("성년입니다");
        else 
          System.out.println("노인입니다.");
    
    // 변형2
    if (age < 8)
      System.out.println("유아입니다");
    else if (age >=8 && age < 14) 
      System.out.println("어린이입니다");
    else if (age >=14 && age < 65)
      System.out.println("성년입니다");
    else 
      System.out.println("노인입니다.");
    // if ~ else if ~ else if ~ else 문법은 존재하지x
    // 오직 if else문법만 있을뿐 ==> 변형1 참조
    
    age = 17;
    if (age > 19)
      if(age >=65)
        System.out.println("노인입니다");
    else
      System.out.println("미성년입니다");
    // else 문은 가장 가까운 if에 종속된다. 모양으로 보면안된다.
    // 이 조건문은 age = 17이기때문에 조건문 자체를 실행하지 않고 넘어간다.
    // 들여쓰기에 속으면 안된다 중괄호로 묶어 그냥 ㄱㄱ
    
    
    
  }
}
/*
 * 
 * 
 * 
 * 
 * 
 */
