package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class Cpu {
  private String maker;
  private int price;
  
  public Cpu() {
    System.out.println("Cpu()");
  }
  
  @Override
  public String toString() {
    return "Cpu [maker=" + maker + ", price=" + price + "]";
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
