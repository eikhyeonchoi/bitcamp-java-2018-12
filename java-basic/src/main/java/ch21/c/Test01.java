// 어플리케이션 예외의 종류 : Exception 계열, RuntimeException계열
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    // 1) Exception 계열
    // ==> try ~ catch를 강요하는 예외
    // ==> 예외처리를 하지 않으면 컴파일 오류가 발생
    // ==> 단 Exception의 자식 클래스인 RuntimeException은 제외

    // forName() 메서드
    // ==> 파라미터로 지정한 클래스를 찾아 메모리에 로딩하는 일을 한다
    // ==> 리턴값은 로딩한 클래스 정보
    // ==> 이 메서드는 파라미터에서 지정한 클래스를 찾지 못했을 때 예외를 발생시킨다
    //     ClassNotFoundException를 발생시킨다
    // ==> 이 예외는 Exception의 자식 클래스이다
    //     Exception의 자식클래스이고 RuntimeException계열이 아닐 경우
    //     try ~catch 블록으로 반드시 예외를 받도록 처리해야 한다
    
    // getConstructor()
    // ==> 생성자를 찾아 return
    // ==> 만약 지정된 생성자를 찾지 못하면 NoSuchMethodException 예외발생
    // ==> 이 메서드도 Exceptionr계열이라 반드시 try ~ catch를 사용해 예외처리 해야함
    
    // newInstanc() 메서드
    // ==> 생성자를 이용하여 인스턴스를 만든다
    // ==> 만약 인스턴스를 만들지 못한다면 Exception 계열의 예외를 발생시키기 때문에
    // ==> 반드시 try~catch를 사용해 예외 처리 해야함
    
    // 2) RuntimeException 계열
    // ==> Exception 클래스의 서브 클래스
    // ==> 이 계열은 예외처리가 필수가 아님 선택임
    // ==> try~catch를 쓰지 않아도 compile error 발생
    // ==> 그러나 예외를 처리하지 않으면 JVM에게 보고 되고 JVM은 프로그램을 멈추기 때문에
    // ==> 어플리케이션을 개발할 때 이런 예외도 처리해야함
    
    // execute()메서드
    // ==> PlusCommand나 DivideCommand의 execute() 메서드는
    //     내부적으로 NumberFormatException, ArithmeticException이 발생한다
    // ==> 그런데 이들 예외는 RuntimeException계열이라 catch블록에서 예외를 반드시 받아야 하는것은 아님
    //     그래서 아래의 try~catch 블록에 이들 예외를 처리하는 catch블록이 없는 것
    try {
      // 사용자로부터 로딩할 클래스 이름을 입력받음
      System.out.print("실행할 Command 클래스 이름 >> ");
      String className = keyboard.nextLine();
      
      // 사용자가 알려준 클래스를 로딩한다 
      Class<?> clazz = Class.forName(className);
      
      // 클래스 정보를 가지고 Scanner를 파라미터로 받는 생성자를 얻어낸다
      Constructor<?> constructor = clazz.getConstructor(Scanner.class);
      
      // 생성자를 가지고 인스턴스를 생성한다
      Command command = (Command) constructor.newInstance(keyboard);
      
      // 커맨드 객체를 실행한다
      // ==> execute()에서 발생하는 예외는 모두 RuntimeException계열의 예외라
      //     반드시 catch블록을 안해도 된다
      command.execute();
      
    } catch (ClassNotFoundException e) {
      // 예외를 발생시키는 방법
      // class이름을 입력할 때 ch21.c.ok
      System.out.println("해당 클래스를 찾지 못했습니다");
      
    } catch (NoSuchMethodException e) {
      // 예외를 발생시키는 방법
      // class이름을 입력할 때 java.lang.String << Scanner를 받는 생성자가 없음
      System.out.println("해당 생성자를 찾지 못했습니다");
      
    } catch (ReflectiveOperationException e) {
      System.out.println("기타 예외 발생");
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
