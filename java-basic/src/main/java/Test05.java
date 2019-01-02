public class Test05 {
      public static void main(String[] args){
              System.out.println("hello");
      }
}

/*

      public class Test05 {
             System.out.println("hello");
      }
      Error: Main method not found in class Test05, please define the main method as:
      public static void main(String[] args)
      or a JavaFX application class must extend javafx.application.Application
      
      실행
      JVM은 지정한 class file을 찾아 메모리에 loading 
      + main()이라는 이름의 명령어 블록()==메소드를 찾아 실행
      + 없으면 error 실행x
      + 최소껍데기 class + method 


      public class Test05 {
      void main() {
              System.out.println("hello");
            
            }
      }
      Error: Main method not found in class Test05, please define the main method as:
      public static void main(String[] args)
      or a JavaFX application class must extend javafx.application.Application

      제일중요한게 class name과 java file name을 일치
 */
