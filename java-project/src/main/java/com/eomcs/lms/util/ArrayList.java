package com.eomcs.lms.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class ArrayList<E> {
  Object[] list;
  int size = 0;
  
  public int getSize() {
    return size;
  }

  @SuppressWarnings("unchecked")
  public ArrayList() {
    list = new Object[10];
  }
  
  public ArrayList(int length) {
    if (length < 10) {
      list = new Object[10];
    } else {
      list = new Object[length];
    }
  }
  
  @SuppressWarnings("unchecked")    
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
    */
  }
  
  public void add(E ee) {
    if (size >= list.length) {
      list = Arrays.copyOf(list, list.length + (list.length >> 1));
      System.out.println("배열을 증가했습니다 배열 length : " + list.length);
    }
    list[size] = ee;
    size++;
  }
  
  public E get(int index) {
    // index : 값을 꺼낼 배열의 항목 위치
   return (E) list[index]; 
  }
  public E set(int index, E value) {
    // index : 값을 변경할 배열의 항목 위치 
    // value : 해당 위치에 있는 값을 대체할 값
    // return 값 : 대체되기 전 기존 값
    E obj = (E) list[index];
    list[index] = value;
    return obj;
  }
  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // return : 삭제된 이전 값
    // System.arraycopy 참고
    E obj = (E) list[index];
    for(int k = index; k < size; k++) {
      list[k] = list[k+1];
    }
    size --;
    return obj;
  }
  
  
  
  

}
