package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.eomcs.lms.context.Component;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

@Component
public class PhotoBoardCommand {

  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;
  TransactionManager txManager;
  
  public PhotoBoardCommand(
      PhotoBoardDao photoBoardDao, 
      PhotoFileDao photoFileDao, 
      TransactionManager txManager) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
    this.txManager = txManager;
  }

  @RequestMapping("/photoboard/list")
  public void list(Response response) {
    List<PhotoBoard> boards = photoBoardDao.findAll(null);
    
    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
            board.getNo(), 
            board.getTitle(), 
            board.getCreatedDate(), 
            board.getViewCount(),
            board.getLessonNo()));
    }
  }
  
  
  
  
  
  @RequestMapping("/photoboard/add")
  public void add(Response response) throws Exception {
    txManager.beginTransaction();

    try {
      PhotoBoard board = new PhotoBoard();
      board.setTitle(response.requestString("사진 제목?"));
      board.setLessonNo(response.requestInt("수업?"));
      photoBoardDao.insert(board);

      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> files = new ArrayList<>();
      while (true) {
        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if (files.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력한 후 자동 생성된 PK 값을 꺼낸다.

        files.add(file);
      }
      photoFileDao.insert(files);
      
      response.println("저장하였습니다.");
      txManager.commit();
      
    } catch(Exception e) {
      e.printStackTrace();
      response.println("저장 중 오류가 발생 하였습니다.");
      txManager.rollback();
      
    }
  }

  
  
  @RequestMapping("/photoboard/detail")
  public void detail(Response response) throws Exception {
    int no = response.requestInt("번호?");
    
    // lms_photo 테이블의 데이터와 lms_photo_file 테이블의 데이터를 조인하여 결과를 가져온다. 
    // 그 결과를 PhotoBoard 객체에 저장한다.
    // 특히 lms_photo_file 데이터는 PhotoFile 객체에 저장되고, 
    // 그 목록은 PhotoBoard 객체에 포함되어 리턴된다.
    PhotoBoard board = photoBoardDao.findByNoWithFile(no);
    if (board == null) {
      response.println("해당 사진을 찾을 수 없습니다.");
      return;
    }
    
    photoBoardDao.increaseCount(no);
    
    response.println(String.format("제목: %s", board.getTitle()));
    response.println(String.format("작성일: %s", board.getCreatedDate()));
    response.println(String.format("조회수: %d", board.getViewCount()));
    response.println(String.format("수업: %s(%s ~ %s)", 
        board.getLesson().getTitle(),
        board.getLesson().getStartDate(),
        board.getLesson().getEndDate()));
    
    response.println("사진파일:");
    List<PhotoFile> files = board.getFiles();
    for (PhotoFile file : files) {
      response.println(String.format("> %s", file.getFilePath()));
    }
  }
  
  
  
  
  @RequestMapping("/photoboard/delete")
  public void delete(Response response) throws Exception {
    txManager.beginTransaction();
    try {

      int no = response.requestInt("번호?");

      // 데이터를 지울 때는 자식 테이블의 데이터부터 지워야 한다.
      photoFileDao.deleteByPhotoBoardNo(no);

      if (photoBoardDao.delete(no) == 0) {
        response.println("해당 번호의 사진이 없습니다.");
        return;
      }

      response.println("삭제했습니다.");
      txManager.commit();
      
    } catch (Exception e) {
      response.println("삭제중 오류 발생." + e);
      txManager.rollback();
    }
  }
  
  
  
  
  @RequestMapping("/photoboard/update")
  public void update(Response response) throws Exception {
    txManager.beginTransaction();
    try {
    PhotoBoard board = new PhotoBoard();
    board.setNo(response.requestInt("번호?"));
    
    PhotoBoard origin = photoBoardDao.findByNo(board.getNo());
    if (origin == null) {
      response.println("해당 번호의 사진이 없습니다.");
      return;
    }
    
    String input = response.requestString(
        String.format("제목(%s)?", origin.getTitle()));
    
    
    if (input.length() > 0) {
      board.setTitle(input);
      photoBoardDao.update(board); // 사진 게시물 제목 변경
    }
    
    // 변경하려면 사진 게시물의 첨부 파일을 출력한다.
    response.println("사진 파일:");
    List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(board.getNo());
    for (PhotoFile file : files) {
      response.println("> " + file.getFilePath());
    } // for
    response.println("");
    
    response.println("사진은 일부만 변경할 수 없습니다.");
    response.println("전체를 새로 등록해야 합니다.");
    input = response.requestString("사진을 변경하시겠습니까?(y/N)");
    if (input.equalsIgnoreCase("y")) {
      // 먼저 기존 첨부 파일을 삭제한다.
      photoFileDao.deleteByPhotoBoardNo(board.getNo());
      
      // 그리고 새 첨부 파일을 추가한다.
      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");
      
      ArrayList<PhotoFile> photoFiles = new ArrayList<PhotoFile>();
      while (true) {
        String filePath = response.requestString("사진 파일?");
        if (filePath.length() == 0) {
          if (photoFiles.size() == 0) {
            response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          } else {
            break;
          }
        }
        PhotoFile file = new PhotoFile();
        file.setFilePath(filePath);
        file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력한 후 자동 생성된 PK 값을 꺼낸다.
        
        photoFiles.add(file);
      } // while
      
      photoFileDao.insert(photoFiles);
      
    } // if(input)
    response.println("변경했습니다.");
    txManager.commit();
    
    } catch(Exception e) {
      response.println("변경 중 오류발생." + e);
      txManager.rollback();
    } // try
    
  } 
  
  
  
  @RequestMapping("/photoboard/search")
  public void search(Response response) {
    HashMap<String, Object> params = new HashMap<>();
    try {
      int lessonNo = response.requestInt("사진 파일번호 ? : ");
      params.put("lessonNo", lessonNo);
    } catch (Exception e) {
    }
    
    try {
      String keyword = response.requestString("검색어 ? : ");
      if(keyword.length() > 0) {
        params.put("keyword", keyword);
//        params.put("keyword", "%" + keyword + "%");
      }
    } catch (Exception e) {
    }

    List<PhotoBoard> boards = photoBoardDao.findAll(params);
    
    response.println("[검색결과]");
    for (PhotoBoard board : boards) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              board.getNo(), 
              board.getTitle(), 
              board.getCreatedDate(), 
              board.getViewCount(),
              board.getLessonNo()));
    }
  }
  
  
  
}
