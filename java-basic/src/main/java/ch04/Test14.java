// 비트 이동 연산자 >>, >>>, <<
package ch04;
 
public class Test14 {
  public static void main(String[] args) {
    
    // >> : 오른쪽으로 비트이동, 왼쪽 빈자리는 부호비트로 채운다, 경계를 넘어가는 값은 버림
    int a = 0xca; // = 202
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 4));
    System.out.println(a >> 4);
    // 00000000_00000000_0000000_11001010 => ca
    //     0000_00000000_0000000_00001100 ; 1010 =>0xc
    // 00000000_00000000_0000000_00001100 ; 1010 => 0xc =12
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 3));
    System.out.println(a >> 3);
    // 00000000_00000000_0000000_11001010 => ca
    //    00000_00000000_0000000_000011001 ; 010 => 0x19
    // 00000000_00000000_00000000_00011101 ; 010 => 0x19 =25
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 2));
    System.out.println(a >> 2);
    // 00000000_00000000_0000000_11001010 => ca
    //   00000_00000000_0000000_00110010 ; 10 => 0x32
    // 00000000_00000000_00000000_00111010 ; 10 => 0x32 = 50
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(a >> 1));
    System.out.println(a >> 1);
    // 00000000_00000000_0000000_11001010 => ca
    //   000000_00000000_0000000_01100101 ; 0 => 0x65
    // 00000000_00000000_00000000_01110101 ; 0 => 0x65 = 101
    
    // 오른쪽 비트이동의 효과 
    // ==> 1비트 이동할 때마다 2로 나누는 효과가 있다
    // ex) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x
    // ==> 나누기 연산을 수행하는 것 보다 계산 속도가 빠르다
    
    // 음수의 이동
    // 음수 값에 대해 오른쪽으로 비트이동
    // => 2**n(비트)로 나눈 것과 같다, 소수점 이하를 반올림 한 결과
    // => 왼쪽 빈자리가 부호비트(1)로 채워진다
    a = -202; // 11111111_11111111_11111111_00110110 ==> 0xff_ff_ff_36
    System.out.println(a>>1); // -202 / 2**1 = -101
              // 11111111_11111111_11111111_10011011 ; 0 ==>빈자리는 부호비트로
            // = 0xffffff9b =-101
    System.out.println(a>>2); // = -202 / 2**2 = -51
    System.out.println(a>>3); // = -202 / 2**3 = -26
    System.out.println(a>>4); // = -202 / 2**4 = -13
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
