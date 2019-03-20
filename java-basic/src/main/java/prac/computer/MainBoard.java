package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class MainBoard {
  private String maker;
  private int price;
  
  public MainBoard() {
    System.out.println("MainBoard()");
  }
  
  @Override
  public String toString() {
    return "MainBoard [maker=" + maker + ", price=" + price + "]";
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
}
