public class Test06 {
      public static void main(String[] args){
              System.out.println("hello");
      }
}






/* 
      컴파일 옵션
      $ javac 소스.java 
      =>현재 폴더에 .class file 생성 
      => 난잡해짐 .java와 .class 구분해야함 source file // bytecode file
      => .class file 폴더 지정
      $ javac -d [.class file 저장경로] 소스.java

      다른 폴더에 있는 .class file 실행
      $ java -cp [.class 경로] 클래스명 

      .class 경로 안주면
      Error: Could not find or load main class Test06
      Caused by: java.lang.ClassNotFoundException: Test06

      =>보통 .class file은 project에서 실행


*/