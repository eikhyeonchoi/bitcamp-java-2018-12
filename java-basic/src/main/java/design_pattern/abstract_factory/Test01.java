// 추상 팩토리 패턴 - 팩토리 객체를 추상화 시키는 방식, 다양한 팩토리로 대체할 수 있다
package design_pattern.abstract_factory;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    // 설계
    // UnitFactory 인터페이스 : 공장 객체의 사용 규칙 정의
    // AbstractUnitFactory 추상 클래스 : UnitFactory의 사용 규칙을 구현, 일부메서드는 template로
    // TerranUnitFactory 클래스 : UnitFactory 구현 클래스, 테란에 맞춰 유닛생성
    // ProtossUnitFactory 클래스 : UnitFactory 구현 클래스, 프토에 맞춰 유닛생성
    // ZergUnitFactory 클래스 : UnitFactory 구현 클래스, 저그에 맞춰 유닛생성

    Scanner keyboard = new Scanner(System.in);
    int type;
    do {
      System.out.print("종족 선택(1:T, 2:P, 3:Z) >> ");
      type = Integer.parseInt(keyboard.nextLine());
      if (type > 0 && type < 4) {
        break;
      }
      System.out.println("invalid command ...");
    } while(true);
    keyboard.close();
    UnitFactory unitFactory =null;

    switch(type) {
      case 1:
        System.out.println("Terran ...");
        unitFactory = new TerranUnitFactory();
        break;
      case 2:
        System.out.println("Protoss ...");
        unitFactory = new ProtossUnitFactory();
        break;
      default :
        System.out.println("Zerg ...");
        unitFactory = new ZergUnitFactory();
        break;
    }

    Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
    u1.build();
    Unit u2 = unitFactory.createUnit(UnitFactory.TRAINING_CENTER);
    u2.build();
    
  }
}
