package bitcamp.app2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
// import org.springframework.scheduling.annotation.EnableScheduling;

// @EnableScheduling
@Component
public class Task01 {

  @Scheduled(cron = "*/10 * * * * *")
  public void m1() {
    System.out.println("m1();");
  }
}
