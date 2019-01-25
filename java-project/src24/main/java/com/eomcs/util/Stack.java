package com.eomcs.util;

public class Stack<E> implements Cloneable{
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
    // 맨 마지막 값을 꺼내 returnvalue
    // 꺼낸 값을 배열에서 제거되어야 한다
    if (size == 0) return null;
    Object old = list[size - 1];
    size --;
    list[size] = null;
    return (E) old;
    // return list[--size];
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
  public Stack<E> clone() throws CloneNotSupportedException {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.push((E) list[i]);
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int index = 1;
      @Override
      public boolean hasNext() {
        return empty();
        // empty() => 비어있으면 true
        // empty() => 안 비어있으면 false;
      }
      
      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        int lastIndex = size - 1;
        return (E) list[lastIndex - (index++)];
      }
      
    };
  }

  
}
