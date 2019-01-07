// 키보드로 입력한 값 받기 4 - int와 문자열을 섞어읽기;
package ch03; 

public class Test09 {
  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    
    System.out.print("age? ");
    int age = keyboard.nextInt();
    // nextInt()는 한 개의 token을 읽은 후 줄 바꿈 코드는 읽기 전 상태로 내비둔다;
    // nextInt()는 LF코드를 읽지않음;
    // 따라서 다음에 nextLine()을 호출하면 의도치 않게 빈 문자열을 가진 한 줄을 
    // 읽는 상황이됨 
    // nextInt() 다음에 nextLine()을 호출할 때 이런 상황 발생;
    // 해결방법 ==> nextInt()를 호출한 후 남아있는 LF코드를 읽어서 제거한다.
    
    keyboard.nextLine(); //남아있는 LF코드 읽어서 해결;
    //읽어서 저장하지 않으니까 버리는거나 마찬가지임;
    
    System.out.print("name? ");
    String name = keyboard.nextLine();
    // nextInt()가 읽지 않은 LF코드를 nextLine()이 읽기 때문에
    // 빈문자열이 return 되는것
    // 그래서 nextInt() 다음에 LF코드를 버리는 코드가 필요함
    // keyboard.nextLine()으로 읽어버리고 저장안하고 다음 nextLine()을 호출하면해결
    // 저장을 안하니깐, LF코드를 버리는것이나 마찬가지임;
    
    System.out.printf("age : %d, name : %s",age, name);
    
    
  }
}

/*
 * 
 * 
 */


