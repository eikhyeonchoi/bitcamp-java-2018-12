package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao; // 서버의 PhotoBoardDaoImpl 객체를 대행하는 프록시이다
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
    // insert를 수행하면 board레퍼런스에 연결된 객체의 no가 설정됨
    // DB lms_photo_file (사진게시물의 첨부파일 DB)에도 insert를 수행해야하기 때문에
    // lms_photo와 lms_photo_file은 parent/child 관계이기 때문에 photo_id가 외래키 이다
    // l그래서 lms_photo의 auto_increment설정으로 인해 값을 지정하지 않는 photo_id의 값을 알아내기
    // l위해서는 PhotoBoardDaoImpl.insert()메서드를 수행할때에 추가 문법을 작성해 photo_id를 
    // l알아낼 수 있다. 
    // l즉 board객체에 no (lms_photo의 photo_id 컬럼)을 알아야지만 첨부파일도 같이 insert 할 수
    // l있기 때문에 추가문법을 필요로 한다

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
