package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

public class ServerApp {

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

  //l 바깥 클래스(ServerApp)의 인스턴스 필드를 사용해야 한다면 
  //l Inner 클래스(non-static nested class)로 정의하라!
  //l 
  class RequestHandlerThread extends Thread {

    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {

      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        //l 클라이언트의 요청 읽기
        String request = in.readLine();

        //l 클라이언트에게 응답하기
        //l => 클라이언트 요청을 처리할 메서드를 꺼낸다.
        RequestMappingHandler requestHandler = handlerMapping.get(request);

        if (requestHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        try {
          //l 클라이언트 요청을 처리할 메서드를 찾았다면 호출한다.
          requestHandler.method.invoke(
              requestHandler.bean, //l 메서드를 호출할 때 사용할 인스턴스 
              new Response(in, out)); //l 메서드 파라미터 값

        } catch (Exception e) {
          out.printf("실행 오류! : %s\n", e.getMessage());
          e.printStackTrace();
        }

        out.println("!end!");
        out.flush();


      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();

      }
    }
  }
  
  private void printBeans() {
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    String[] names = iocContainer.getBeanDefinitionNames();
    for(String name : names) {
      System.out.printf("%s ==> %s\n", name, 
          iocContainer.getBean(name).getClass().getName());
    }
    System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
  }


}









