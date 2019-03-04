package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;

public class PhotoBoardDeleteCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  

  public PhotoBoardDeleteCommand(
      PhotoBoardDao photoBoardDao,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }


  @Override
  public void execute(Response response) throws Exception  {
    int no = response.requestInt("번호? : ");

    // 자식테이블(FK)부터 삭제
    photoFileDao.deleteByPhotoBoardNo(no);
    if (photoBoardDao.delete(no) == 0) {
      response.println("해당 번호 사진이 존재하지 않습니다");
      return;
    } 
    
    response.println("삭제완료!");
  } // execute()

}
