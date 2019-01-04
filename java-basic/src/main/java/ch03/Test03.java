// 계산 결과는 그 변수의 타입과 같다;
package ch03;

public class Test03 {
  public static void main(String[] args) {
    
    int a = 5;
    int b = 2;
    int c = 5/2;
    System.out.println(a/b); //int와 int의 계산결과는 int;
    
    float f1 = 9876.543f;
    float f2 = 12.34567f;
    System.out.println(f1);
    System.out.println(f2);
    System.out.println(f1+f2); //float과 float의 계산결과는 float
    //따라서 계산결과가 4byte float의 크기를 넘어가면 적절히 반올림하여 나머지값을 버림;
    
    double d1 = 9876.543;
    double d2 = 12.34567;
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d1+d2); //double과 double의 계산결과는 double

    // 그래서 보통 부동소수점을 다룰 때는 double을 주로 사용
    // java는 double 부동소수점의 리터럴을 다룰 때 접미사를 붙이지 않는다
    // java는 4byte 정수 리터럴을 많이 사용하기 때문에 4byte 정수 리터럴에 접미사x
    
    
  }
}

