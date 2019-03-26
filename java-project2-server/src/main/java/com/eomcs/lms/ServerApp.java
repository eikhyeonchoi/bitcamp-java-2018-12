package com.eomcs.lms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

@WebServlet("/*")
public class ServerApp implements Servlet {
  final static Logger logger = LogManager.getLogger(ServerApp.class);

  ApplicationContext iocContainer;
  RequestMappingHandlerMapping handlerMapping;
  
  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {
    //l 이 클래스의 인스턴스가 생성된 후 tomcat이 제일 먼저 호출하는 메서드
    //l ==> 보통 이 클래스가 작업하는데 필요한 객체를 준비한다
    
    this.config = config;

    logger.info("Spring IoC 컨테이너 준비 ...");
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class); 
    printBeans();

    logger.info("RequestMappingHandlerMapping 객체 준비 ...");
    handlerMapping = 
        (RequestMappingHandlerMapping) iocContainer.getBean(
            RequestMappingHandlerMapping.class);
    System.out.println("서버 실행 중...");
  } // init


  @Override
  public void service(
      javax.servlet.ServletRequest req, 
      javax.servlet.ServletResponse res)
          throws ServletException, IOException {

    //l 톰켓 서버가 파라미터로 넘겨준 값을 원래의 타입으로 변환해서 사용
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    //l 웹 브라우저로 출력할 때 사용할 출력 스트림 준비
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String commandPath = request.getPathInfo();
    logger.info("클라이언트 요청 : " + commandPath);

    RequestMappingHandler requestHandler = handlerMapping.get(commandPath);

    if (requestHandler == null) {
      out.println("실행할 수 없는 명령입니다.");
      return;
    }

    try {
      requestHandler.method.invoke(
          requestHandler.bean, // 메서드를 호출할 때 사용할 인스턴스 
          request, response); // 메서드 파라미터 값
      
    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
      e.printStackTrace();
    } // try
  } // service
  
  @Override
  public void destroy() {
    //l 서버를 종료하거나 웹 어플리케이션을 종료할 때 생성된 모든
    //l 서블릿 객체는 소멸될 것이다, 그래서 소멸되기 전에 사용한 자원을
    //l 해제시키기 위해 톰캣이 이 메서드를 호출한다 
    //l 즉 init()에서 준비한 자원을 이 메서드에서 해제
  }
  
  @Override
  public ServletConfig getServletConfig() {
    //l init()가 호출될 때 파라미터로 받은 ServletConfig 객체를 그대로 return
    return this.config;
  }
  
  @Override
  public String getServletInfo() {
    //l 톰캣 서버가 관리자 화면을 띄울 때 서블릿 정보를 출력하기 위해 
    //l 이 메서드를 호출하는 경우가 있다 
    //l ==> 간단히 이 서블릿이 어떤 일을 하는 서블릿인지 알려주는 문장을 return
    return "Command 요청을 받아 처리하는 Servlet";
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









