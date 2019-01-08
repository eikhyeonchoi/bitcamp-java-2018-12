// 비트 연산자 : &, |, ^, ~
// 용도?
// 이미지 프로세싱 분야 (영상처리)
package ch04;
 
public class Test13 {
  public static void main(String[] args) {
    
    // & ==> 두 비트가 모두 1일때만 1
    // | ==> 두 비트중 한비트라도 1이면 1
    // ^ ==> 다르면 1 같으면 0
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    // 1100 1010
    // 0110 0110
    
    System.out.println(a & b);
    // & = and  => 0100 0010
    System.out.println(a | b);
    // | = or => 1110 1110
    System.out.println(a ^ b);
    // ^ = xor => 1010 1100
    System.out.println(~a);
    System.out.println(~b);
    // ~ = not => a = 1111 1111 1111 1111 1111 1111 0011 0101,
    //            b = 1111 1111 1111 1111 1111 1111 1001 1001
    
    
    // & 활용 : 특정 값을 차단하고 특정 값만 통과
    int data = 0b1111_1001_0111_1111;
    System.out.println(Integer.toBinaryString(data & 0b0000_1111_1100_0000));
    
    // 예) 그림의 한 픽셀에서 빨강 색을 제거하고싶다
    int p = 0x003f4478; // 각바이트의 값이 00RRGGBB라 가정
    System.out.println(Integer.toBinaryString(p & 0x0000ffff));
    // piexel = 0000 0000 0011 1111 0100 0100 0111 1000
    // mask   = 0000 0000 0000 0000 1111 1111 1111 1111
    // res    = 0000 0000 0000 0000 0100 0100 0111 1000
    
    // | 활용 : 특정 색 강화할 수 있음
    System.out.println(Integer.toBinaryString(p & 0x00000057));
    // piexel = 0000 0000 0011 1111 0100 0100 0111 1000
    // mask   = 0000 0000 0000 0000 0000 0000 0101 0111
    // res    = 0000 0000 0011 1111 0100 0100 0111 1111;
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
