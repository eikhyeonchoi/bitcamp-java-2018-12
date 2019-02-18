// 스레드 그룹의 부모 스레드 그룹
package ch24.b;

public class Test05 {
  public static void main(String[] args) {

    // 스레드 그룹이 소속된 상위 스레드 그룹을 알아내기
    Thread currentThread = Thread.currentThread();
    ThreadGroup group = currentThread.getThreadGroup();
    ThreadGroup parentGroup = group.getParent();
    
    // "main"스레드 그룹의 부모 스레드 그룹은?
    System.out.println(parentGroup.getName() + "(TG)");
    
    // "system"스레드 그룹의 부모 스레드 그룹은? == null
    ThreadGroup parentParentGroup = parentGroup.getParent();
    System.out.println(parentParentGroup); // system이 최상위 스레드그룹임

  } // main 
} // end of class


// JVM의 스레드 계층도 : 
// system(TG)
// => main(TG)
//    => main(T)