package algorithm.data_structure.array;

public class ArrayList3 {
  static final int DEFAULT_CAPACITY = 5;
  private int size = 0;
  Object[] arr;

  public ArrayList3() {
    this(0);
  }
  
  public ArrayList3(int len) {
    if (len < DEFAULT_CAPACITY) arr = new Object[DEFAULT_CAPACITY];
    else arr = new Object[len];
  }
  
  public Object[] toArray() {
    Object[] temp = new Object[size];
    for (int k = 0; k < size; k++) {
      temp[k] = arr[k];
    }
    return temp;
  }
  
  public Object get(int index) {
    if (index < 0 || index > size-1) return null;
    return arr[index];
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index > size-1) return null;
    Object obj = arr[index];
    arr[index] = value;
    return obj;
  }
  
  public void add(Object value) {
    if (size == arr.length) {
      int newSize = arr.length + (arr.length >> 1);
      Object[] temp = new Object[newSize];
      for (int k = 0; k < size; k++) 
        temp[k] = arr[k];
      arr = temp;
    }
    arr[size] = value;
    size++;
  }
  
  public void insert(int index, Object value) {
    if (index < 0 || index > size-1) return;
    if (size == arr.length) {
      int newSize = arr.length + (arr.length >> 1);
      Object[] temp = new Object[newSize];
      for (int k = 0; k < size; k++) 
        temp[k] = arr[k];
      arr = temp;
    }
    for(int k = size -1; k >= index; k--) {
      arr[k+1] = arr[k];
    }
    size++;
    arr[index] = value;
  }
  
  public Object remove(int index) {
    if (index < 0 || index > size-1) return null;
    Object obj = arr[index];
    for (int k = index; k < size -1 ; k++) {
      arr[k] = arr[k+1];
    }
    size--;
    return obj;
  }
  
}
  
  
  
  
  

