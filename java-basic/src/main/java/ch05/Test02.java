// 흐름 제어문 - if 조건문
package ch05;

public class Test02 {

  public static void main(String[] args) {
    
    int age = 12183749;
    
    //기본 형식
    if(age >=20) 
      System.out.println("성인 입니다");
    else
      System.out.println("미성년 입니다");
    
    // 여러 문장을 실행할 때 블록으로
    /*
    if(age >=20) 
      System.out.println("--------");
      System.out.println("성인 입니다");
    else
      System.out.println("--------");
      System.out.println("성인 입니다");
    */
    
    // K & R형식을 고수할 것.
    if(age >=20) {
      System.out.println("--------");
      System.out.println("성인 입니다");
    } else {
      System.out.println("--------");
      System.out.println("성인 입니다");
    }
    
    // if문만 작성할 수 있지만
    // else문은 홀로 존재할 수 없다 
    
    
  }
}
/*
 * 
 * 
 * 
 * 
 * 
 */
