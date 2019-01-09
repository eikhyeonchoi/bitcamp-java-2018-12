package com.company.product00;

public class literal_print {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.print("asdasd");
    
    //printf()는 printf(format ,args)로 구성된다;
    //print()의 상위 버전임..
    System.out.printf("%d",4874);
    
    //System.out.print("%d",412); =>compile error 발생1
    //System.out.println("%d",412); =>compile error 발생
    
    //println()은 기본 print()에 줄바꿈을 추가한것; 
    //  +연산으로 String 이나 integer를 연결할 수도 있다; print()도 마찬가지
    System.out.println("hello world!");
    System.out.println("hello world!2");
    System.out.println("hello "+"world!3");
  }
}


/*
 * 
 *메모리에 저장될때 모든것은 2진수(16진수)로 저장됨;
 *
 *#리터럴
 *  정수, 부동소수점, 논리값, 문자, 문자열
 *  -정수 리터럴
 *      n비트 정수면 2^n개 까지 표현가능;
 *      음수 없으면 (2^n)-1 
 *      음수 있으면 -(2^n-1) ~ (2^n-1)-1
 *      메모리에는 보통 2의 보수법을 써서 메모리에 저장 ;(sign magnitudde, 1의보수, 2의보수, excess-k)
 *      =>왜? 마이너스(-)연산을 쓰지 않기위해// 애초에 저장할때 음수값으로 저장함;
 *      
 *  -부동소수점 리터럴
 *      부동소수점은 floar 32비트// double 64비트타입으로 나뉜다;
 *      부동소수점의 수를 2진수로 변환함;
 *      float 부호비트 1비트 지수부 8비트 가수부 23비트 
 *      double       1         11        52
 *      가수부의 남은 부분은 0으로채우면됨
 *      지수부는 excess-k방식을 가수부는 sign magnitude방식을 사용함
 *      2진수로 바꾼뒤 정규화 실행해서 메모리에 저장함
 *      =>결론은 float의 유효자리=7  double의 유효자리=15
 *      
 *  -문자열 리터럴
 *      문자열을 저장하고 싶어도 2진수로 저장해야함;
 *      =>그래서 UTF-8에 character set으로 encoding 한것;
 *
 *
 * 
 * 
 * 
 * 
 * 
 */
















