package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class GraphicCard {
  private String maker;
  private int price;
  
  public GraphicCard() {
    System.out.println("GraphicCard()");
  }
  
  @Override
  public String toString() {
    return "GraphicCard [maker=" + maker + ", price=" + price + "]";
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
