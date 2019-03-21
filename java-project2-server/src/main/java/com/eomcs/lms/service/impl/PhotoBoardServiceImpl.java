package com.eomcs.lms.service.impl;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
  PlatformTransactionManager txManager;

  public PhotoBoardServiceImpl(
      PhotoBoardDao boardDao, 
      PhotoFileDao fileDao,
      PlatformTransactionManager txManager) {

    this.boardDao = boardDao;
    this.fileDao = fileDao;
    this.txManager = txManager;
  }
  
  @Override
  public List<PhotoBoard> list(int lessonNo, String searchWord) {
    if(lessonNo <= 0 && searchWord == null) {
      return boardDao.findAll(null);
      
    } else {
      HashMap<String,Object> params = new HashMap<>();

      if(lessonNo > 0) {
        params.put("lessonNo", lessonNo);
      }

      if(searchWord != null) {
        params.put("keyword", searchWord);
      }

      return boardDao.findAll(params);
    }
  }

  
  @Override
  public int add(PhotoBoard board) {

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      int count = boardDao.insert(board);
      
      List<PhotoFile> files = board.getFiles();
      for(PhotoFile f : files) {
        f.setPhotoBoardNo(board.getNo());
      }
      
      fileDao.insert(board.getFiles());
      
      txManager.commit(status);
      return count;
      
    } catch(RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
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
  public int update(PhotoBoard board) {

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      //l PhotoBoard 객체에 title이 들어 있다는 것은 사용자가 변경했다는 의미임
      if(board.getTitle() != null) {
        boardDao.update(board);
      }

      List<PhotoFile> photoFiles = board.getFiles();
      if(photoFiles != null) {
        fileDao.deleteByPhotoBoardNo(board.getNo());
        fileDao.insert(photoFiles);
      }

      txManager.commit(status);
      return 1;

    } catch(RuntimeException e) {
      txManager.rollback(status);
      throw e;

    }
  }

  @Override
  public int delete(int no) {

    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);   

    try {

      fileDao.deleteByPhotoBoardNo(no);
      int count = boardDao.delete(no);

      txManager.commit(status);
      return count;

    } catch(RuntimeException e) {
      txManager.rollback(status);
      throw e;
    }
  }


  
}
