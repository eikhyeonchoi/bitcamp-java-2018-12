package ch23.i;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Test01 {
  public static void main(String[] args) throws Exception {
    String str = "ABC012가각간";
    
    byte[] bytes = str.getBytes("UTF-8");
    
    Encoder encoder = Base64.getEncoder();
    byte[] base64Bytes = encoder.encode(bytes);
    
    Decoder decoder = Base64.getDecoder();
    byte[] decodeBytes = decoder.decode(base64Bytes);
        
    
    System.out.println(new String(base64Bytes));
    System.out.println(new String(decodeBytes));

  }
}
