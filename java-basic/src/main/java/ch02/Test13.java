//콘솔로 출력하기3 - 형식을 갖춰 날짜값 출력
package ch02;
public class Test13 {
  public static void main(String[] args) {

    // 현재 날짜및 시각정보를 생성
    // java.lang package의 멤버를 사용할땐(class, interface) 그냥 이름을 지정;
    // 그 외 다른 package의 멤버를 사용할 때는 반드시 package 이름을 함께 지정해야함;
    java.util.Date today =new java.util.Date();
    
    // %t[날짜 및 시각 옵션]
    // 날짜 및 시각 옵션
    // Y : 년도추출(4자리)
    // y : 년도추출(2자리)
    System.out.printf("%1$tY %1$ty\n", today);
    
    // B : 월을추출(전체이름)
    // b : 월을추출(단축이름)  ==>한국은 월밖에없음;
    System.out.printf("%1$tB %1$tb\n", today);
    
    // m : 월을추출(두자리숫자)
    System.out.printf("%1$tm\n", today);
    
    // d : 일을추출(두자리숫자)
    // e : 일을추출(한자리숫자)
    System.out.printf("%1$td %1$te\n ", today);
    
    // A : 요일추출(긴이름) - 금요일
    // a : 요일추출(짧은이름) - 금
    System.out.printf("%1$tA %1$ta\n", today);
    
    // H : 시각 '시' 추출(24시형식)
    // I : 시각추출(12시형식) 
    System.out.printf("%1$tH %1$tI\n", today);
    
    // M : 시각 '분' 추출
    System.out.printf("%1$tM\n", today);
    
    // S : 시각 '초' 추출
    // L : '밀리초'
    // N : '나노초'
    System.out.printf("%1$tS %1$tL %1$tN\n", today);
    
    // p : 오전인지 오후인지 
    //      소문자 t  = am pm
    //      대문자 T  = AM PM
    System.out.printf("%1$tp\n",today);
    System.out.printf("%1$tY-%1$tm-%1$td %1$tp %1$tH:%1$tM:%1$tS\n", today);
  }
}

/*
 * 
 */
