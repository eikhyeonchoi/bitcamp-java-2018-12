package design_pattern.chain_of_reponsibility;

public class TerminalHandler extends AbstractHandler{



  @Override
  public void handle(int a, int b, String op) {
    // 연결의 끝
    System.out.println("해당 연산자를 지원하지 않습니다");
    
  } // handle



} // end of class
