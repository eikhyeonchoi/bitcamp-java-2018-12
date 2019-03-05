package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.PhotoFile;

// 인터페이스를 두는 이유는 MySql을 쓰는 경우와 Oracle을 쓰는경우가 
// 있기 때문에 (두 DBMS간의 문법이 다르기 때문에) 인터페이스를 만들고
// 구현체를 만들어 관리한다 ==> 현업에서는 선택이 아니라 무조건 분리
// 고객사마다 DBMS가 다르기 때문임
public interface PhotoFileDao {
  void insert(PhotoFile photoFile);
  List<PhotoFile> findByPhotoBoardNo(int photoBoardNo);
  int deleteByPhotoBoardNo(int photoBoardNo);
}
