package ch24.d;

public class Account {
  String name;
  double balance;
  
  public Account(String name, double balance) {
    this.name = name;
    this.balance = balance;
  } // con

  
  // 스레드마다 스택이 있기 때문에 로컬변수가 각각 있다
  // 그래서 유효한 값이 나오지 않는 것 
  // 해결책이
  // withdraw 매서드를 한번에 한스레드만 갱신하도록 하면된다
  synchronized public double withdraw(double money) {
    // 이 메서드처럼 여러 스레드가 같은 메모리(Balance)의 값을 동시에 변경할 때
    // 문제가 발생하는 코드를 "critical section(크리티컬 섹션)" or "critical region(크리티컬 리젼)"
    // 크리티컬 섹션에 동시에 접근하지 못하게 하는 기법을
    // "mutex(뮤텍스)" or "semaphore(세마포어(1))" 라고 부른다
    // 자바에서 뮤텍스를 구현하는 방법
    // ==> 크리티컬 섹션에 해당하는 메서드나 코드블럭에 synchronized 키워드를 사용해 
    //     한 번에 한 스레드만 진입할 수 있게 lock을 건다    
    double temp = this.balance;
    if(temp - money < 0) return 0;
    
    temp = temp - money;
    
    this.balance = temp;
    
    return money;
  } // withdraw()
} // end of class
