// 제네릭(generic) 응용 - 제네릭과 배열
package ch16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test05 {
  public static void main(String[] args) {
    // 제네릭을 사용하는 메서드를 이용하여 배열 만들기
    
    // 파라미터로 빈 배열을 넘기면 
    String[] strings = create2(new String[0]);
    System.out.println(strings.length);
    
    // 내부에서 생성할 배열 크기보다 더 큰 배열을 파라미터로 넘긴다면?
    // 무적권 copyOf()에 명시한 크기대로 만듬
    String[] temp = new String[100];
    String[] strings2 = create2(new String[100]);
    System.out.println(strings2.length);
    System.out.println(temp == strings2);
    
    // 생성할 배열의 타입 정보를 넘긴다
    String[] strings3 = create3(String.class);
    System.out.println(strings3.length);
    
    
  }
  // 제네릭으로 배열 생성하기
  
  // ex 1) 제네릭의 타입 파라미터로 "레퍼런스배열"을 생성할 수 없다
  static <T> T[] create1() {
    // T[] arr = new T[10]; compile error
    return null;
  }
  
  // ex 2) 견본 배열을 받아 복제하는 방법을 사용한다
  static <T> T[] create2(T[] arr) {
    // copyOf(original, newLength) 
    // ==> 원래 배열(original)과 같은 타입의 배열을 배열크기(newLength)에 맞춰 새로 생성
    return Arrays.copyOf(arr, 10);
  }
  
  // ex 3) 배열의 타입 정보를 받아 생성하기
  @SuppressWarnings("unchecked")
  static <T> T[] create3(Class<T> type) {
    return (T[]) Array.newInstance(type, 10);
  }
  // ex 4) 견본 배열의 타입 정보를 가지고 배열을 생성하기
  @SuppressWarnings("unchecked")
  static <T> T[] create4(T[] arr) {
    // copyOf(original, newLength) 
    // ==> 원래 배열(original)과 같은 타입의 배열을 배열크기(newLength)에 맞춰 새로 생성
    return (T[]) Array.newInstance(arr.getClass(), 10);
  }
  
}
