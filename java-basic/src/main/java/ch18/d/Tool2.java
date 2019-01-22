// 서브 인터페이스 구현 - 수퍼 인터페이스의 메서드까지 모두 구현해야 한다
package ch18.d;

// 수퍼 인터페이스가 있는 인터페이스를 구현할 대는
// 수퍼 인터페이스의 메서드까지 모두 구현해야함
public class Tool2 implements ProtocolC{
  // ProtocolA, ProtocolB 인터페이스 구현
  @Override public void m1() {}
  
  // ProtocolA 인터페이스 구현
  @Override public void m2() {}
  
  // ProtocolA2 인터페이스 구현
  @Override public void m3() {}
  
  // ProtocolB 인터페이스 구현
  @Override public void k1() {}
  
  // ProtocolB 인터페이스 구현
  @Override public void k2() {}
  
  // ProtocolC 인터페이스 구현
  @Override public void x() {}
  
  // ProtocolC 인터페이스 구현
  @Override public void y() {}

}
