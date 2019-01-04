//문자 제어코드
package ch02;
public class Test10 {
  public static void main(String[] args) {
    System.out.println("hello,\nworld!");
    System.out.println("hello,\rworld!");
    System.out.println("hello,\b\b\bworld!");
    System.out.println("hello,\tworld!");
    System.out.println("hello,\fworld!");
    System.out.println("hello,\"w\"orld!");
    System.out.println("hello,'w'orld!");
    System.out.println('\'');
    System.out.println("\"");
    System.out.println("hello, \\w\\orld!");
  }
}

/*#문자제어코드 = escape character
 * -화면에 출력하는 문자가 x => 문자출력을 제어하는 문자
 *      \n:줄바꿈 Line Feed, 0x0a;
 *      \r:Carrage return, 0x0d; =\n
 *      \f:Form Feed, 0x0c;
 *      \t:tab, 0x09;
 *      \b:Back Space, 0x08;
 *      \':Single Quote, 0x27;
 *      \":Double Quote, 0x22;
 *      \\:Back Slash, 0x5c;
 * 
 */
