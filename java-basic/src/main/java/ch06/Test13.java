// main() 메서드의 parameter  " args "
package ch06;

public class Test13 {
  public static void main(String[] args) {
    
    // args는 배열이 넘어오긴 하지만 빈값임 null은 아님
    System.out.println("-----------------");
    for (String aa : args) { 
      System.out.println(aa);
    }
    System.out.println("-----------------");

    
    
    
  }
  
}

/*
# 프로그램 아규먼트(arguments)
- 프로그램을 실행할 때 넘겨주는 값
- 어떻게 아규먼트를 넘기는가 ?

  $ java 클래스명 값1 값2 값3
  
- 아규먼트는 공백으로 구분한다.
- JVM은 아규먼트의 개수만큼 문자열을 배열을 만들어 저장한다
- 아규먼트가 없으면 빈 배열을 만든다
- 그런 후 main()을 호출할 때 그 배열의 주소를 넘겨준다




*/