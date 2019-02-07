package com.eomcs.lms.listener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import com.eomcs.lms.domain.Member;

public class MemberDataLoaderListener implements ApplicationContextListener {

  @Override
  public void init(HashMap<String, Object> context) {
    try (ObjectInputStream in =
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("member3.data")))){

      context.put("memberList", in.readObject());

    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("memberList", new LinkedList<Member>());
    }
  }

  @Override
  public void destroy(HashMap<String, Object> context) {
    try (ObjectOutputStream out  = 
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("member3.data")))) {
      
      out.writeObject(context.get("memberList"));

    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }



}
