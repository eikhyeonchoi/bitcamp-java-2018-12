package algorithm.data_structure.linkedlist;

public class LinkedList3 {
  Node3 head;
  Node3 tail;
  int size;

  public LinkedList3() {
    head = new Node3();
    tail = head;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public void add(Object value) {
    tail.value = value;
    Node3 node = new Node3();
    node.prev = tail;
    tail.prev = node;
    node = tail;
    size++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    Node3 cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Object obj = cursor.value;
    return obj;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) return null;
    Node3 cursor = head;
    for (int k = 1; k <= index; k++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;
    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()];
    int k = 0;
    Node3 cursor = head;
    while(cursor != tail) {
      arr[k] = cursor.value;
      k++;
    }
    return arr;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) return null;
    Node3 cursor = head;
    for (int k = 0; k <= index; k++) {
      cursor = cursor.next;
    }
    if (cursor.prev != null)
      cursor.prev.next = cursor.next;
    else 
      head = cursor.next;
    cursor.next.prev = cursor.prev;
    
    Object old = cursor.value;
    cursor.value = null;
    cursor.next = null;
    cursor.prev = null;
    return old;
  }


}
