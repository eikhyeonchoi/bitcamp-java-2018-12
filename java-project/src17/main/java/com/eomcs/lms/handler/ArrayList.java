package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class ArrayList {
  Object[] objects;
  int oIdx = 0;
  
  public ArrayList() {
    objects = new Object[10];
  }
  
  public ArrayList(int length) {
    if (length < 10) {
      objects = new Object[10];
    } else {
      objects = new Object[length];
    }
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(objects,oIdx);
  }
  
  public void add(Object b) {
    if (oIdx >= objects.length) {
      objects = Arrays.copyOf(objects, objects.length + (objects.length >> 1));
      System.out.println("배열을 증가했습니다 배열 length : " + objects.length);
    }
    objects[oIdx] = b;
    oIdx++;
  }

}
