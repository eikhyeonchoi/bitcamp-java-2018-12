// 어플리케이션 예외의 종류 : Exception 계열 1
package ch21.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    
    // Exception 계열의 예외 처리 방법
    
    // 1) try ~ catch로 예외 받기
    //   try { 
    //   예외 발생 의심코드
    //    } catch(예외파라미터) { 
    //   예외처리코드
    //    }
    
    // 2) 호출자에게 예외처리 떠넘기기
    //    void 메서드명() throws 예외클래스명, 예외클래스명, ...{
    //             예외 발생코드
    //     }
    
    //l 1) try~catch
    try {
      Scanner keyboard = new Scanner(System.in);
      Class<?> clazz = Class.forName("ch21.c.PlusCommand");
      Constructor<?> constructor = clazz.getConstructor(Scanner.class);
      Command command = (Command) constructor.newInstance(keyboard);
      command.execute();
    } catch (ClassNotFoundException e) {
      System.out.println("해당 클래스를 찾지 못했습니다");
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ReflectiveOperationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    System.out.println("종료");
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
