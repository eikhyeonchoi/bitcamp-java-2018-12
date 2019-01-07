// 배열 - 선언과 초기화 시키는 문법
package ch03; 

public class Test14 {
  public static void main(String[] args) {
    
    // 값을 담고 있는 메모리 ==> instance
    // instance 주소를 담고 있는 메모리 ==> reference
    int[] arr1 = {101,102,103,104,105};
    int[] arr2 = {81,82,83,84,85};
    
    arr2 = arr1;
    // arr2에 저장되었던 배열의 주소는 잃어버려 더 이상 그 배열을 사용할 수 없다
    // 이렇게 주소를 잃어 버려 사용할 수 없는 메모리를 garbage라고 부른다
    
    System.out.printf("%d, %d\n",arr1[1],arr2[1]);
    
    arr1[1]=500;
    // arr1이나 arr2는 모두 같은 배열 instance를 가리키기 때문에 값은 같다.
    System.out.printf("%d, %d\n",arr1[1],arr2[1]);
  }
}
/*
 * # garbage 
 * - 주소를 잃어 버려 사용할 수 없는 memory
 * - garbage는 특정 조건이 되면 garbage collector에 의해 memory 해제된다
 *    메모리 해제란? 다른 용도로 사용할 수 있도록 표시한다는 의미이다.
 *  
 * # garbage 수집 조건 = garbage collector 동작할 때
 * - 메모리가 부족할 때 
 *      운영체제로부터 메모리를 추가로 받기 전에 먼저 기존의 사용하던 메모리에
 *     garbage를 제거한다.
 * - CPU가 한가할 때
 *      계속 실행하는 서버 프로그램인 경우, 실행 중간에 cpu가 한가할 떼 garbage제거
 * - 주의
 *      JVM을 종료하면 JVM이 사용한 메모리를 OS가 모두 회수
 * 
 * # garbage를 강제로 지우도록 명령하는방법
 * - java에는 없음;
 * - 요즘 언어 트렌트는 사용하지 않는 메모리를 개발자가 해제하는 것이 아니라
 *      vm이 해제하는것 js, c# php swift java go
 * - 왜? 직접 기계어로 전환되면 메모리 관리를 자동으로 수행할 수 없다.
 *      
 * # garbage collector 강제로 실행
 * - 없다. 독촉은 가능. System.gc();
 * - 그런데 바로 실행할 지 나중에 실행할 지 그 시점을 보장하지는 x
 * 
 * # .close() 하는건 입출력메모리 빨리 빨리 반환해줘야 좋음
 * # garbage collector가 모으는것은 OS메모리
 */


