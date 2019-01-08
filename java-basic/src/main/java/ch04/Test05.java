//연산자 우선순위
package ch04;
 
public class Test05 {
  public static void main(String[] args) {

    float r = 3.2f + 5 / 2;
    System.out.println(r);
    // 연산자 우선순위에 따라 *, /, %, 연산자가 +, -연산자 보다 먼저 계산
    // => 계산순서
    // 3.2f(float) + 5(int) / 2(int)
    // 3.2f(float) + 2(int)
    // 3.2f(float) + 2.0f(float)
    // 5.2f(float)
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2);
    // 연산자 우선 순위에서 괄호가 모든 연산자 보다 우선으로 취급된다
    // 3.2f(float) + 5.0f(float) / 2(int)
    // 8.2f(float) / 2.0f(float)
    // 4.1f(float)
    
    int a = 2; //마지막 = 5
    int r3 = a++ + a++ * a++;
    // r3 = 2 + 3 * 4  <== ++연산을 먼저 수행한다.
    //     = 2 + 12 <== *연산
    //     = 14  <== 마지막으로 +
    System.out.println(r3);
  }
}
/*
 *# 연산자 우선순위
 *괄호 : ()
 *후위 연산자 : (a++, --)
 *전위 연산자 : (++a, --a), 단항 연산자 : (+, -)
 *곱하기 나누기(/, %)
 *더하기 빼기
 *비트이동연산자 : <<, >>, >>>
 *관계연산자 : (<, > ,<= ,>=, instance of)
 *등위 연산자 : (==, !=)
 *&
 *^
 *|
 *논리 연산자 and : &&
 *논리 연산자 or : ||
 *삼항 연산자 : (조건) ? 값 : 값
 *할당 연산자 : ( = ,+= ,-= ,/= ,%= ,&= ,^=, |=, <<=, >>=, >>>=)
 *      s
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
