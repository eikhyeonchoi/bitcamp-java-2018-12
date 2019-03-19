package prac;

import java.util.Date;

public class Car {
  private String maker;
  private String name;
  private int cc;
  private int price;
  private Date createdDate;
  private Navigation navigation;
  
  public Car() {
    System.out.println("Car()");
  }
  
  public Car(String nm, int pr, Date cdt) {
    System.out.println("Car(String, int)");
    this.name = nm;
    this.price = pr;
    this.createdDate = cdt;
  }
  
  public Car(String nm, int pr) {
    System.out.println("Car(String, int)");
    this.name = nm;
    this.price = pr;
  }
  
  public Car(String maker, String name, int cc, int price, Navigation navigation) {
    System.out.println("Car(String, String, int, int, Navigation)");
    this.maker = maker;
    this.name = name;
    this.cc = cc;
    this.price = price;
    this.navigation = navigation;
  }
  
  @Override
  public String toString() {
    return "Car [maker=" + maker + ", name=" + name + ", cc=" + cc + ", price=" + price
        + ", createdDate=" + createdDate + ", navigation=" + navigation + "]";
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
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
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public Navigation getNavigation() {
    return navigation;
  }
  public void setNavigation(Navigation navigation) {
    this.navigation = navigation;
  }
  
  
  
  
  
}
