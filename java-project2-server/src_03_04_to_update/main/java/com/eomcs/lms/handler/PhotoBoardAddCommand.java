package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddCommand(
      PhotoBoardDao photoBoardDao, 
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setTitle(response.requestString("제목? : "));
    board.setLessonNo(response.requestInt("수업번호? : "));
    photoBoardDao.insert(board);

    response.println("최소 한 개의 사진파일을 등록해야 합니다");
    response.println("파일명 없이 그냥 엔터시 파일추가 마침");
    int cnt = 0;
    while(true) {
      String filePath = response.requestString("사진파일? : ");
      if(filePath.length() == 0) {
        if(cnt == 0) {
          response.println("최소 한 개의 사진파일을 등록해야 합니다");
          continue;
        } else {
          break;
        }
      }
      PhotoFile file = new PhotoFile();
      file.setFilePath(filePath);
      file.setPhotoBoardNo(board.getNo());
      photoFileDao.insert(file);
      cnt++;
    } // while

    response.println("저장하였습니다");

  } // execute()


}
