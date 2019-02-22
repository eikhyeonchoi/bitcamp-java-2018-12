// 프록시 패턴적용
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao{
  void insert(Member member);
  
  List<Member> findAll();
  
  Member findByNo(int no);
  
  int update(Member member);
  
  int delete(int no);
  
} // end of class
