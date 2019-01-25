// 제네릭 적용
package com.eomcs.util;

// Queue가 보관하는 데이터 타입을 E라고 가정하자
// ==> E라고 가정한 상태에서 코드를 작성한다
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
    Queue<E> temp = new Queue<>();
    for(int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp; 
    // return (Queue<E>) super.clone();
  }
  
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      @Override
      public boolean hasNext() {
        return empty();
      }

      @Override
      public E next() {
        return (E) poll();
      }
      
    };
  }
  
  
  
}
