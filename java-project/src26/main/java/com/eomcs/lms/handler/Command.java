package com.eomcs.lms.handler;

// 명령어를 처리하는 객체의 사용 규칙을 정의 한다
public interface Command {
  
  // 명령어를 처리하고 싶을때 처리하는 메서드이다
  void execute();
}
