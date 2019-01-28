// Stack 클래스 사용법 - search()
package ch20.b;
import java.util.Stack;

public class Test04 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // search() - stack의 맨 위에서부터 해당 값을 찾는다. 위치는 1부터 시작한다 제일 위가 1
    System.out.println(stack.search(new String("ccc"))); // 맨위, 첫번 째
    System.out.println(stack.search(new String("bbb"))); // 2
    System.out.println(stack.search(new String("aaa"))); // 3
    System.out.println(stack.search(new String("ddd"))); // 없으면 -1

  }
}
