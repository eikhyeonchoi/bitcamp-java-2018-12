package prac.computer;

import org.springframework.context.annotation.Bean;

public class AppConfig {
  
  @Bean
  public Cpu cpu() {
    Cpu c = new Cpu();
    c.setMaker("인텔");
    c.setPrice(500000);
    return c;
  }
  
  @Bean
  public GraphicCard graphicCard() {
    GraphicCard g = new GraphicCard();
    g.setMaker("조탁");
    g.setPrice(1200000);
    return g;
  }
  
  @Bean
  public MainBoard mainBoard() {
    MainBoard m = new MainBoard();
    m.setMaker("메인보드");
    m.setPrice(100000);
    return m;
  }
  
  @Bean
  public Ram ram() {
    Ram r = new Ram();
    r.setMaker("삼성");
    r.setPrice(80000);
    return r;
  }
  
  
  
  
  @Bean
  public Computer computer(Cpu cpu, GraphicCard graphicCard, MainBoard mainBoard, Ram ram) {
    return new Computer(cpu, graphicCard, mainBoard, ram);
  }

}
