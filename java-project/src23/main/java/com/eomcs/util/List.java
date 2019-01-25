// 데이터 관리 객체(ArrayList, LinkedList 등)를 사용하는 규칙 정의
package com.eomcs.util;
public interface List<E> {
  Object[] toArray();
  
  <T> T[] toArray(T[] sampleArr);
  
  void add(E value);
  
  E get(int index);
  
  E set(int index, E value);
  
  E remove(int index);
  
  int size();
  
}
