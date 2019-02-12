// URL 다루기 - 요청하기 2 URL connection
package ch23.h;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Test05 {
  public static void main(String[] args) throws Exception {
    
    URL url = new URL("https://www.naver.com/");

    // URL 정보를 가지고 HTTP 요청을 수행할 객체를 얻음
    URLConnection con = url.openConnection();
    // 웹 서버와 연결
    con.connect();
    
    // 웹서버의 응답 데이터를 읽어들일 도구를 return
    InputStream in = con.getInputStream();
    
    // 서버가 보낸 데이터를 한 줄씩 읽기 위해 데코레이터
    BufferedReader in2 = new BufferedReader(new InputStreamReader(in));
    
    while (true) {
      String str = in2.readLine();
      System.out.println(str);
      if(str == null) break;
    } // while
    

    in2.close();
    in.close();
  } // main
}
