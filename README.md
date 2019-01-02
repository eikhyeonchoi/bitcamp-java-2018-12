# bitcamp-java-2018-12
비트캠프(강남센터) 자바반 - UIUX 엔지니어링 및 응용 S/W 엔지니어링 양성과정
1. 파티션 분할 + linux용 ubuntu usb 준비

2. 멀티부팅으로 ubuntu 설치

3. JRE 설치

4. OpenJDK 11 설치

5. 
Eclipse IDE 도구 설치 및 설정
    - 에디터
        - 탭 대신 스페이스로 처리 2칸으로 바꿈
        - 한 줄 당 글자 수: 100자 안내선  
        - 공백 문자를 흐릿하게 표시 80
    - 워크스페이스 
        - 문자집합 : UTF-8
    - Java / JRE 
        - OpenJDK 11 버전으로 설정
        - 단, 회사에서 JDK8을 사용한다면 8로 설정하라.
    - Web
        - HTML, CSS, JSP 문자집합: UTF-8 
    - java code style guild 설치
        - google java style guide 검색한 후 github 링크 클릭
        - eclipse-java-google-style.xml을 다운로드 받아 설치한다.
        - java -> codestyle ->formatter->import-> xml import
- gradle 빌드 도구 설치
    - apt-get 기본 저장소에는 gradle 최신 버전이 없다.
    - 그래서 최신 버전을 갖고 있는 저장소를 추가해야 한다.
    - apt-get 저장소 추가:
    - $ sudo add-apt-repository ppa:cwchien/gradle
    - 설치: $ sudo apt-get install gradle
    

6.
일반 프로젝트 폴더를 이클립스 프로젝트 폴더로 만들기
    - 이클립스 IDE가 사용할 설정 파일과 디렉토리가 있어야 한다.
    - 예).project, .classpath, .settings/
    - Gradle 빌드 도구를 사용하여 이클립스 프로젝트와 관련된 파일을 자동 생성한다.
    - 절차
        - 1) 프로젝트 디렉토리 생성
        - 2) gradle 초기화 수행 : 프로젝트 폴더에 기본 파일 및 디렉토리 생성
            - $ gradle init --type java-application
        - 3) gradle 빌드 스크립트 파일(build.gradle)에 eclipse 플러그인 추가 
            - id 'eclipse' 추가
        - 4) 이클립스 설정 파일 생성
            - $ gradle eclipse
        - 5) 이클립스로 import 



*****git

git 서버 업로드
    - 1) 관리 명단에 등록: 
        - bitcamp-java-2018-12$ git add .
    - 2) 명단에 등록된 파일 및 디렉토리 백업: 
        - bitcamp-java-2018-12$ git commit -m "메시지"
    - 3) 깃 서버에 업로드: 
        - bitcamp-java-2018-12$ git push 
- git 저장소 복제
    - git$ git clone https://github.com/아이디/저장소.git
    - git$ git clone https://github.com/아이디/저장소.git 다른디렉토리명