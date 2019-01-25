package design_pattern.iterator;

public class Stack<E> {
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size = 0;

  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }

  public void push(E value) {
    // 맨 마지막에 추가
    // 배열의 크기가 작다면 확장해야한다
    if (size >= list.length) {
      int newSize = list.length + (list.length >> 1);
      Object[] temp = new Object[newSize];
      for (int k = 0; k < size; k++) {
        temp[k] = list[k];
      }
      list = temp;
    }
    list[size] = value;
    size ++;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    // 맨 마지막 값을 꺼내 return
    // 꺼낸 값을 배열에서 제거되어야 한다
    if (size == 0) return null;
    Object old = list[size - 1];
    size --;
    return (E) old;
    // return list[--size];
  }

  public boolean empty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void print() {
    for(int k =  0; k < size; k++) {
      System.out.printf("%d\n", list[k]);
    }
  }

  //자신이 보유한 데이터를 꺼내주는 일을 하는 객체를 알려주는 메서드
  public Iterator<E> iterator() {
    return new Iterator<E>(){
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public E next() {
        int lastIndex = size - 1;
        return (E) list[lastIndex - (index++)];
      }
    };
  }


}
