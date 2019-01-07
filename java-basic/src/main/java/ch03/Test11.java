// 배열 - 선언 및 사용방법
package ch03; 

public class Test11 {
  public static void main(String[] args) {
    
    // 배열 문법을 사용하지않고 같은종류의 값을 여러 개의 값을 저장하는방법
    // ==> 저장할 값 개수 만큼 변수를 선언해야한다 다음과같이...
    int a1,a2,a3,a4,a5;
    a1=100;
    a2=90;
    a3=80;
    a4=70;
    a5=60;
    
    // 배열 문법을 이용해 같은 종류의 메모를 여러 개 만드는 방법.
    // #c언어 style
    // int arr2[5]; // c언어 style - 배열을 만들 때 갯수를 바로 지정
    
    // #java style
    // 1) 배열을 가리킬 reference 선언
    //   ==> reference란 메모리의 주소를 저장하는 변수이다.
    int[] arr1; // java style ==> 이 방식을 선호 이걸로 해야함
    int arr2[]; //c 언어 style도 사용가능하지만 위에 문법선호함
    
    // java에서는 로컬 변수(메서드 안에 선언된 변수)에 값을 저장하지 않고
    // 사용하려고 시도하면 compile error가 발생한다.
    // 배열을 만들지도 않고, reference를 사용하려면 오류;
    //arr1[0] = 100; //초기화 하지 않고 사용했기 때문에 error
    
    arr1 = null; // null? 0으로 설정한다. 주소가 특정 메모리를 가리키지 않는상태 표시
    //arr1[0] =100; //arr1을 사용하기 전에 초기화해서 compile error가 발생 x
                    // 그러나 없는 배열을 사용하려고 했기 때문에 nullPointerException
    
    
    // 2) 배열을 생성하고 그 주소를 reference에 담는다.
    //   ==> 생성된 배열을 '배열 인스턴스'라고 부른다.
    //    ==>변수에는 주소가 담기는것 '값'x돤
    arr1 = new int[5];
    arr2 = new int[5];
    
    // 3) 배열에 값을 담기 - 배열 reference를 사용해 메모리를 지정한다.
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    //arr1[-1] = 20; ArrayIndexOutOfBoundsException
    //arr1[5] = 110; ArrayIndexOutOfBoundsException
    
    
    
  }
}


/*
 * 
 * 
 * # 배열
 * - 같은 종류의 메모리를 여러 개 만드는 문법
 * 
 * # 배열 선언 
 * 메모리종류[] 레퍼런스변수명;
 * 레퍼런스변수명 = new 메모리종류[갯수];
 * 
 * dataType[] reference;
 * reference = new dataType[갯수];
 * 
 * ex) int 메모리를 5개 선언
 * int[] values;
 * values = new int[5];
 * 
 * 
 * 
 * 
 * 
 * 
 */


