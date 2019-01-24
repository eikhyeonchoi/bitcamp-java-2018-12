// static nested class 문법 적용 - Node 클래스를 static중첩 클래스로 정의한다
package algorithm.data_structure.linkedlist2;
import java.awt.Cursor;

public class LinkedList {
  protected Node head;
  protected Node tail;
  protected int size = 0;

  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }

  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size ++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public int size() {
    return size;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()];
    Node cursor = head;
    int i = 0;
    while(cursor != tail) {
      arr[i++] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for(int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }

  public int insert(int index, Object value) {
    if (index < 0 || index >= size) return -1;
    Node node = new Node(value);
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    node.next = cursor;
    node.prev = cursor.prev;
    cursor.prev = node;
    if(node.prev != null) {
      node.prev.next = node;
    } else {
      head = node;
    }
    size++;
    return 0;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for(int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }

    if (cursor.prev != null) {
       // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다
      cursor.prev.next = cursor.next;
    } else {
      // 맨 처음 노드를 삭제할 때
      head = cursor.next;
    }

    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다
    cursor.next.prev = cursor.prev;

    // GC가 가비지를 효과적으로 계산할 수 있도록
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다
    Object old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    size--;
    // 호출한 쪽에서 사용하라고 삭제된 값을 리턴해준다
    return old;
  }

  // LinkedList에서만 쓰이는 Node클래스를 중첩 클래스로 만든다
  // ==> Node클래스는 LinkedList의 특정 인스턴스를 사용하지 않는다
  // ==> 그래서 static 중첩 클래스로 정의하는 것
  // ==> 그리고 외부 공개할 일이 없기 때문에 private
  private static class Node {
    // LinkedList 내부에서만 사용하기 때문에 Node의 멤버를 public으로 공개할 필요가 없음
    Node prev;
    Object value;
    Node next;
    Node() {}
    Node(Object value) {
      this.value = value;
    }
  }


}
