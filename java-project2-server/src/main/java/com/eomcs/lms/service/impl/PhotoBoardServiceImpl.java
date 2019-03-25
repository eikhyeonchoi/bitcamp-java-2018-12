package com.eomcs.lms.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

//l @Component : 일반 
//l @Service : Business logic
//l @Controller : MVC
//l @Repository : Dao
@Service
public class PhotoBoardServiceImpl implements PhotoBoardService {

  PhotoBoardDao boardDao;
  PhotoFileDao fileDao;

  public PhotoBoardServiceImpl(PhotoBoardDao boardDao, PhotoFileDao fileDao) {
    this.boardDao = boardDao;
    this.fileDao = fileDao;
  }

  @Override
  public List<PhotoBoard> list(int lessonNo, String keyword) {
    if(lessonNo <= 0 && keyword == null) {
      return boardDao.findAll(null);

    } else {
      HashMap<String,Object> params = new HashMap<>();

      if(lessonNo > 0) {
        params.put("lessonNo", lessonNo);
      }

      if(keyword != null) {
        params.put("keyword", keyword);
      }

      return boardDao.findAll(params);
    }
  }


  @Override
//  @Transactional(propagation=Propagation.REQUIRED)
  public int add(PhotoBoard board) {
    int count = boardDao.insert(board);

    List<PhotoFile> files = board.getFiles();
    for(PhotoFile f : files) {
      f.setPhotoBoardNo(board.getNo());
    }

    fileDao.insert(board.getFiles());

    return count;
  }

  @Override
  public PhotoBoard get(int no) {
    // lms_photo 테이블의 데이터와 lms_photo_file 테이블의 데이터를 조인하여 결과를 가져온다. 
    // 그 결과를 PhotoBoard 객체에 저장한다.
    // 특히 lms_photo_file 데이터는 PhotoFile 객체에 저장되고, 
    // 그 목록은 PhotoBoard 객체에 포함되어 리턴된다.
    PhotoBoard board = boardDao.findByNoWithFile(no);

    if(board != null)
      boardDao.increaseCount(no);

    return board;
  }

  @Override
//  @Transactional(propagation=Propagation.REQUIRED)
  public int update(PhotoBoard board) {

    if(board.getTitle() != null) {
      boardDao.update(board);
    }

    List<PhotoFile> photoFiles = board.getFiles();
    if(photoFiles != null) {
      fileDao.deleteByPhotoBoardNo(board.getNo());
      fileDao.insert(photoFiles);
    }

    return 1;
  }

  @Override
//  @Transactional(propagation=Propagation.REQUIRED)
  public int delete(int no) {
    fileDao.deleteByPhotoBoardNo(no);
    int count = boardDao.delete(no);

    return count;
  }



}
