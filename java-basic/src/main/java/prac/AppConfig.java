package prac;
import org.springframework.context.annotation.Bean;

public class AppConfig {

  @Bean
  public Car car() {
    return new Car();
  }
  
  @Bean
  public Navigation navigation() {
    return new Navigation();
  }
}
