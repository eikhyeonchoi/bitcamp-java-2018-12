package design_pattern.chain_of_reponsibility;

public abstract class AbstractHandler implements Handler {
  
  Handler next;
  
  public AbstractHandler() {
  } // con
  
  public AbstractHandler(Handler next) {
    this.next = next;
  } // con

  
  
  public Handler getNext() {
    return next;
  }

  public void setNext(Handler next) {
    this.next = next;
  }
} // end of class
