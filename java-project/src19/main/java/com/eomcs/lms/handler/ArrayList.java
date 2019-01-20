package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.List;

public class ArrayList<E> {
  Object[] list;
  private int  size = 0;
  
  public int getSize() {
    return this.size;
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
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    // index : 값을 꺼낼 배열의 항목 위치
   return (E) list[index - 1]; 
  }
  
  public E set(int index, E value) {
    // index : 값을 변경할 배열의 항목 위치 
    // value : 해당 위치에 있는 값을 대체할 값
    // return 값 : 대체되기 전 기존 값
    Object tmp = list[index - 1];
    list[index - 1] = value;
    return (E) tmp;
    
  }
  
  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // return : 삭제된 이전 값
    // System.arraycopy 참고
    /*
    Object[] objStart = new Object[index-1];
    Object[] objEnd = new Object[(size-1)-(index+1)];
    System.arraycopy(list, 0, objStart, 0, index-1);
    System.arraycopy(list, index+1, objEnd, 0, size-1);
    */
    Object deleteContent = list[index-1];
    for (int i = index-1; i < list.length-1; i++) {
      list[i] = list[i+1]; 
    }
    size--;
    return (E) deleteContent;
    
  }
  
  public E remove2(int i) {
    int index = i-1;
    Object returnObj = list[index];
    int newSize = size - 1;
    System.arraycopy(list, index+1, list, index, newSize - index);
    size--;
    return (E) returnObj;
  }

}
