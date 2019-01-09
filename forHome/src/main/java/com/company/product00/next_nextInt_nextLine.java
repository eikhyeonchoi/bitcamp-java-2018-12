package com.company.product00;

public class next_nextInt_nextLine {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    //java.util 까지가 package
    //Scanner이 클래스
    //next(), nextLine(), nextInt()가 Scanner class의 methods;
    
    java.util.Scanner key = new java.util.Scanner(System.in);
    System.out.print("temp test string 1 :");
    String str1 = key.next();
    
    //key.nextLine();// 이걸 넣으면 첫token읽고 나머지 다버림;
    
    // 안넣고 token 2개이상 만들면 buffer에 저장됨(공백문자무시)
    // 만약 java  basic을 입력하면 str1에는 java가 저장되고 buffer에 아직 basic'LF'가 남음
    //그 후 print문 출력하고 str2에 따로 입력을 하지 않아도 buffer에 있던 basic이 저장되는것;
    
    System.out.print("temp test string 2 :");
    String str2 = key.next();
    
    // token의 원리는 공백문자를 무시하는거임
    // next()은 token개념에 기반해 동작함;
    // next()를 다 출력하려면 token만큼의 문자열 변수가 필요함;
    // nextLine()은 token개념이 아니라 그냥 다 읽어버림; 그냥 쭉읽어버림;
    
    System.out.printf("1. %s\n2. %s\n",str1 ,str2 );
    
    
    //패키지 클래스 메서드 사용법
    bitcamp temp = new bitcamp();
    int aa = temp.tempClass();
    System.out.println(aa);
    
  }
}

class bitcamp {
  public static void main() {
    
  }
  public int tempClass() {
    return 33;
  }
}
