// 예외처리 - 예외의 종류
package ch21.a;

public class Test01 {
  public static void main(String[] args) {

    // 1) 시스템 예외
    // ==> JVM이 발생시키는 예외
    // ==> 어플리케이션에서 처리할 수 없다
    // ==> 어플리케이션의 현재 작업 결과를 적절히 저장한 후 즉시 종료해야 한다
    // ==> Error 계열의 예외이다
    //     java.lang.Object
    //         ㄴ java.lang.Throwable
    //            ㄴ java.lang.Error
    // ==> 예) Stack.OverflowError, OutOfMemoryError, IOError, ThreadDeath

    // StackOverflowError 발생시키기
    // ==> 예외를 처리하지 않으면 JVM에게 예외가 전달되고 JVM은 즉시 멈춘다
    // ==> JVM이 멈추기 전에 현재까지 작업한 것을 저장하고 싶다면 예외처리코드를 추가해야한다
    System.out.println(sum(5));


    // 2) 어플리키에션 예외
    // ==> 어플리케이션에서 발생시키는 예외이다
    // ==> 예외처리라 함은 이 어플리케이션의 예외를 다루는 것을 말한다
    // ==> 어플리케이션에서 예외를 처리하지 않으면 JVM은 실행을 멈춘다
    // ==> 실행을 멈추지 않게 하려면 어플리케이션 예외가 발생했을 때 적절히 조취를 취해야 한다
    // ==> exception계열의 예외이다
    //  java.lang.Object
    //         ㄴ java.lang.Throwable
    //            ㄴ java.lang.Error
    // ==> 예) ArrayOutOfBoundException, ClassCastException ,ClassNotFoundException
    //       IndexOutOfBoundsException, NumberFormatException, NullPointerException
    //       IOException, SQLException,  FileNotFoundException,  SocketException
    //       MalformedURLException, RuntimeException,  ArithmeticException
    
    // 어플리케이션 예외 발생시키기
    // ==> 예외를 처리하지 않으면 JVM에게 전달되고, JVM은 즉시 멈춘다
    int result = 100 / 0;
    
    // 위의 코드에서 예외가 발생하면 다음 코드를 실행할 수 업삳
    // 왜? 즉시 JVM에게 예외 내용이 보고되고, JVM은 실행을 멈춘다
    System.out.println("완료");

  }

  static long sum(long value) {
    if (value == 0) return 0;
    return value + sum(value-1);
  }
}
/*
예외 클래스 계층도
java.lang.Throwable
    ㄴ java.lang.Error : 시스템 예외
    ㄴ java.lang.Exception : 어플리케이션 예외

==> catch 블록의 파라미터는 반드시 Throwable 타입이어야함
==> 메서드 선언부에 붙이는 throws의 클래스도 반드시 Throwable 타입이어야함
==> 예외를 던질 때 사용하는 throw의 객체도 반드시 Throwable 타입이어야함















*/





























