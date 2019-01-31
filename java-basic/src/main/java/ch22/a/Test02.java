// java.io.File class : 파일 다루기
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test02 {
  public static void main(String[] args) throws IOException {
    // File 클래스
    // ==> 디렉토리나 파일을 다룰 때 사용하는 클래스
    // ==> 생성 삭제 변경

    // 존재하는 파일
    File file = new File("build.gradle");   
    System.out.println(file.getName()); // 파일명
    System.out.println(file.getPath()); // 경로
    System.out.println(file.getAbsolutePath()); // 절대경로
    System.out.println(file.getCanonicalPath()); // 계산된 경로
    
    // 파일이 존재하지 않는 경우 크기는 0
    System.out.println(file.getTotalSpace()); // HDD 전체용량
    System.out.println(file.getFreeSpace()); // 빈용량
    System.out.println(file.getUsableSpace()); // 빈용량 중 사용할 수 있는 용량
    System.out.println(file.length()); // 파일 크기
    
    // 파일이 존재하지 않는 경우 return 값은 false;
    System.out.println(file.isDirectory()); // 디렉토리 인지 아닌지
    System.out.println(file.isFile()); // 파일인지 아닌지
    System.out.println(file.isHidden()); // 숨김 여부
    System.out.println(file.exists()); // 존재여부
    System.out.println(file.canExecute()); // 실행 여부 들어갈 수 있는지 여부

    System.out.println("=========================================");
    
    file = new File("build.gradle2");   
    System.out.println(file.getName()); // 파일명
    System.out.println(file.getPath()); // 경로
    System.out.println(file.getAbsolutePath()); // 절대경로
    System.out.println(file.getCanonicalPath()); // 계산된 경로
    
    // 파일이 존재하지 않는 경우 크기는 0
    System.out.println(file.getTotalSpace()); // HDD 전체용량
    System.out.println(file.getFreeSpace()); // 빈용량
    System.out.println(file.getUsableSpace()); // 빈용량 중 사용할 수 있는 용량
    System.out.println(file.length());
    
    // 파일이 존재하지 않는 경우 return 값은 false;
    System.out.println(file.isDirectory()); // 디렉토리 인지 아닌지
    System.out.println(file.isFile()); // 파일인지 아닌지
    System.out.println(file.isHidden()); // 숨김 여부
    System.out.println(file.exists()); // 존재여부
    System.out.println(file.canExecute()); // 실행 여부 들어갈 수 있는지 여부
    
  }
}
