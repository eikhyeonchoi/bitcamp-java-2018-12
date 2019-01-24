package com.eomcs.util;

import java.util.Arrays;

public class LinkedList<E> {
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

  public E[] toArray(E[] a) {
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
  public<T> T[] toArray(T[] a) {
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
    size--;
    
    E old = cursor.value;
    cursor.value = null;
    cursor.next = null;
    cursor.prev = null;
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



}
