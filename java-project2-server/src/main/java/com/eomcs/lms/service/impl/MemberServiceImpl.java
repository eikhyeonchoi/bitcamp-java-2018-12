package com.eomcs.lms.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

//l @Component : 일반 
//l @Service : Business logic
//l @Controller : MVC
//l @Repository : Dao
@Service
public class MemberServiceImpl implements MemberService {

  MemberDao memberDao;

  public MemberServiceImpl(
      MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public List<Member> list() {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return memberDao.findAll();
  }

  @Override
  public int add(Member member) {
    //l Command : UI
    //l Service : Business logic
    //l 별로 하는 일이 없더라도 일관성을 위해 분리해서 작업
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {
    Member member = memberDao.findByNo(no);
    if(member !=null)
      return member;
    
    else return null;
  }

  @Override
  public int update(Member member) {
    if (member.getName() != null
        || member.getEmail() != null
        || member.getPassword() != null
        || member.getPhoto() != null
        || member.getTel() != null) {
      return memberDao.update(member);
    } else {
      return 0;
    }
  }
  
  @Override
  public int delete(int no) {
    return memberDao.delete(no);
  }

  @Override
  public List<Member> findByKeyword(String keyWord) {
    return memberDao.findByKeyword(keyWord);
  }


}
