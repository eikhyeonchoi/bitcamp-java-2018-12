package com.eomcs.lms.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

//l @Component : 일반 
//l @Service : Business logic
//l @Controller : MVC
//l @Repository : Dao
@Service
public class BoardServiceImpl implements BoardService {

  BoardDao boardDao;
  
  public BoardServiceImpl(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public List<Board> list() {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return boardDao.findAll();
  }

  @Override
  public int add(Board board) {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return boardDao.insert(board);
  }

  @Override
  public Board get(int no) {
    Board board = boardDao.findByNo(no);
    if(board != null)
      boardDao.increaseCount(no);
    return board;
  }

  @Override
  public int update(Board board) {
    return boardDao.update(board);
  }

  @Override
  public int delete(int no) {
    return boardDao.delete(no);
  }
  

}
