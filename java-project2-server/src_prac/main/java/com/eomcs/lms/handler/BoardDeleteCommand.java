package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;

public class BoardDeleteCommand extends AbstractCommand {

  BoardDao boardDao;

  public BoardDeleteCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void execute(Response response) throws Exception  {
    int no = response.requestInt("번호? : ");

    if (boardDao.delete(no) == 0) {
      response.println("해당 번호 게시물이 존재하지 않습니다");
    } else {
      response.println("데이터를 삭제했습니다");
    }
  } // execute()

}
