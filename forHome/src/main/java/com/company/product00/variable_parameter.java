package com.company.product00;

public class variable_parameter {

  public static void main(String[] args) {

    String[] s = new String[] {"a","b","c","d","f"};
    view1(s);
    System.out.println();
    
    view1("g","h","i","j","k");
    System.out.println();
    
    view2(new String[] {"비트캠프","엄진영교수님","java"});
    

  }

  // # 가변 파라미터 review
  // 1) 인덱스를 조절할 수 없고 처음부터 끝까지 출력
  // 2) 파라미터 한개만 선언가능
  // 3) 맨끝에만 선언가능
  static void view1(String...strings) {
    for (String content : strings) {
      System.out.println(content);
    }
  }
  
  // # 레퍼런스
  // 1) 인덱스를 조절가능하다
  // 2) 파라미터를 여러개 선언할 수 있다
  // 3) 위치상관없이 어디든 가능하다
  static void view2(String[] args) {
    for (int i = 0 ; i < args.length; i++) {
      System.out.println(args[i]);
    }
  }
  
}
