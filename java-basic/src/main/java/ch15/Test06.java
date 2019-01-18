// Object 클래스 : 주요 메서드 - hashCode()
package ch15;

class My6 /* extends Object */{
  String name;
  int age;
}

public class Test06 {
  public static void main(String[] args) {
    My6 obj1 = new My6();
    obj1.name = "홍길동";
    obj1.age = 20;

    My6 obj2 = new My6();
    obj2.name = "홍길동";
    obj2.age = 20;

    // Object에서 상속받은 hashCode()는 인스턴스마다 고유의 4byte정수값을 return
    // ==> 이값은 toString()의 출력 값으로 사용
    System.out.println(Integer.toHexString(obj1.hashCode()));
    System.out.println(Integer.toHexString(obj2.hashCode()));
    System.out.println(obj1);
    System.out.println(obj2);
    
    // hash value?
    // ==> 데이터를 다른 데이터와 구분하기 위해 사용되는 특별한 정수 값이다
    // ==> 특정 공식에 따라 값을 계산
    // ==> 데이터가 같은지 비교할 때 사용
    // ==> 즉 모든 데이터를 일일이 비교하는 대신 미리 생성된 정수값을 비교함으로써 
    //     빠르게 두 값이 같은지 알아낼 수 있다
    // ==> 단 데이터가 다르더라도 같은 정수 값이 나올 수 있다 낮은확률로
    // ==> 큰데이터를 특별한 계산 공식을 통해 4byte 정수 값으로 표현한다는 것은
    //     언제든 다른 데이터에 대해 같은 값이 나올 가능성을 내포하는 것
    //     다만 확률이 얼마나 낮은가의 문제이다
    //     즉, 다른 데이터에 대해 같은 정수 값이 나올 확률이 낮을수록 안심하고 사용
    //     주민등록번호와 비슷함 
    // 목적 :
    // 데이터가 같은지 빠르게 비교
    // 응용 : 
    // 인증서, 파일의 위변조 검사용도 : git commit할시 고유번호 를 붙이는데 이게 hash값
    // ex) git commit 할 때 고유번호를 붙이는데 바로 해시 값이다
    // ex) file download 사이트에서 제공하는 해시 값 (apache tomcat)
    // ex) 파일공유 사이트에서 파일을 구분할 때 해시 갑 사용
    //      사용자가  파일 이름을 변경하더라도 데이터만 바꾸지 않는다면 파일의 해시 값은 같다
    // 해시 알고리즘
    // ==> SHA, MD, PGP 등...
  }
}
