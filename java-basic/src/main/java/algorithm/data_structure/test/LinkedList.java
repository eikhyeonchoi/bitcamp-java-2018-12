package algorithm.data_structure.test;

public class LinkedList {
  private static class Node {
    Node prev;
    Node next;
    Object value;
    public Node() {}
    public Node(Object value) {
      this.value = value;
    }
  }

  Node head;
  Node tail;
  int size;

  public LinkedList() {
    head = new Node();
    tail = head;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public void add(Object value) {
    tail.value = value;
    Node node = new Node();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()];
    Node cursor = head;
    int k = 0;
    while(cursor != tail) {
      arr[k] = cursor.value;
      cursor = cursor.next;
      k++;
    }

    return arr;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) return null;
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    
    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else head = cursor.next;
    cursor.next.prev = cursor.prev;
    size--;
    
    Object old = cursor.value;
    cursor.value = null;
    cursor.next = null;
    cursor.prev = null;
    return old;
  }
  
  public int insert(int index, Object value) {
    if (index < 0 || index >= size) return -1;
    Node cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Node node = new Node(value);
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
