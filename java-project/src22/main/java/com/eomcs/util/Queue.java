package com.eomcs.util;

// 기존 기능을 활용하는 가장 쉬운 방법이 상속
public class Queue<E> extends LinkedList<E> implements Cloneable{
  
  
  public void offer(E value) {
    // 상속받은 메서드를 활용하여 값을 추가하라
    this.add(value);
  }
  
  public E poll() {
    // 상속받은 메서드를 사용하여 값을 꺼내라
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size() == 0;
  }
  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return (Queue<E>) super.clone();
  }

}
