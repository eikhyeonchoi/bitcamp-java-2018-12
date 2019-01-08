// 비트 이동 연산자2  >>, >>>, <<
package ch04;
 
public class Test15 {
  public static void main(String[] args) {
    
    // >>> 연산자
    // => 오른쪽으로 비트이동, 왼쪽 빈자리는 무조건 0으로채운다. 경계를 넘어가는 값은 버림
    int a = 0xca; // = 202
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 4));
    System.out.println(a >>> 4);
    // 00000000_00000000_0000000_11001010 => ca
    //     0000_00000000_0000000_00001100 ; 1010 =>0xc
    // 00000000_00000000_0000000_00001100 ; 1010 => 0xc =12
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 3));
    System.out.println(a >>> 3);
    // 00000000_00000000_0000000_11001010 => ca
    //    00000_00000000_0000000_000011001 ; 010 => 0x19
    // 00000000_00000000_00000000_00011101 ; 010 => 0x19 =25
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 2));
    System.out.println(a >>> 2);
    // 00000000_00000000_0000000_11001010 => ca
    //   00000_00000000_0000000_00110010 ; 10 => 0x32
    // 00000000_00000000_00000000_00111010 ; 10 => 0x32 = 50
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 1));
    System.out.println(a >>> 1);
    // 00000000_00000000_0000000_11001010 => ca
    //   000000_00000000_0000000_01100101 ; 0 => 0x65
    // 00000000_00000000_00000000_01110101 ; 0 => 0x65 = 101
    
    // 오른쪽 비트이동의 효과 
    // ==> 1비트 이동할 때마다 2로 나누는 효과가 있다
    // ex) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x
    // ==> 나누기 연산을 수행하는 것 보다 계산 속도가 빠르다
    
    // 음수의 이동
    // 음수 값에 대해 오른쪽으로 비트이동할때 빈자리가 0으로 채워지므로 거대한 큰 양수가 된다
    a = -202; // 11111111_11111111_11111111_00110110 ==> 0xff_ff_ff_36
    System.out.println(a>>>1);
              // 01111111_11111111_11111111_10011011 ; 0 ==>빈자리는 0으로
            // = 0x7fffff9b 
    System.out.println(a>>>2);
    System.out.println(a>>>3);
    System.out.println(a>>>4);
    System.out.println(Integer.MAX_VALUE);
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
