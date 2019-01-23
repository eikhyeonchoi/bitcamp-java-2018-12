package com.eomcs.lms.util;

// LinkedList에서 다룰 데이터를 담는 그릇이다
public class Node {
  Node prev;
  Object value;
  Node next;
  
  public Node() {
  }
  
  public Node(Object value) {
    this.value = value;
  }
  
  public Node(Object value, Node prev, Node next) {
    this(value);
    this.prev = prev;
    this.next = next;
  }
  
}
