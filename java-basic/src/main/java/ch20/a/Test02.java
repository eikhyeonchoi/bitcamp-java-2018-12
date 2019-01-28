// java.util.ArrayList사용법 - 메서드 사용
package ch20.a;
import java.util.Date;
import java.util.ArrayList;

public class Test02 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    
    // add() : 목록에 순차적으로 추가
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add(null); // ArrayList는 null을 추가하는 것을 허락한다
    list.add("eee");
    list.add(null); // ArrayList는 null을 추가하는 것을 허락한다
    list.add("aaa"); // ArrayList는 같은 인스턴스를 중복 추가하는 것을 허락한다
    list.add("bbb"); // ArrayList는 같은 인스턴스를 중복 추가하는 것을 허락한다
    System.out.println(list);
    
    
    // remove(index) : 목록에서 해당 인덱스의 값을 삭제한다, 리턴값은 삭제된값
    String removeContent = list.remove(1);
    System.out.println(removeContent);
    System.out.println(list);
    
    // set(index, value) : index를 value로 변경, 리턴값은 이전값
    String setContent = list.set(2, "xxx");
    System.out.println(setContent);
    System.out.println(list);
    
    // get(index) : 해당 위치의 값을 리턴
    System.out.println(list.get(2));
    
    // index가 유효하지 않을 경우 error 발생;
    // java.lang.IndexOutOfBoundsException 
    // System.out.println(list.get(7)); 
    
    
    
    
    

  }
}
