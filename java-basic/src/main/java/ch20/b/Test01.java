// Stack 클래스 사용법
package ch20.b;
import java.util.Stack;

public class Test01 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    
    // pop() - 스택의 맨 마지막에 입력된 값부터 꺼낸다
    // ==> 그래서 stack은 LIFO(Last In, First Out) 방식으로 데이터를 다룬다
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    
    // java.util.EmptyStackException
    // 값이 없는데 꺼내려 하면 예외 발생
    System.out.println(stack.pop());
    

  }
}
