// Object 클래스 : 주요 메서드 - hashCode() 응용
package ch15;

import java.util.HashMap;

public class Test08 {
  public static void main(String[] args) {
    // hash 코드는 Map에서 값을 저장하기 위해 key로 사용한다
    HashMap map = new HashMap();
    
    // Map은 값을 저장할 때 key를 이용
    // ==> key : 값을 저장할 위치를 계산할 때 사용
    // ==> map.put(key, value);
    
    // put(Object key, Object value)
    // ==> key값으로 int를 넘겨준다?
    // ==> Integer.valueOf(100)과 동일 - 오토박싱임 Integer 객체를 만드는 것
    // ==> Integer.valueOf(100)과 동일 - 오토박싱임 Integer 객체를 만드는 것
    // Object key = Integer.valueOf(100);
    // put() 메서드는 key로 넘겨 받은 객체에 대해 hashCode()를 호출해 정수 값을 얻음
    // ==> hashCode()를 활용해 값을 저장할 위치를 계산 
    // ==> 그 후 그 위치에 해당하는 배열(배열로관리한다면)에 저장
    Integer k1 = new Integer(101);
    Integer k2 = new Integer(102);
    Integer k3 = new Integer(103);
    Integer k4 = new Integer(104);
    Integer k5 = new Integer(105);
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중군", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    Integer k6 = new Integer(102);
    // 인스턴스는 다르지만 해시코드는 같다
    System.out.println(k2 == k6);
    System.out.println(k2.hashCode());
    System.out.println(k6.hashCode());
    System.out.println(k2.equals(k6));
    // 결론
    // ==> k2와 k6는 다른객체지만, 내용물은 같다
    // get(key)
    // ==> key파라미터로 받은 객체에 대해 hashCode()를 호출해 정수 값을 얻는다
    // ==> 그리고 정수 값을 이용해 값이 저장된 위치를 찾는다
    //     원래의 키와 내용물이 같은지 equals()로 한번 더 비교한다
    //     만약 같다면 같은 key로 간주하여 해당 값을 return
    // 따라서 k2로 저장한 값을 k6로 꺼낼 수 있다
    // 왜? 객체는 다르지만 내부 값이 같기 때문에 같은 key라고 간주한다
    //    hasCode()의 리턴 값이 같고, equals()의 리턴 값이 true이기 때문에 같은 key로 간주
    
    // 저장할 때 사용한 key로 값을 꺼내면 된다
    // 해당 키로 저장한 값을 찾을 수 없으면 null return
    System.out.println(map.get(200));
    
  }
}
