package com.eomcs.lms;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.ServletRequest;
import com.eomcs.lms.handler.ServletResponse;

public class ServerApp {
  final static Logger logger = LogManager.getLogger(ServerApp.class);

  ApplicationContext iocContainer;
  RequestMappingHandlerMapping handlerMapping;

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {

      iocContainer = new AnnotationConfigApplicationContext(AppConfig.class); 
      printBeans();

      handlerMapping = 
          (RequestMappingHandlerMapping) iocContainer.getBean(
              RequestMappingHandlerMapping.class);


      System.out.println("서버 실행 중...");
      logger.info("서버 실행 중...");

      while (true) {
        new RequestHandlerThread(ss.accept()).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } //l try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    app.service();
  }

  class RequestHandlerThread extends Thread {
    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      logger.info("클라이언트 연결되었음.");
      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        // 클라이언트의 요청 읽기
        String requestLine = in.readLine();
        logger.debug(requestLine);
        
        while (true) {
          String str = in.readLine();
          if (str.length() == 0) // 요청의 끝을 만나면 읽기를 멈춘다. 
            break;
        }
        
        // 예) GET /member/list HTTP/1.1
        // 예) GET /member/detail?no=10 HTTP/1.1
        // 예) GET /member/add?name=aaa&email=aaa@test.com&password=1111 HTTP/1.1
        // => requestURI[0] : /board/detail
        // => requestURI[1] : no=1
        String[] requestURI = requestLine.split(" ")[1].split("\\?");
        String commandPath = requestURI[0];
            
        // 클라이언트에게 응답하기
        // => HTTP 프로토콜에 따라 응답 헤더를 출력한다.
        // => 클라이언트 요청을 처리할 메서드를 꺼낸다.
        RequestMappingHandler requestHandler = handlerMapping.get(commandPath);
        
        if (requestHandler == null) {
          out.println("HTTP/1.1 404 Not Found");
          out.println("Server: bitcamp");
          out.println("Content-Type: text/plain; charset=UTF-8");
          out.println();
          out.println("실행할 수 없는 명령입니다.");
          out.flush();
          return;
        }
        
        try {
          // 요청을 처리할 메서드가 사용할 Request, Response 준비하기
          ServletRequest request = new ServletRequest();
          if (requestURI.length > 1) {
            // 예) name=aaa&email=aaa@test.com&password=1111
            request.setQueryString(requestURI[1]); 
          }

          ServletResponse response = new ServletResponse(in, out);
          
          // 클라이언트 요청을 처리할 메서드를 찾았다면 호출한다.
          out.println("HTTP/1.1 200 OK");
          out.println("Server: bitcamp");
          out.println("Content-Type: text/html; charset=UTF-8");
          out.println();
          
          requestHandler.method.invoke(
              requestHandler.bean, // 메서드를 호출할 때 사용할 인스턴스 
              request, response); // 메서드 파라미터 값
          
        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
          e.printStackTrace();
        }
        out.flush();
        
      } catch (Exception e) {
        logger.error("명령어 실행 중 오류 발생 : " + e.toString());
        StringWriter strWriter = new StringWriter();
        PrintWriter out = new PrintWriter(strWriter);
        e.printStackTrace(out);
        logger.error(strWriter.toString());
        
      }
      logger.info("클라이언트와 연결 종료.");
    }
  }

  private void printBeans() {
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
  }


}









