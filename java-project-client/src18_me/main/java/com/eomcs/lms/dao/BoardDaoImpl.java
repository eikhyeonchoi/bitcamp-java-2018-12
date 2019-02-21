package com.eomcs.lms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao{

  Connection con;

  public BoardDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Board> findAll() {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from lms_board"); ){

      try (ResultSet rs = stmt.executeQuery(); ){

        ArrayList<Board> list = new ArrayList<Board>();
        while(rs.next()) {
          Board temp = new Board();
          temp.setNo(rs.getInt("board_id"));
          temp.setContents(rs.getString("conts"));
          temp.setCreatedDate(rs.getDate("cdt"));
          temp.setViewCount(rs.getInt("vw_cnt"));
          list.add(temp);
        }
        return list;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()

  public void insert(Board board) {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_board(conts) values(?)"); ){
      stmt.setString(1, board.getContents());

      stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // insert()


  public Board findByNo(int no) {
    try {
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_board set vw_cnt = vw_cnt + 1 where board_id = ?"); ){
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }
      try (PreparedStatement stmt = con.prepareStatement(
          "select * from lms_board where board_id = ?"); ){

        stmt.setInt(1, no);

        try (ResultSet rs = stmt.executeQuery(); ){
          if(rs.next()) {
            Board temp = new Board();
            temp.setNo(rs.getInt("board_id"));
            temp.setContents(rs.getString("conts"));
            temp.setCreatedDate(rs.getDate("cdt"));
            temp.setViewCount(rs.getInt("vw_cnt"));
            return temp;
          } else {
            return null;
          }
        }
      } 
      
    }catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // findByNo()


  public int update(Board board) {
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_board set conts = ? where board_id = ?"); ){
      
      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getNo());

      return stmt.executeUpdate();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()


  public int delete(int no) {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_board where board_id = ?"); ){
      stmt.setInt(1, no);
      
      
      return stmt.executeUpdate();
      
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
