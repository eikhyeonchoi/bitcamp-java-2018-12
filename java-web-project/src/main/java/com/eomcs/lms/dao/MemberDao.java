// 프록시 패턴 적용 - MemberDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  List<Member> findAll(HashMap<String, Object> params);
  List<Member> findByKeyword(String keyword);
  int insert(Member member);
  Member findByNo(int no);
  Member findByEmailPassword(Map<String,Object> paramMap);
  int update(Member member);
  int delete(int no);
  int countAll();
}







