//문자 리터럴
package ch02;
public class Test07 {
  static final char a= '가';
  public static void main(String[] args) {
    //'가' 문자를 출력하라
    System.out.println('\uac00');
    System.out.println((char)44032);
    System.out.println(0xac00); //UTF-16
    //해당 숫자가 UTF-16의 문자 코드임을 알려주지 않으면 println()은 일반 숫자인줄 알고
    //10진수로 출력한다;
    
    //해결책=====>>>>
    //숫자앞에 (char)을 붙여 이 숫자가 평벙한 숫자가 아니라
    //문자의 UTF-16 코드 값임을 알려줘라;
    System.out.println((char)0xac00);
    
    //++문자의 코드를 알지 못한다면 ('')를 이용해 알 수 있다
    //  '가'? ==> 한글 '가'의 UTF-16 값을 return;
    //  또한 이 값이 문자의 코드 값임을 알려준다;
    // UTF-16은 2바이트 크기를 갖는다;
    //  코드의 값은 0~65535이다; 
    //  문자코드라서 음수가 x
    //  참고로 숫자 2byte는 
    
    //0xac00 == '가' =true
    //싱글코테이션의 기능이 문자의 unicode를 모를때
    //unicode값을 리턴해주는 역할을 한다;
    System.out.println('가');
    System.out.println(0xac00 == '가');
    
    System.out.println('가'+2);
    System.out.println((char)('가'+2));
    System.out.println((char)0xac02);
    //싱글 코데이션 ('')의 return값은 unicode의 숫자값임;
    
    //싱글코테이션안에 직접 unicode(UTF-16)을 표기할 수 있다;
    System.out.println('\uac00');
    
    //싱글코테이션 안에 직접 유니코드를 지정하는 경우?
    //===>특수문자를 출력하는경우
    //===>코드에 해당하는 문자를 콘솔 창에 출력할 때는
    //    콘솔 창에서 사용하는 폰트에서 해당 문자를 찾는다.
    //    즉, 사용하는 폰트가 무엇이냐에 따라 출력하는 문자모양이 different;
    System.out.println('\u32d4');

   
  }
}

/*
 *#문자를 컴퓨터에 저장하는 방법
 *  -2진수화 시켜서 저장
 *
 *#문자의 2진수로 변환하는 규칙 =>문자 집합(character set)
 *  1) ASCII(7bit)
 *      미국국가 표준 협회에서 영어 알파벳 숫자 특수문자를
 *      컴퓨터에 저장할 수 있도록 정의한 인코딩 규칙
 *      7bit 2진수 encoding 규칙
 *   2) ISO-8859-1
 *      유럽 문자까지 포함하는 국제 표현 문자 인코딩 규칙
 *      
 *     ......나머지 git
 *
 */
