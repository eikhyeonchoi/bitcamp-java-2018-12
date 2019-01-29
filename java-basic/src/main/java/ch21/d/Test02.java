// 예외 보고하기 - return 값으로 예외를 보고하는 경우
package ch21.d;

import java.util.ArrayList;

public class Test02 {
  static ArrayList<String> list = new ArrayList<String>();
  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName(null); // 없어진 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정
    addName(null); // 없어진 학생인 경우 해당 번호의 이름을 null로 설정한다고 가정
    addName("유관순");

    // Exception 계열(RuntimeException 계열 제외)의 예외가 발생하는 메서드를 호출할 때는
    // 반드시 예외처리를 해야한다 
    // try~catch로 처리하든, throws 절을 메서드 선언부에 붙이든 둘 중 하나 해야함
    for (int i = 0; i < list.size(); i++) {
      String name = getName(i);
      // 예외 상황을 검사하기 위해 getName()의 return값 확인
      // null 이면 예외 발생했다는 것이다
      // 하지만 우리가 원한 null은 없어진 학생을 표시하기 위함인데 여기선 예외가 발생했다고 처리한다
      if (name == null)
        System.out.println("목록에서 데이터를 꺼낸중 오류발생 ");
      else
        System.out.println(getName(i));
    }
    System.out.printf("입력된 이름 갯수는 %d 입니다\n", list.size());
    
    
  }
  static void addName(String name) {
    list.add(name);
  }

  // 2) return 값으로 예외를 보고하기
  // ==> 예전 C에서는 return 값으로 예외 상황 보고
  //     문제는 return 값으로 예외 사황을 완전히 표현할 수 없다는 것
  static String getName(int index) {
    if (index < 0 || index >= list.size())
      return null;
    // 예외 상황일 때 이 메서드가 return하는 null은
    // 일부러 목록에 입력한 null일 수 있다
    // 즉 예외 상황일 때 return하는 값과 정상적인 결과로 return하는 값이 같을 수 있다
    // 이렇게 return 값으로 예외상황을 알리는 방식은 
    // 완전하게 동작하지 못한다
    // ==> 그래서 예외 처리 문법이 별도로 등장한 것이다
    // ==> 즉 어떤 상황에서 예외가 발생하면 그것을 호출자에게 리턴 값으로 알리지 말고
    //     별개의 경로로 알려주자
    return list.get(index);
  }
}
