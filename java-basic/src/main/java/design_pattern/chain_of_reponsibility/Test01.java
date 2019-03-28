package design_pattern.chain_of_reponsibility;
import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    MultipleHandler multipleHandler = new MultipleHandler();
    MinusHandler minusHandler = new MinusHandler();
    PlusHandler plusHandler = new PlusHandler();
    TerminalHandler terminalHandler = new TerminalHandler();
    
    
    multipleHandler.setNext(minusHandler);
    minusHandler.setNext(plusHandler);
    plusHandler.setNext(terminalHandler);
    
    while(true) {
      System.out.printf("a? : ");
      int a = Integer.parseInt(keyScan.nextLine());
      
      System.out.printf("b? : ");
      int b = Integer.parseInt(keyScan.nextLine());
      
      System.out.printf("op? : ");
      String op =keyScan.nextLine();
      
      multipleHandler.handle(a, b, op);
    } // while
  } // main
  
} // end of class
