package design_pattern.iterator;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_SIZE = 5;
  Object[] arr;
  int size = 0;
  
  public ArrayList() {
    this(0);
  }
  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else arr = new Object[DEFAULT_SIZE]; 
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(arr, size);
  }

  public void add(E value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50%만큼 증가시켜라
    if (size >= arr.length) increase();
    arr[size] = value;
    size++;
   }
  
  public int insert(int index, E value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50%만큼 증가시켜라
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 저장하지말라
    // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라
    if (size >= arr.length) increase();
    if (index < 0 || index >= size) return -1;
    
    for (int k = size-1 ; k >= index; k--) {
      arr[k+1] = arr[k];
    }
    arr[index] = value;
    size++;
    
    return 0;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 return null;
    if (index < 0 || index >= size) return null;
    return (E) arr[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지말라 , return값은 null;
    if (index < 0 || index >= size) return null;
    E old = (E) this.arr[index];
    arr[index] = value;
    return old;
  }
  
  public void reverse() {
    
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 삭제하지말라
    // 삭제한 후 다음 항목을 앞으로 당긴다
    if (index < 0 || index >= size) return null;
    E obj = (E) arr[index];
    for (int k = index; k < size-1; k++) {
      arr[k] = arr[k+1];
    }
    size--;
    return obj;
  }
  
  public void print() {
    for(int k = 0; k < size; k++) {
      System.out.printf("%d, ", arr[k]);
    }
  }

  private void increase() {
    int newSize = arr.length + (arr.length >> 1);
    arr = Arrays.copyOf(arr, newSize);
  }
  
  // 자신이 보유한 데이터를 꺼내주는 일을 하는 객체를 알려주는 메서드
  public Iterator<E> iterator() {
    
    return new Iterator<E>(){
      // 이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 한다
      // ==> 이런 일을하는 객체를 Iterator 라고 부른다
      int index = 0;
      
      @Override
      public boolean hasNext() {
        return index < size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        return (E) get(index++);
      }
    };
  }
  
  
  
}
