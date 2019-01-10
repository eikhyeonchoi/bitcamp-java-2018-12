// JVM 아규먼트 응용 2
package ch06;


public class Test18 {
  public static void main(String[] args) {
    
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라
    //
    
    java.util.Properties props = System.getProperties();

    java.util.Set keySet = props.keySet();
    
    for (Object key : keySet) {
     String value =  System.getProperty((String) key);
     System.out.printf("%s = %s\n", key, value);
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }

}


/*

*/
