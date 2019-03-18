package spring_base_prac.java.way1;
import org.springframework.context.annotation.Bean;

public class AppConfig {

  @Bean
  public Pizza pizza() {
    return new Pizza();
  }
  
  @Bean
  public Topping topping() {
    return new Topping();
  }
  
}
