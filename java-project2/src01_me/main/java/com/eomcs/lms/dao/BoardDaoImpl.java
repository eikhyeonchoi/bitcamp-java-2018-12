package com.eomcs.lms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao{

  public List<Board> findAll() {
    ArrayList<Board> list = new ArrayList<Board>();
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_board")) {

        try (ResultSet rs = stmt.executeQuery()) {

          while(rs.next()) {
            Board temp = new Board();
            temp.setNo(rs.getInt("board_id"));
            temp.setContents(rs.getString("contents"));
            temp.setCreatedDate(rs.getDate("created_date"));
            temp.setViewCount(rs.getInt("view_count"));
            list.add(temp);
          } // while

          return list;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // list()

  public void insert(Board board) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into temp_board(board_id, contents, created_date, view_count) "
              + "values(?, ?, ?, ?)")) {

        stmt.setInt(1, board.getNo());
        stmt.setString(2, board.getContents());
        stmt.setDate(3, board.getCreatedDate());
        stmt.setInt(4, board.getViewCount());

        int isInsert = stmt.executeUpdate();
        if(isInsert == 0) {
          System.out.println("insert 실패");
        } else {
          System.out.println("insert 성공");
        }

      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // insert()


  public Board findByNo(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from temp_board where board_id = ?")) {
        stmt.setInt(1, no);
        
        try (ResultSet rs = stmt.executeQuery()) {
          Board temp = new Board();
          if(rs.next()) {
            temp.setNo(rs.getInt("board_id"));
            temp.setContents(rs.getString("contents"));
            temp.setCreatedDate(rs.getDate("created_date"));
            temp.setViewCount(rs.getInt("view_count"));
          } else {
            System.out.println("해당번호의 게시물이 존재하지 않습니다");
          }
          return temp;
        }
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // get()


  public int update(Board board) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "update temp_board set contents = ? where board_id = ?")) {
        stmt.setString(1, board.getContents());
        stmt.setInt(2, board.getNo());

        int isUpdate = stmt.executeUpdate();
        
        if(isUpdate == 0) {
          System.out.println("update 실패");
        } else {
          System.out.println("update 성공");
        }
        return 1;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // update()


  public int delete(int no) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111") ){

      try (PreparedStatement stmt = con.prepareStatement(
          "delete from temp_board where board_id = ?")) {

        stmt.setInt(1, no);

        int isDelete = stmt.executeUpdate();
        if(isDelete == 0) {
          System.out.println("delete 실패");
        } else {
          System.out.println("delete 성공");
        }
        return 1;
      }
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // delete()

}
