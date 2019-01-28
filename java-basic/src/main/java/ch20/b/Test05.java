// Stack 클래스 사용법 - search()
package ch20.b;
import java.util.Stack;

public class Test05 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    System.out.println(stack.search(new String("ddd"))); // 없으면 -1

    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i));
    }
    
    
    
    
  }
}
