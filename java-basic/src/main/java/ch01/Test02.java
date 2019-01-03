//패키지 소속
//클래스를 package를 소속 시키려면 소스파일에 첫명령으로 작성해야함 package 명.명.명

package ch01; //이 소스 파일에 작성하는 모든 클래스는 ch01패키지에 소속
public class Test02 {
      public static void main(String[] args){
              System.out.println("hello");
      }
}






/* 
      #java package
            -package 무소속 class
                  특정 package에 소속되지 않은 class
                  실행할때 class 이름만 지정
                  ex) java-basic$ javac -d bin(<<현재 폴더위치에 따라 달라짐) src/main/java/Test01.java
                  ex) java-basic$ java -cp bin(<<현재 폴더위치에 따라 달라짐) Test01
            -package 소속 class
                  일반 class를 compile하는것과 같음
                  하지만 컴파일 하고 난 후 .class 파일은 패키지 이름에 해당하는 폴더에 놓인다.
                  package 이름 지정해야함
                  $ java -cp bin ch01.Test02
                  소스 파일도 자신이 소속된 패키지 폴더에 놓기 그래야 관리 쉬움
                  package 는 directory ex)a.b.c.Hello = src/main/java/a/b/c/Hello
                                       ex) java-basic$ java -cp bin a.b.c.Hello
      


*/