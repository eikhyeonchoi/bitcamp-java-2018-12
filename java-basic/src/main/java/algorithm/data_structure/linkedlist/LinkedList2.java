package algorithm.data_structure.linkedlist;

public class LinkedList2 {
  Node2 head;
  Node2 tail;
  int size;

  public LinkedList2() {
    head = new Node2();
    tail = head;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public void add(Object value) {
    tail.value = value;
    Node2 node = new Node2();
    tail.next = node;
    node.prev = tail;
    tail = node;
    size ++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    Node2 cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) return null;
    Node2 cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()];
    Node2 cursor = head;
    int i = 0;
    while(cursor != tail) {
      arr[i] = cursor.value;
      cursor = cursor.next;
      i++;
    }
    return arr;
  }

  public Object remove(int index) {
    if(index < 0 || index >= size) return null;
    Node2 cursor = head;
    for(int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    if(cursor.prev != null)
      cursor.prev.next = cursor.next;
    else 
      head = cursor.next;
    cursor.next.prev= cursor.prev;
    
    Object obj = cursor.value;
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;
    size --;
    return obj;
  }
  
  public int insert(int index, Object value) {
    if(index < 0 || index >= size) return -1;
    Node2 cursor = head;
    for (int k = 0; k <= index; k++) {
      cursor = cursor.next;
    }
    Node2 node = new Node2(value);
    node.next = cursor;
    node.prev = cursor.prev;
    cursor.prev.next = node;
    cursor.next.prev = node;
    
    
    
    
    
    
    return 0;
  }









}
