package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class Phone {
  private String maker;
  private int price;
  
  public Phone() {
    System.out.println("Phone()");
  }
  
  @Override
  public String toString() {
    return "Phone [maker=" + maker + ", price=" + price + "]";
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
