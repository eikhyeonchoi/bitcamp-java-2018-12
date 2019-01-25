package com.eomcs.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LinkedList<E> implements Cloneable {
  private static class Node<E> {
    Node<E> prev;
    Node<E> next;
    E value;
    public Node() {}
    public Node(E value) {
      this.value = value;
    }
  }

  Node<E> head;
  Node<E> tail;
  int size;

  public LinkedList() {
    head = new Node<>();
    tail = head;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public void add(E value) {
    tail.value = value;
    Node<E> node = new Node<>();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size) return null;
    Node<E> cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return (E)cursor.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) return null;
    Node<E> cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    E old = (E)cursor.value;
    cursor.value = value;
    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()];
    Node<E> cursor = head;
    int k = 0;
    while(cursor != tail) {
      arr[k] = cursor.value;
      cursor = cursor.next;
      k++;
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public <T> T[] toArray(T[] a) {
    T[] arr = null;
    if (a.length >= size()) {
      // 파라미터로 받은 배열의 크기가 리스트의 모든 항목을 담을 만큼 크다면
      // 배열을 새로 만들지 않고 그대로 사용한다
      arr = a;
    } else {
      // 만약 파라미터로 받은 배열의 크기가 리스트의 항목 크기보다 작다면
      // 새로 배열을 만든다
      arr =(T[]) Array.newInstance(
          a.getClass() // getClass()의 리턴 값은 T가 아니라 T[]이다
          .getComponentType() // getComponentType()의 리턴값은
          , this.size());
    }

    Node<E> cursor = head;
    int i = 0;
    while(cursor != tail) {
      arr[i++] = (T) cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) return null;
    Node<E> cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    
    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else head = cursor.next;
    cursor.next.prev = cursor.prev;
    
    E old = cursor.value;
    cursor.value = null;
    cursor.next = null;
    cursor.prev = null;
    size--;
    return old;
  }
  
  public int insert(int index, E value) {
    if (index < 0 || index >= size) return -1;
    Node<E> cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Node<E> node = new Node<>(value);
    node.next = cursor;
    node.prev = cursor.prev;
    cursor.prev = node;
    if (node.prev != null) {
      node.prev.next = node;
    } else head = node;
    size++;
    return 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public LinkedList<E> clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return (LinkedList<E>) super.clone();
  }


}
