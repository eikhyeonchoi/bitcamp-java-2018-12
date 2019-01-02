//주석

//한 줄 주석 - 라인 끝까지 주석으로 취급
package ch01; 
/**
java doc 주석이라 한다.
즉 java API(HTML)문서를 생설할 때 참고하는 주석이다.
클래스, 변수, 메소드 선언에 붙인다.
 */
public class Test03 {

      /**
            이 메서드는 object class의 메소드를 재정의한 것이다.
       */
      @Override // 애노테이션이라 부르는 주석이다. 프로그램에서 사용한다.
      public String toString() {
            return "ok";
      }


      public static void main(String[] args){
              System.out.println("hello");
      }
}

/* 
여러 줄 주석     
      #javadoc 사용법
      $ java -d [폴더] -sorucepath [소스폴더] 패키지명
      ex) $ javadoc -d -sourcepath src/main/java ch01
*/