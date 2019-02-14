// Data Access Object = DAO = 데이터처리 클래스
package com.eomcs.lms.dao;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDao extends AbstractDao<Member>{

  public MemberDao(String filepath) {
    this.filepath = filepath;
  }

  
  public void insert(Member member){
    list.add(member);
  } // insert()

  
  public List<Member> findAll() {
    return list;
  } // findAll()

  
  public Member findByNo(int no) {
    for(Member b : this.list) {
      if(b.getNo() == no) {
        return b;
      }
    } // for
    return null;
  } // findByNo()

  
  public int update(Member member) {
    int index = 0;
    for(Member b : this.list) {
      if(b.getNo() == member.getNo()) {
        this.list.set(index, member);
        return 1;
      }
      index ++;
    } // for
    return 0;
  } // update()


  public int delete(int no) {
    int index = 0;
    for(Member b : this.list) {
      if(b.getNo() == no) {
        this.list.remove(index);
        return 1;
      }
      index++;
    } // for
    return 0;
  } // delete()


}
