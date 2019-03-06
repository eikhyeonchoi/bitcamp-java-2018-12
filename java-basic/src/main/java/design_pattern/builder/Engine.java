package design_pattern.builder;

public class Engine {
  private String model;
  private String cc;
  private int cylinder;
  private int valve;
  
  public Engine(String m, String cc, int c, int v) {
    this.model = m;
    this.cc = cc;
    this.cylinder = c;
    this.valve = v;
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public String getCc() {
    return cc;
  }
  public void setCc(String cc) {
    this.cc = cc;
  }
  public int getCylinder() {
    return cylinder;
  }
  public void setCylinder(int cylinder) {
    this.cylinder = cylinder;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    this.valve = valve;
  }
  
  @Override
  public String toString() {
    return "Engine [model=" + model + ", cc=" + cc + ", cylinder=" + cylinder + ", valve=" + valve
        + "]";
  }
  
  
  
  
}
