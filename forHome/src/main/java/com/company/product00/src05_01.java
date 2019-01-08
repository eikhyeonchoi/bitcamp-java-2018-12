package com.company.product00;

public class src05_01 {

  public static void main(String[] args) {
    
    //java primitive data type;
    byte b1;
    b1 = 125; //byte는 1byte변수지만 범위내의 4byte도 저장가능하다;
    //byte b2;
    //b2 = -129;  ==> 범위를 벗어난 '값'이기 때문에 저장불가능;
    
    short s1 = 32767; //short는 2byte변수지만 범위내의 4byte도 저장가능하다;
    //위처럼 코딩한것이 변수 선언과 동시에 초기화를 한것이다. 만약 값이 없는 변수를 바로
    //사용한다면 compile error가 발생한다.
   //short s1 = -32769 ==> 범위를 벗어난 '값'이기 때문에 저장 불가능;
    
    //변수와 초기화
    int a;
    // System.out.println(a); 
    // 변수를 선언하고 아무 값, 주소가 저장되어 있지 않은 상태로 사용하려고 하면
    // compile error가 발생함;
    
    int i1 = 220000000; //정수 4byte저장가능;
    // int i2 = 2200000000; ==> 범위를 초과하는 '값'이기 때문에 저장불가능;
    
    long l1 = 2200000000L;
    // 4바이트 범위를 넘어가는 '값'은 접미사L을 붙여 8바이트로 저장한다는 것을 명시해야 
    // compile error가 발생하지 않음; ==> 정수 저장 기본이 4바이트로 저장됨
    long l2 = 320; // 기본 4바이트로 저장되기 때문에 에러 안남;
    
    // float f1 = 987.654; 부동소수점은 기본이 8바이트이기 때문에 
    // 접미사 f를 붙여 4바이트로 저장한다고 명시하지 않으면 compile error 발생함
    float f2 = 987.61154f; //하지만 유효자리 벗어나도 compile erro가발생하지
                               //때문에 주의를 요한다.
    
    double d1 = 987.654; // 부동소수점 저장이 기본 8바이트이기 때문에 error가 발생x
    
    
    /////////////////////////////////////////////////////////////////////////////
    //#입력함수 
    //문자열 입력 후 출력
    /*
    java.util.Scanner key = new java.util.Scanner(System.in);
    System.out.print("이름 : ");
    String name = key.nextLine();
    System.out.printf("%s",name);
    */
    
    //정수와 문자열을 같이 출력하려면 ???
    java.util.Scanner key2 = new java.util.Scanner(System.in);
    System.out.print("번호 : ");
    int num01 = key2.nextInt();
    // 여기서 nextInt()의 문제가 발생한다 이름을 입력하지 않았는데 공백문자가 들어간뒤 바로 출력됨;
    // 내부 버퍼를 생각해보자 키보드로 h/w를 직접 다룰 수 없다
    // 키보드로 입력된 내용은 내부buffer로 이동한후 os가 내부buffer를 읽으면서 수행된다.
    // 여기서 nextInt()는 token단위로 읽는 메서드이다 때문에 번호(숫자)를 입력하고 엔터를하면
    // 내부버퍼에는 ex) 36LF가 입력된 후 nextInt()는 token단위로 인식하기 때문에 
    // 36을 읽고 난후 LF를 남겨둔다. 그럼 남겨뒀으니 이름 : 을 출력하고 name02변수에는
    // LF가 저장되기 때문에 바로 번호 : 36 이름 : 이렇게 출력되는것 
    // 즉 이름에는 공백문자가 저장되어 출력되는것이다 (name02는 입력 받지 않고)
    // 그럼 이 해결책은 LF코드를 없애는 것인데 LF코드를 써버리고 저장하지 않으면
    // 버리는것과 마찬가지이다 
   
    // key2.nextLine(); 을 해주면 LF코드를 읽고 난 후 저장하는 과정이 없어 버리는것과 같다
    //key2.nextLine();
    
    System.out.print("이름 : ");
    String name02 = key2.next();
    
    System.out.printf("번호 : %d\n이름 : %s\n",num01, name02);
    
    
  }
}



/*
 * # 자바의 data type
 * - primitive data type
 *      정수형 기본 type 기본 4byte;
 *          byte : 1바이트 정수 변수(메모리) -128 ~ 127 // 범위내의 4byte저장가능
 *          short : 2바이트 정수 변수(메모리) -32768 ~ 32767 // 범위내의 4byte저장가능
 *          int : 4바이트 정수 변수(메모리) -21억 ~ 21억
 *          long : 8바이트 정수 변수(메모리) -900경 ~ 900경
 *                   정수 data type의 기본이 4byte이기때문에 (제일많이 쓰기 때문에)
 *                   접미사L을 붙여서 사용해야함 ex) long a = 4000000000L;
 *      부동소수점형 기본 type 기본 8byte;
 *          float : 4바이트 부동소수점 변수(메모리) // 유효숫자 7자리
 *                    부동소수점 data type이 기본 8바이트이기 때문에 접미사f를 붙여 사용해야함
 *                 ex) float a = 123.486f; 
 *          double : 8바이트 부동소수점 변수(메모리) // 유효숫자 15자리
 *      나머지
 *          boolean : 4바이트로 메모리에 저장되지만 정수값 저장 x, only true false만 저장
 *          char : 2바이트로 메모리에 저장 unicode값을 문자로 return;
 *                char a = 0xac00; 출력력과 ==> 가
 *                
 * -reference data type
 *      java의 primitive data type을 제외한 모든 data type은 reference라고 부른다.
 *       java의 primitive data type이 '값'을 저장한다면 reference는 메모리의 주소를 저장함
 *      =====>  new로 선언하는것 
 *      
 *      
 *      
 * # 출력 간단하게 정리
 * -printf() 줄바꿈 없는 포매터 출력;
 *      %d, %s, %c, %x ...
 * -print() 줄바꿈 없는 그냥 출력;
 * -println() 줄바꿈 있는 그냥 출력;
 * 
 *#문자제어코드 = escape character
 * -화면에 출력하는 문자가 x => 문자출력을 제어하는 문자
 *      \n : 줄바꿈 Line Feed, 0x0a;
 *      \r : Carrage return, 0x0d; =\n
 *      \f : Form Feed, 0x0c;
 *      \t : tab, 0x09;
 *      \b : Back Space, 0x08;
 *      \' : Single Quote, 0x27;
 *      \" : Double Quote, 0x22;
 *      \\ : Back Slash, 0x5c;
 *      
 * #입력 함수
 * java.io.InputStream k = System.in 이게 키보드 생성하는거
 * 하지만 키보드는 바이트단위로 읽어서 int나 String으로 자동형변환이 안됨;
 * 그래서 java.util.Scanner keyboard = new java.util.Scanner(System.in)를
 * 사용해서 보통 입력받는다
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/
