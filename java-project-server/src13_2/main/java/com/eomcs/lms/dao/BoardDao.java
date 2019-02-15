// Data Access Object = DAO = 데이터처리 클래스
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDao extends AbstractDao<Board>{

  public BoardDao(String filepath) {
    this.filepath = filepath;
  }


  public void insert(Board board) throws Exception{
    list.add(board);
    this.saveData();
  } // insert()


  public List<Board> findAll() {
    return list;
  } // findAll()


  public Board findByNo(int no) {
    for(Board b : this.list) {
      if(b.getNo() == no) {
        return b;
      }
    } // for
    return null;
  } // findByNo()


  public int update(Board board) throws Exception {
    int index = 0;
    for(Board b : this.list) {
      if(b.getNo() == board.getNo()) {
        this.list.set(index, board);
        this.saveData();
        return 1;
      }
      index ++;
    } // for
    return 0;
  } // update()


  public int delete(int no) throws Exception {
    int index = 0;
    for(Board b : this.list) {
      if(b.getNo() == no) {
        this.list.remove(index);
        this.saveData();
        return 1;
      }
      index++;
    } // for
    return 0;
  } // delete()


}
