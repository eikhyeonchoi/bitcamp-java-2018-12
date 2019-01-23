package algorithm.data_structure.queue;
import algorithm.data_structure.linkedlist.LinkedList;

// 기존 기능을 활용하는 가장 쉬운 방법이 상속
public class Queue extends LinkedList{
  
  
  public void offer(Object value) {
    // 상속받은 메서드를 활용하여 값을 추가하라
    this.add(value);
  }
  
  public Object poll() {
    // 상속받은 메서드를 사용하여 값을 꺼내라
    return this.remove(0);
  }
  
  public boolean empty() {
    return this.size() == 0;
  }

}
