// Apache HttpComponent 사용 - HttpGet class
package ch23.h;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test06 {
  public static void main(String[] args) throws Exception {
    
    // HttpGet 클래스
    // ==> www.apache.org 사이트에서 제공하는 HttpComponent 라이브러리에 들어 있는 class
    // ==> 사용하려면 먼저 외부 라이브러리를 프로젝트로 가져와야 한다
    //     1) mvnrepository.com 에서 apache httpClient 키워드로 검색
    //      2) 최신 라이브러리 정보를 build.gradle의 dependancies{} 블록에 추가한다
    //      3) 콘솔에서 "gradle eclipse"를 실행해서 .classpath파일을 갱신
    //         이때 외부 라이브러리를 자동으로 다운 받을 것이다
    //      4) 이클립스 해당 프로젝트 리프레시
    
    // 1) HTTP 요청을 수행할 객체를 준비한다
    CloseableHttpClient httpClient = HttpClients.createDefault();
    
    // 2) HTTP GET 요청 정보를 준비
    HttpGet get = new HttpGet("https://naver.com");
    
    // 3) HTTPClient 객체를 사용해 GET요청을 실행
    //     ==> 리턴 값은 웹서버의 응답 데이터를 다루는 도구이다
    CloseableHttpResponse response = httpClient.execute(get);
    
    // 4) 응답 도구를 이용하여 서버가 보낸 데이터를 꺼낸다
    HttpEntity entity = response.getEntity();
    
    // 5) HttpEntity 객체에 들어 있는 값을 문자열로 변환하여 출력한다
    System.out.printf("응답 데이터 크기 => %d\n",entity.getContentLength());
    System.out.printf("응답 데이터 마임 타입 => %s\n",entity.getContentType());
    System.out.println("----------------------------");
    // HttpEntity에 들어 있는 서버 응답 데이터를 꺼내려면 getContent()를 사용해야함
    // getContent()의 return 값은 InputStream객체
    // InputStream을 가지고 데이터를 읽으려면 입출력 코딩을 작성해야함 ==> 도우미 클래스 사용
    String content = EntityUtils.toString(entity);
    System.out.println(content);
    
  } // main
}
