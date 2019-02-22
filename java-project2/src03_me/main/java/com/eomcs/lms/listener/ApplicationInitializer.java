package com.eomcs.lms.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class ApplicationInitializer implements ApplicationContextListener {

  Connection con;
  Scanner keyboard;
  
  @Override
  public void init(HashMap<String, Object> commandMap) {
    try {
      this.keyboard = (Scanner) commandMap.get("keyboard");

      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111");

      LessonDaoImpl lessonDao = new LessonDaoImpl(con);
      commandMap.put("/lesson/add", new LessonAddCommand(keyboard,lessonDao));
      commandMap.put("/lesson/list", new LessonListCommand(keyboard,lessonDao));
      commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard,lessonDao));
      commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard,lessonDao));
      commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard,lessonDao));

      MemberDaoImpl memberDao = new MemberDaoImpl(con);
      commandMap.put("/member/add", new MemberAddCommand(keyboard,memberDao));
      commandMap.put("/member/list", new MemberListCommand(keyboard,memberDao));
      commandMap.put("/member/detail", new MemberDetailCommand(keyboard,memberDao));
      commandMap.put("/member/update", new MemberUpdateCommand(keyboard,memberDao));
      commandMap.put("/member/delete", new MemberDeleteCommand(keyboard,memberDao));

      BoardDaoImpl boardDao = new BoardDaoImpl(con);
      commandMap.put("/board/add", new BoardAddCommand(keyboard,boardDao));
      commandMap.put("/board/list", new BoardListCommand(keyboard,boardDao));
      commandMap.put("/board/detail", new BoardDetailCommand(keyboard,boardDao));
      commandMap.put("/board/update", new BoardUpdateCommand(keyboard,boardDao));
      commandMap.put("/board/delete", new BoardDeleteCommand(keyboard,boardDao));

    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void destroy(HashMap<String, Object> map) {
    try {
      con.close();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }


}
