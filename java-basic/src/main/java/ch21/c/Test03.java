// 어플리케이션 예외의 종류 : Exception 계열 2
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test03 {
  public static void main(String[] args) 
      throws ClassNotFoundException    // 이 메서드에서 발생하는 예외의 목록을 지정한다
      , NoSuchMethodException          // 만약 메서드를 실행하는 중에 이런 예외가 발생한다면
      , InvocationTargetException      // 즉시 이 메서드의 실행을 멈추고
      , ReflectiveOperationException { // 이 메서드를 호출한 쪽에 예외 정보를 보고한다     
                                             // main()의 호출자는 JVM이다
    
    
    Scanner keyboard = new Scanner(System.in);

    // Exception 계열의 예외 처리 방법

    // 1) try ~ catch로 예외 받기
    // 자체적으로 처리해야할 문제
    //   try { 
    //   예외 발생 의심코드
    //    } catch(예외파라미터) { 
    //   예외처리코드
    //    }

    // 2) 호출자에게 예외처리 떠넘기기
    // 자체적으로 처리하는 것이 아니라 보고해야할 예외가 발생했을 때
    //    void 메서드명() throws 예외클래스명, 예외클래스명, ...{
    //             예외 발생코드
    //     }

    // 2) 메서드 선언부에 throws 절 추가
    // ==> 이 방식을 사용해야 하는 경우?
    //     이런 예외를 한 곳에서 처리하고 싶을 때 이 방식을 사용
    // ==> "여기서 예외처리하지말고 호출자가 처리하도록 보고" 라는 의미
    Class<?> clazz = Class.forName("ch21.c.PlusCommand");
    Constructor<?> constructor = clazz.getConstructor(Scanner.class);
    Command command = (Command) constructor.newInstance(keyboard);
    command.execute();



  }
}
