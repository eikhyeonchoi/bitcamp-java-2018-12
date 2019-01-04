// 키보드로 입력한 값 받기 1
package ch03;

public class Test06 {
  public static void main(String[] args) {
    
    // 키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다.
    java.io.InputStream in = System.in;
    // 입력받을 메소드를 InputStream을 만들고 in이라고하자 ㅎㅎ
    
    
    // InputStream은 바이트 단위로 읽는 기능이 있다.
    // 바이트 단위로 읽어서 int나 문자열로 바꾸려면 또 코딩해야 하기 때문에
    // 이러한 불편함을 줄이기 위해 java에서는 바이트를 개발자가 원하는 값으로
    // 바꿔주는 기능을 제공 ==>그런 기능이 들어있는 도구가 java.util.Scanner임.
    java.util.Scanner keyboard = new java.util.Scanner(in);
    // InputStream은 불편하니까 Scanner에다가 in을 붙이고 이름은 keyboard라 하자ㅎㅎ
    
    //  사용자에게 입력하라고 간단히 출력
    System.out.print("이름을 입력하쇼 : ");
    // 안내문을 출력하자ㅎㅎ
    
    // Scanner패키지에 들어있는 nextLine() 메소드는 사용자가 한줄을 입력할때 까지(LF을 읽을때 까지)기다리다가
    //  사용자가 한 줄을 입력하면 그 값을 문자열로 만들어 return 
    java.lang.String string = keyboard.nextLine();
    // keyboard로 한줄 입력받고 string에다가 저장하자ㅎㅎ
    
    //사용자가 입력한 문자열을 출력한다
    System.out.printf("입력하신 문자는 %s입니다.\n",string);
    // 입력받은 string을 출력해보자ㅎㅎ
  }
}

/*
 * 
 * 
 */


