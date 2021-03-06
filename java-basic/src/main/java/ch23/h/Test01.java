// URL 다루기
package ch23.h;
import java.net.URL;

public class Test01 {
  public static void main(String[] args) throws Exception {
    // 웹에서 자원의 위치를 표현하는 방법
    // ==> [프로토콜]://서버주소:포트번호/자원의경로
    // ==> 프로토콜 : http, https
    // ==> 서버주소 : IP주소, 서버도메인주소
    // ==> 포트번호 : 80(생략할 수 있다), 8080(프록시서버) 등
    // ==> 자원경로 : /index.html, /board/list.do 등 

    // 자바에서 URL저장하기
    URL url = new URL("http://bitcamp.co.kr:80/index.php?main_page=home&articleId=100");
    System.out.printf("프로토콜 : %s\n", url.getProtocol());
    System.out.printf("서버주소 : %s\n", url.getHost());
    System.out.printf("포트번호 : %s\n", url.getPort()); // 생략하면 return -1
    System.out.printf("자원경로 : %s\n", url.getPath());
    // ?다음에는 파라미터임 = 쿼리스트링 ++ 파라미터 구분하는 기호는 &임
    // 파라미터 총 2개 main_page, articleId // 값도 2개 =home, =100 
    // 구분 문자 & 
    // 쿼리스트링
    // ==>자원의 경로(path) 다음에 오는 파라미터임
    // ==> 형식이 ==> ?파라미터명=파라미터값&파라미터명=파라미터값&파라미터명=파라미터값
    System.out.printf("QueryString : %s\n", url.getQuery());

  } // main
}
