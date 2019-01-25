package com.eomcs.util;

public class Stack<E> implements Cloneable {
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size = 0;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(E value) {
    // 맨 마지막에 추가
    // 배열의 크기가 작다면 확장해야한다
    if (size >= list.length) {

      int newSize = list.length + (list.length >> 1);
      Object[] temp = new Object[newSize];
      for (int k = 0; k < size; k++) {
        temp[k] = list[k];
      }
      list = temp;
    }
    list[size] = value;
    size ++;
  }
  
  @SuppressWarnings("unchecked")
  public E pop() {
    if( size == 0 ) return null;
    size --;
    E value =(E) list[size];
    list[size] = null;
    return value;
    /*
    if (size == 0) return null;
    Object old = list[size - 1];
    size --;
    return (E) old;
     */
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
  
  public void print() {
    for(int k =  0; k < size; k++) {
      System.out.printf("%d\n", list[k]);
    }
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public  Stack<E> clone() throws CloneNotSupportedException {
    // Object에서 상속 받은 clone()은
    // 인스턴스 필드의 값만 복제한다
    // 인스턴스 필드가 가리키는 다른 인스턴스는 복제하지 않는다
    // 예를 들어 Stack의 list 배열 레퍼런스가 배열 인스턴스는 복제하지 않는다
    // 배열 인스턴스까지 복제(deep clone)하려면 개발자가 직접 코드를 작성해야한다
    
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < this.size(); i++) {
      temp.push((E)list[i]);
    }
    return temp;
  }
  
  
  
}
