package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  
  public PhotoBoardUpdateCommand(
      PhotoBoardDao photoBoardDao ,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception  {
    PhotoBoard board = new PhotoBoard();

    int no = response.requestInt("번호 ? : ");
    PhotoBoard temp = photoBoardDao.findByNo(no); 
    board.setNo(no);
    board.setTitle(response.requestString(
        String.format("제목(%s) ? : ",temp.getTitle())));
    photoBoardDao.update(board);

    response.println("사진파일:");
    List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
    for(PhotoFile file : files) {
      response.println(String.format("> %s", file.getFilePath()));
    }

    response.println("사진은 일부만 변경 불가능");
    response.println("전체를 새로 등록해야 합니다");
    String input = response.requestString("사진을 변경하시겠습니까(y/N)?");
    
    if(input.equalsIgnoreCase("y")) {
      // 먼저 기존 파일을 삭제
      photoFileDao.deleteByPhotoBoardNo(board.getNo());
      
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
    }

    response.println("갱신 완료");
  } // execute()


}
