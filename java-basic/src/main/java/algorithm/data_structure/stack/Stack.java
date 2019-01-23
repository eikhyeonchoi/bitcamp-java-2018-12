package algorithm.data_structure.stack;

public class Stack {
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size = 0;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(Object value) {
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
  public Object pop() {
    // 맨 마지막 값을 꺼내 return
    // 꺼낸 값을 배열에서 제거되어야 한다
    Object old = list[size - 1];
    size --;
    return old;
  }
  
  public boolean empty() {
    if (size == 0) return true;
    else return false;
  }
  
  public int size() {
    return size;
  }
  
  public void print() {
    for(int k =  0; k < size; k++) {
      System.out.printf("%d\n", list[k]);
    }
  }
  public static void main(String[] args) {
    Stack st = new Stack();
    st.push(100);
    st.push(200);
    st.push(300);
    st.push(400);
    System.out.println(st.pop());
    System.out.println(st.empty());
    System.out.println(st.pop());
    System.out.println(st.empty());
    System.out.println(st.pop());
    System.out.println(st.empty());
    System.out.println(st.pop());
    System.out.println(st.empty());
    

    //st.print();
  }
  
}
