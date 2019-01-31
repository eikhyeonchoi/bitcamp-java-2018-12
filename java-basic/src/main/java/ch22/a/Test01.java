// java.io.File class : 폴더 다루기
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test01 {
  public static void main(String[] args) throws IOException {
    // File 클래스
    // ==> 디렉토리나 파일을 다룰 때 사용하는 클래스
    // ==> 생성 삭제 변경

    // 현재 디렉토리 조회 
    // ==> '.' 으로 표현
    // ==> 이클립스 : 프로젝트 디렉토리를 가리킨다
    // ==> 콘솔 : 현재 명령어를 실행하는 위치를 가리킨다
    File dir = new File("./");   
    System.out.println(dir.getName()); // 폴더명
    System.out.println(dir.getPath()); // 경로
    System.out.println(dir.getAbsolutePath()); // 절대경로
    System.out.println(dir.getCanonicalPath()); // 계산된 경로
    
    // 디렉토리가 존재하지 않는 경우 크기는 0
    System.out.println(dir.getTotalSpace()); // HDD 전체용량
    System.out.println(dir.getFreeSpace()); // 빈용량
    System.out.println(dir.getUsableSpace()); // 빈용량 중 사용할 수 있는 용량
    System.out.println("=========================================");
    
    // 디렉토리가 존재하지 않는 경우 return 값은 false;
    System.out.println(dir.isDirectory()); // 디렉토리 인지 아닌지
    System.out.println(dir.isFile()); // 파일인지 아닌지
    System.out.println(dir.isHidden()); // 숨김 여부
    System.out.println(dir.exists()); // 존재여부
    System.out.println(dir.canExecute()); // 실행 여부 들어갈 수 있는지 여부

    
  }
}
