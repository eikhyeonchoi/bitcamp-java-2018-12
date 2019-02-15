// RMI기술 사용하기 - 원격 인터페이스 정의하기
package design_pattern.proxy.rmi.server;
import java.rmi.Remote;
import java.rmi.RemoteException;

// 원격 인터페이스(remote interface)
// ==> remote 객체의 사용규칙을 정의한 인터페이스
// ==> RMI기술을 적용하려면 java.rmi.Remote 인터페이스를 상속받아야한다
public interface Calculator extends Remote {
  
  // 메서드는 java.rmi.RemoteException이 발생할 수 있다
  // 따라서 throws 절을 선언해야함
  public int plus(int a, int b) throws RemoteException;
  public int minus(int a, int b) throws RemoteException;
} // end of class
