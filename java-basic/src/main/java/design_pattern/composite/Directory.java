package design_pattern.composite;

import java.util.ArrayList;

public class Directory extends Node{
  
  // Composite 디자인 패턴:
  // ==> Tree구조로 전체-부분 관계의 객체를 표현할 때 사용한다
  // ==> 보통 조직도를 표현할 때 적합한 설계 기법이다
  // ==> os의 파일시스템도 이 설계기법으로 구현할 수 있다
  // 
  // 다음은 OS의 파일과 디렉토리 관계를 tree구조로 표현한 것이다
  
  ArrayList<Node> childs = new ArrayList<>();
  
  public Directory(String title) {
    this.title = title;
  }
  
  @Override
  public void getFileInfo() {
    System.out.printf("디렉토리명 : %s\n", this.title);
  }
  
  public void add(Node node) {
    childs.add(node);
  }

  public Node remove(int index) {
    return childs.remove(index);
  }
  
  public Node get(int index) {
    return childs.get(index);
  }
}
