package spring_base_prac.java.way1;

public class Pizza {
  private String maker;
  private String name;
  private int price;
  private Topping topping;
  
  public Pizza() {
  }
  
  public Pizza(String maker, String name, int price, Topping topping) {
    this.maker = maker;
    this.name = name;
    this.price = price;
    this.topping = topping;
  }
  
  @Override
  public String toString() {
    return "Pizza [maker=" + maker + ", name=" + name + ", price=" + price + ", topping=" + topping
        + "]";
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

  public Topping getTopping() {
    return topping;
  }

  public void setTopping(Topping topping) {
    this.topping = topping;
  }
  
  
  
  

  
}
