package prac.computer;

import org.springframework.stereotype.Component;

@Component
public class Computer {
  private Cpu cpu;
  private GraphicCard graphicCard;
  private MainBoard mainBoard;
  private Ram ram;
  
  public Computer(Cpu cpu, GraphicCard graphicCard, MainBoard mainBoard, Ram ram) {
    System.out.println("Computer()");
    this.cpu = cpu;
    this.graphicCard = graphicCard;
    this.mainBoard = mainBoard;
    this.ram = ram;
  }
  
  @Override
  public String toString() {
    return "Computer [cpu=" + cpu + ", graphicCard=" + graphicCard + ", mainBoard=" + mainBoard
        + ", ram=" + ram + "]";
  }
  public Cpu getCpu() {
    return cpu;
  }
  public void setCpu(Cpu cpu) {
    this.cpu = cpu;
  }
  public GraphicCard getGraphicCard() {
    return graphicCard;
  }
  public void setGraphicCard(GraphicCard graphicCard) {
    this.graphicCard = graphicCard;
  }
  public MainBoard getMainBoard() {
    return mainBoard;
  }
  public void setMainBoard(MainBoard mainBoard) {
    this.mainBoard = mainBoard;
  }
  public Ram getRam() {
    return ram;
  }
  public void setRam(Ram ram) {
    this.ram = ram;
  }
  
  

}
