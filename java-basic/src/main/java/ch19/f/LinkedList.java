// 특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스안에 정의하라
package ch19.f;
import java.awt.Cursor;

// Array 클래스는 LinkedList 클래스에서만 사용하는 클래스이다
// 그래서 패키지 멤버 클래스에서 중첩 클래스로 옮겼다
// 즉 LinkedList 클래스 안에 Array클래스를 정의함
public class LinkedList {
  
  public static final int FORWARD = 1;
  public static final int REVERSE = 2;
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

  public Object[] toArray(int direction) {
    
    // 이제 Array클래스는 남이아니다 
    // 그래서 LinkedList의 멤버를 사용할 수 있다
    // Array클래스가 non-static nested class기 때문에 
    // LinkedList의 non-static 멤버를 사용할 수 있다
    Array helper = new Array(); // <== LinkedList 객체 주소를 넘길 필요 x
    if(direction == FORWARD) {
      // 그래야만 Array객체는 생성자에서 넘겨 받은 LinkedList의 데이터를 꺼내 
      // 배열로 만듦
      return helper.copy();
    } else return helper.reverseCopy();
    
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
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
    }
    cursor.next.prev = cursor.prev;
    Object old = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    size--;
    return old;
  }

  
  // 중첩 클래스는 크게 static, non-static로 나눌 수 있는데,
  // 바깥 클래스의 특정 인스턴스를 사용하지 않는다면 static nested class로 선언
  // 그러나 바깥 클래스의 특정 인스턴스를 사용한다면 그 인스턴스에 종속되기 때문에
  // non-static nested class로 선언하라
  // 다음 Array 클래스는 LinkedList의 특정 인스턴스 값을 사용해야 하기 때문에
  // non-static class로 선언한다
  // ==> 내부에서만 사용할 클래스라면 private으로
  private class Array {
    // 이제 Array클래스는 LinkedList의 인스턴스 멤버가 되었음
    // ==> 즉 인스턴스 필드나, 메서드처럼 특정 인스턴스에 대해 주소를 받는다는 것이다
    // ==> 따라서 바깥 클래스의 인스턴스를 마음대로 사용할 수 있다 
    // ==> 그냥 인스턴스 메서드라고 생각하면 된다
    
    // LinkedList list; // << 이 코드 필요 없어짐
    
    /* 같은 인스턴스 멤버이기 때문에 생성자에서 인스턴스 주소를 받을 필요가 없다
    public Array(LinkedList list) {
      this.list = list;
    }
    */
    
    // 입력된 순서대로 배열을 만든다
    public Object[] copy() {
      // 바깥 클래스의 인스턴스 주소는 다음과 같이 사용해야한다
      //            바깥클래스명.this.인스턴스멤버
      // 만약 바깥 클래스의 인스턴스 멤버명이 내부 클래스의 멤버 이름과 충돌하지 않는다면
      //            바깥클래스명.this를 생략해도 된다
      
      
      Object[] arr = new Object[LinkedList.this.size()];
      for (int i = 0; i < LinkedList.this.size(); i++) {
        arr[i] = LinkedList.this.get(i);
      }
      return arr;
    }
    public Object[] reverseCopy() {
      // 다음과 같이 내부 멤버에 같은 이름이 없다면 바깥 클래스의 인스턴스 멤버를 사용할 때
      // 바깥 클래스명.this == LinkedList.this 를 생략가능
      // LinkedList의 메서드라고 생각해도 됨
      Object[] arr = new Object[size()];
      for (int i = size()-1, j = 0; i >= 0; i--, j++) {
        arr[j] = get(i);
      }
      return arr;
    }
  }




}
