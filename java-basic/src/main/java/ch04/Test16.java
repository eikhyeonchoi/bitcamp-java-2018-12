// 비트 이동 연산자3  >>, >>>, <<
package ch04;
 
public class Test16 {
  public static void main(String[] args) {
    
    // << 연산자
    // => 왼쪽으로 비트이동, 오른쪽 빈자리는 무조건 0으로채운다. 경계를 넘어가는 값은 버림
    int a = 0xc9; // = 201
    System.out.println("hex : " + Integer.toHexString(a << 1));
    System.out.println(a << 1);
    
    System.out.println("hex : " + Integer.toHexString(a << 2));
    System.out.println(a << 2);
    System.out.println();

    // 왼쪽 비트이동의 효과 
    // ==> 1비트 이동할 때마다 2로 곱하는 효과가 있다
    // ex) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x
    // ==> 곱하기 연산을 수행하는 것 보다 계산 속도가 빠르다
    
    
    //음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동
    // 0111 1111 1111 1111 1111 1111 1111 1010 = 21 4748 3642
    // 1000 0000 0000 0000 0000 0000 0000 0110 = - 21 4748 3642
    // 1비트이동하면
    // 0000 0000 0000 0000 0000 0000 000 1100 = 12
    a = -0x7f_ff_ff_fa;
    System.out.println(a);
    System.out.println(a<<1);
    System.out.println(a<<2);
    System.out.println(a<<3);
    System.out.println(a<<4);
    // 결론!
    // 왼쪽으로 x만큼 비트이동시키는것은
    // 주어진 값을 2**x로 곱한것 과 같다.
    // 음수의 경우는 양수로 바뀔 수 도 있다.
  }
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 */
