//자바 리터럴 literal - 리터럴과 메모리의크기 
//
package ch02;

public class Test02 {
  public static void main(String[] args){
    
    //20억을 4바이트 리터럴로 출력
    System.out.println(2000000000);
    
    //20억을 8바이트 리터럴로 출력
    System.out.println(2000000000L);
    
    //30억을 8바이트 리터럴로 출력
    System.out.println(3000000000L);
    
    //30억을 4바이트 리터럴로 출력
    //System.out.println(3000000000);
   

  }
}

/*
#4바이트 정수 리터럴
100

#8바이트 정수 리터럴 (정수뒤 접미사 L)
100l
*/
