package algorithm.data_structure.array;

public class ArrayList2 {
  static final int DEFAULT_CAPACITY =  5;
  Object[] arr;
  int size = 0;

  public ArrayList2() {
    this(0);
  }
  public ArrayList2(int len) {
    if (len < DEFAULT_CAPACITY) 
      arr = new Object[DEFAULT_CAPACITY];
    else 
      arr = new Object[len];
  }

  public Object[] toArray() {
    Object[] tmp = new Object[size];
    for(int k = 0; k < size; k++) {
      tmp[k] = arr[k];
    }
    return tmp;
  }

  public void add(Object value) {
    if (size == arr.length) {
      int newSize = arr.length + (arr.length >> 1);
      Object[] temp = new Object[newSize];
      for(int k = 0; k < arr.length; k++) {
        temp[k] = arr[k];
      }
      arr = temp;
    }
    arr[size] = value;
    size++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) return null;
    return arr[index];
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) return null;

    Object obj = arr[index];
    arr[index] = value;
    return obj;
  }

  public void insert(int index, Object value) {
    if (index < 0 || index >= size) return;
    if (size >= arr.length) {
      int newSize = arr.length + (arr.length >> 1);
      Object[] temp = new Object[newSize];
      for(int k = 0; k < arr.length; k++) {
        temp[k] = arr[k];
      }
      arr = temp;
    }
    for (int k = size - 1; k >= index; k--) {
      arr[k+1] = arr[k];
    }
    size++;
    arr[index] = value;
  }
  
  public Object remove(int index) {
    if (index < 0 || index >= size) return null;
    
    Object obj = arr[index];
    for (int k = index; k < size - 1; k++) {
      arr[k] = arr[k+1];
    }
    size --;
    return obj;
  }
  
  public void reverse() {
    Object switchObj = null;
    int reverseSize = size-1;
    for(int k = 0; k < size/2; k++) {
      
      switchObj = arr[k];
      arr[k] = arr[reverseSize];
      arr[reverseSize] = switchObj;
      reverseSize--;
    }
  }
  
  public void print() {
    for(int k = 0; k < size; k++) {
      System.out.printf("%d ,", arr[k]);
    }
  }


}
