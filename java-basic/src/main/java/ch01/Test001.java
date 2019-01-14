//패키지 무소속
public class Test001 {
  public static void main(String[] args){
    System.out.println("hello");
  }
}
/* 
      #java package
            -package 무소속 class
                  특정 package에 소속되지 않은 class
                  실행할때 class 이름만 지정
                  ex) java-basic$ javac -d bin src/main/java/Test01.java
                  ex) $ java -cp bin Test01
            -package 소속 class
                  package 이름 지정해야함
                  $ java -cp bin ch01.Test02
      


*/