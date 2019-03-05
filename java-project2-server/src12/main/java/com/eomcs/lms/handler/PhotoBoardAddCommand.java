package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {
  // 트랜잭션 시작
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    PhotoBoard board = new PhotoBoard();
    board.setTitle(response.requestString("사진제목? : "));
    board.setLessonNo(response.requestInt("수업번호? : "));
    photoBoardDao.insert(board);

    response.println("최소 한 개의 사진파일을 등록해야 합니다");
    response.println("파일명 없이 그냥 엔터시 파일추가 마침");

    int count = 0;
    while(true) {
      String filePath = response.requestString("사진파일? : ");
      if(filePath.length() == 0) {
        if(count == 0) {
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
      count ++;
    } // while 

    // table lms_photo_file의 컬럼 photo_id는 table lms_photo의 기본키인 photo_id를 
    // 가리키는 외래키 이다 그래서 lms_photo_file의 데이터를 추가할 때 photo_id를 비우고 데이터를
    // 추가하려고 시도하면 오류가 발생한다 lms_photo의 기본키이자 auto_increment인 photo_id를
    // 알아내려면 추가적인 자바 문법을 필요로 한다

    response.println("저장하였습니다");
  } // execute()


}
