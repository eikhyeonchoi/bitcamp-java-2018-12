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
    // Object에서 상속 받은 clone()은
    // 인스턴스 필드의 값만 복제한다
    // 인스턴스 필드가 가리키는 다른 인스턴스는 복제하지 않는다
    // 예를 들어 Stack의 list 배열 레퍼런스가 배열 인스턴스는 복제하지 않는다
    // 배열 인스턴스까지 복제(deep clone)하려면 개발자가 직접 코드를 작성해야한다
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
}
