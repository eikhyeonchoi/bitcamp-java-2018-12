package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception  {
    PhotoBoard board = new PhotoBoard();

    int no = response.requestInt("번호 ? : ");
    
    PhotoBoard temp = photoBoardDao.findByNo(no); 
    
    board.setNo(no);
    board.setTitle(response.requestString(String.format("제목(%s) ? : ",temp.getTitle())));

    if (photoBoardDao.update(board) == 0) {
      response.println("해당 게시물은 없습니다");
      return;
    }

    response.println("갱신 완료");

  } // execute()



}
