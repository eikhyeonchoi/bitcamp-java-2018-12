package spring_base_prac.java.way1;

public class Topping {
  private String name;
  private int price;
  
  @Override
  public String toString() {
    return "Topping [name=" + name + ", price=" + price + "]";
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
