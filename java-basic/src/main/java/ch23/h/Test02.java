// URL 다루기 - 문서 내부의 특정위치를 가리키기
package ch23.h;
import java.net.URL;

public class Test02 {
  public static void main(String[] args) throws Exception {
    // 웹에서 자원의 위치를 표현하는 방법
    // ==> [프로토콜]://서버주소:포트번호/자원의경로
    // ==> 프로토콜 : http, https
    // ==> 서버주소 : IP주소, 서버도메인주소
    // ==> 포트번호 : 80(생략할 수 있다), 8080(프록시서버) 등
    // ==> 자원경로 : /index.html, /board/list.do 등 

    // 자바에서 URL저장하기
    // ?다음에는 파라미터임 = 쿼리스트링
    URL url = new URL("http://bitcamp.co.kr:80/a/b/c/index.php#side");
    System.out.printf("프로토콜 : %s\n", url.getProtocol());
    System.out.printf("서버주소 : %s\n", url.getHost());
    System.out.printf("포트번호 : %s\n", url.getPort()); // 생략하면 return -1
    System.out.printf("자원경로 : %s\n", url.getPath());
    // # 다음의 값 == 문서내부 특정위치
    System.out.printf("내부위치 : %s\n", url.getRef()); // side

  } // main
}
