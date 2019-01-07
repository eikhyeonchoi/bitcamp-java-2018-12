//변수 선언과 메모리크기
package ch03;

public class Test01 {
  public static void main(String[] args) {
    
    //1바이트 정수값을 담을 메모리
    byte b1;
    byte b2;
    byte b3;
    
    b1 = -128; // 리터럴 값이 비록 4바이트 크기이지만 메모리에 넣을 수 있다면 허락; 128은 4바이트임;
    b2 = 127; // 단 8바이트값은 담을 수 있더라도 허락하지 않음; 127L x
    // b3 = 128; 128은 1바이트를 초과함; compile error   -127~128 리터럴 표현오류
    // 결론==> byte는 1byte저장소 이며 -128 ~ 127 까지의 범위를 가진다
    //        하지만 범위내의 정수 값(4byte)을 저장하는건 허락된다 but, 8바이트는 x
   
    
    // 2바이트
    short s1;
    short s2;
    short s3;
    
    s1 = -32768;
    s2 = 32767; // 8바이트 리터럴 x 300L도 안됨; 2바이트에 8바이트를 넣을 수 없음;
    // s3 = 32768; 리터럴 표현오류
    // 결론==> short는 2byte저장소 이며 -32768 ~ 32767 까지의 범위를 가진다
    //        하지만 범위내의 정수 값(4byte)을 저장하는건 허락된다 but, 8바이트는 x
    
    
    //4바이트
    int i1;
    int i2;
    int i3;
    
    i1 = -2100000000;
    i2 = 2100000000; // 8바이트 리터럴x 2100000000L도 안됨; 8바이트를 4바이트 메모리에 넣을 수 없음;
    //i3 = 2200000000 4바이트는 표현 못함 리터럴 표현오류 =>4바이트초과
    // 결론==> int는 4byte저장소 이며 -21억 ~ 21억 까지의 범위를 가진다
    //       but, 8바이트는 x 저장할 수 없다.
    
    //8바이트
    long l1;
    long l2;
    long l3;
    
    l1 = 9000000000000000000L;
    //l2 = 9900000000000000000L; 리터럴 표현오류
    // ~21억 ~ 21억 까지는 기본적으로 4byte로 저장됨
    // 8바이트로 저장할라면 무조건 L붙임;
    // 21억 넘어가면 메모리에 저장하기전 리터럴 error 발생함;
    // 결론==> double은 8byte저장소 이며 -900경 ~ 900경 까지의 범위를 가진다
    //       but, 범위내의 정수 값이라도 8바이트를 저장하기 위해선 접미사L을 붙인다
     //        물론, 범위를 초과하는 수는 저장할 수 없다.
    
    //부동소수점 4바이트
    float f1;
    float f2;
    
    f1 = 9876.543f;
    f2 = 12.34567f; //유효 자릿수를 넘어 가는 경우 짤려서 저장된다 유효7
                              //정수 메모리와 달리 compile error 발생하지 않음
                              //그래서 더욱 주의해서 사용해야함;
    
    System.out.println("f1 = "+f1);
    System.out.println("f2 = "+f2);

    
    
    // 결론==> float은 4byte저장소 이며 지수부, 가수부를 포함한 유효자리 7자리를 가진다.
    //       but, 4byte로 메모리에 저장하기 위해선 접미사f를 붙여야한다 
    //              안붙이면 8바이트로 취급함.
    
    
    
    //8바이트
    double d1;
    double d2;
    
    d1 = 98765.43; //주의!! 8바이트 부동소수점을 표현할 때는 f,F접미사를 제거
    d2 = 98765.43456789;
    System.out.println(d1);
    System.out.println(d2); //유효 15자리까지 대부분 짤리지 않고 들어감;
    // 결론==> double은 8byte저장소 이며 지수부, 가수부를 포함한 유효자리 15자리를 가진다.
    //       but, 4byte로 메모리에 저장하기 위해선 접미사f를 붙여야한다 
    //              안붙이면 8바이트로 취급함.
    
    // 정수변수, 부동소수점 변수 ==> 정수변수 byte short int double(char도 가능)는
    //                            범위내의 4byte 정수를 저장할 수 있다 //벗어나면 x
    //                            그래서 double은 8byte기 때문에 접미사 L
    //                            부동소수점변수 float double 기본 8byte 취급
    //                            그래서 float은 4byte기 때문에 접미사 f
    
    //논리값
    boolean bool1;
    boolean bool2;
    boolean bool3;
    
    bool1 = true;
    bool2 = false;
    //bool3 = 1; compile error ==> true false 외 다른값 저장 x
    // 결론==> 저장할때 4byte int를 사용해 저장하지만 정수는 저장할 수 없고
    //         오로지 true false 값만 저장할 수 있다.
    
    //문자의 UTF-16 코드값을 담을 메모리 준비
    char c1;
    char c2;
    char c3;
    
    c1 = 44032; // 4바이트 정수 리터럴이더라도 0~65535까지의 값이라면
                  // char 메모리에 저장하는 것을 허락
    c2 = 0xac00;
    c3 = '가'; // single quote의 return 값은 2바이트 unicode 정수 값;
    System.out.println(c1); //변수 자체가 char이라 형변환(char)을 안붙여도됨;
    System.out.println(c2);
    System.out.println(c3);
  }
}

/* 
 * # 변수
 * - 값을 저장하는 메모리
 * 
 * # 변수선언
 * - 값을 저장하는 메모리를 준비하는 명령 (위치와 크기결정) => 결정하고 메모리에 이름부여
 * - 변수를 선언한 후 그 이름을 사용해 메모리에 접근하고 값을 넣고 꺼냄;
 * - 메모리를 만든다는건 잘못된 표현
 * - 문법
 *      종류 이름; ex) int a;
 *      
 * # 종류
 * - 정수 메모리
 *      byte(1byte) : -128 ~ 127
 *      short(2byte) : -32768 ~ 32767
 *      int(4byte) : -21억 ~ 21억
 *      long(8byte) : -900경 ~ 900경
 *      
 * - 부동소수점 메모리
 *      float(4byte) : 유효 7
 *      double(8byte) :유효 15
 *      
 * - 논리 메모리
 * - 문자 메모리
 * 
 * 
 */