// 추상클래스 -> 인터페이스
package com.eomcs.lms.service;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 클라이언트의 요청을 처리하는 클래스라는 의미
// ~~~Service
public interface Service {
  
  public abstract void execute(String request, 
      ObjectInputStream in, ObjectOutputStream out) throws Exception;

}
