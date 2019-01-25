package com.eomcs.util;
import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class ArrayList<E> implements List<E> {
  Object[] list;
  private int  size = 0;

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public ArrayList() {
    list = new Object[10];
  }

  public ArrayList(int length) {
    if (length < 10) {
      list = new Object[10];
    } else {
      list = new Object[length];
    }
  }

  /*
  @SuppressWarnings("unchecked")    
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
  }
   */
 
 
  @SuppressWarnings("unchecked")    
  public Object[] toArray() {
    Object[] temp = new Object[this.size()];
    System.arraycopy(list, 0, temp, 0, size);
    return temp;
  }

  public void add(E ee) {
    if (size >= list.length) {
      list = Arrays.copyOf(list, list.length + (list.length >> 1));
      System.out.println("배열을 증가했습니다 배열 length : " + list.length);
    }
    list[size] = ee;
    size++; 
  }


  @SuppressWarnings("unchecked")
  public E get(int index) {
    // index : 값을 꺼낼 배열의 항목 위치
    if (index < 0 || index >= size)
      return null;

    return (E) list[index]; 
  }

  public E set(int index, E value) {
    // index : 값을 변경할 배열의 항목 위치 
    // value : 해당 위치에 있는 값을 대체할 값
    // return 값 : 대체되기 전 기존 값
    if (index < 0 || index >= size) return null;

    @SuppressWarnings("unchecked")
    E obj = (E) list[index];
    list[index] = value;
    return obj;
  }

  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // return : 삭제된 이전 값
    // System.arraycopy 참고
    if (index < 0 || index >= size) return null;

    @SuppressWarnings("unchecked")
    E obj = (E) list[index];
    for (int i = index; i < size-1; i++) {
      list[i] = list[i + 1]; 
    }
    size --;
    return obj;
  }

  @SuppressWarnings("unchecked")
  @Override
  public<T> T[] toArray(T[] sampleArr) {
    return (T[]) Arrays.copyOf(list, size, sampleArr.getClass());
  }


}
