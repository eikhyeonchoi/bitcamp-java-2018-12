package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class Ram {
  private String maker;
  private int price;
  
  public Ram() {
    System.out.println("Ram()");
  }
  
  @Override
  public String toString() {
    return "Ram [maker=" + maker + ", price=" + price + "]";
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
