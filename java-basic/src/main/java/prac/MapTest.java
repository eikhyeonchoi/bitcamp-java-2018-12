package prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
  public static void main(String[] args) {
    
    Map<Integer, String> map = new HashMap<Integer, String>();
    
    map.put(1, "a");
    map.put(2, "b");
    map.put(3, "c");
    map.put(4, "d");
    map.put(5, "e");
    map.put(6, "f");
    map.put(7, "g");
    map.put(8, "h");
    map.put(9, "i");
    map.put(10, "j");
    map.put(11, "k");
    map.put(12, "l");
    map.put(13, "m");
    map.put(14, "n");
    map.put(15, "o");
    
    
    List<Map> list = new ArrayList<Map>();
    
    list.add(map);
    
    for(Map mm : list) {
      System.out.println(mm);
    }
    

   
  }

}
