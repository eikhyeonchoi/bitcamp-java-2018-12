package com.eomcs.lms.util;

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

  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList처럼 한 번에 큰 메모리를 준비할 필요가 없다
  // ==> 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다

  public void add(Object value) {
    tail.value = value;

    // 새 노드를 준비
    Node node = new Node();
    // 마지막 노드의 다음으로 새 노드를 가리키게 한다
    tail.next = node;

    // 새 노드의 이전으로 마지막 노드를 가리키게 한다
    node.prev = tail;

    // tail이 새로 추가된 노드를 가리키게 한다
    tail = node;

    // 항목 개수를 증가 시킨다
    size ++;
  }

  // ArrayList와 달리 해당 인덱스를 찾아가려면 Link를 따라가야하기 때문에
  // 조회속도가 느리다
  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    // 해당 인덱스로 이동
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    // cursor가 가리키는 노드의 주소를 리턴?
    // ==> 노드의 값을 리턴해야함500
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
    // 교체할 값이 들어 있는 노드로 이동
    for(int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }

    // 변경 전에 이전 값을 보관
    Object old = cursor.value;
    cursor.value = value;

    // 쓰든 안쓰든 이전값 return;
    // 다만 변경 전 값 활용을 대비해 리턴
    return old;
  }

  // 값을 삽입하는 경우에는 arrayList보다 효율적이다
  // 삽입 위치에 있는 노드를 찾은 후 새 노드를 앞뒤 노드에 연결하면된다
  public int insert(int index, Object value) {
    if (index < 0 || index >= size) return -1;
    Node node = new Node(value);
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;

    }
    // 새노드가 찾은 노드를 가리키게한다
    node.next = cursor;

    // 찾은 노드의 이전 노드 주소를 새 노드의 이전 노드 주소로 설정한다
    node.prev = cursor.prev;

    // 찾은 노드의 이전 노드로 새 노드를 가리키게 한다
    cursor.prev = node;

    if(node.prev != null) {
      // 이전 노드의 다음 노드로 새 노드를 가리키게 한다
      node.prev.next = node;
    } else {
      // 맨 앞에 노드를 추가할 때는 head를 변경해야 한다
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







}
