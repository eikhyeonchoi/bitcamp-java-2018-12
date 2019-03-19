package prac;

public class Navigation {
  private String maker;
  private String name;
  private int price;
  
  public Navigation() {
    System.out.println("Navigation()");
  }
  
  public Navigation(String maker, String name, int price) {
    System.out.println("Navigation(String, String, price)");
    this.maker = maker;
    this.name = name;
    this.price = price;
  }
  @Override
  public String toString() {
    return "Navigation [maker=" + maker + ", name=" + name + ", price=" + price + "]";
  }
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  
  
  
}
