// java.util.ArrayList사용법 - contains()
package ch20.a;
import java.util.Date;
import java.util.ArrayList;

public class Test03 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    
    String s4 = new String("bbb");
    
    System.out.println(s2 == s4);
    System.out.println(s2.equals(s4));
    System.out.println(s2.hashCode() ==  s4.hashCode());
    
    list.add(s1);
    list.add(s2);
    list.add(s3);
    System.out.println(list);
    
    // contains() : 인스턴스가 다르더라도 equals()의 retrun 이 true면
    // 목록에 있는 것으로 판단한다, ArrayList에서는 hashCode()까진 비교하지 않는다
    System.out.println(list.contains(s2));
    System.out.println(list.contains(s4));
    
    // String class는 이미 hashCode(), equals()가 override 되어있음
    

  }
}
