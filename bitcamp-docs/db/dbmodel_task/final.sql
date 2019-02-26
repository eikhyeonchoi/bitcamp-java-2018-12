-- 프로젝트
DROP TABLE IF EXISTS proj RESTRICT;

-- 매니저
DROP TABLE IF EXISTS mng RESTRICT;

-- 참여자
DROP TABLE IF EXISTS parti RESTRICT;

-- 게시글
DROP TABLE IF EXISTS post RESTRICT;

-- 사용자_프로젝트
DROP TABLE IF EXISTS user_proj RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS attch_file RESTRICT;

-- 주소
DROP TABLE IF EXISTS addr RESTRICT;

-- 게시글댓글
DROP TABLE IF EXISTS cmnt RESTRICT;

-- 주최기업
DROP TABLE IF EXISTS comp RESTRICT;

-- 툴
DROP TABLE IF EXISTS tool RESTRICT;

-- 프로젝트_툴
DROP TABLE IF EXISTS proj_tool RESTRICT;

-- 개발장소
DROP TABLE IF EXISTS loc RESTRICT;

-- 참여자유형
DROP TABLE IF EXISTS user_type RESTRICT;

-- 분류
DROP TABLE IF EXISTS classfi RESTRICT;

-- 게시글_분류
DROP TABLE IF EXISTS post_classfi RESTRICT;

-- 학력
DROP TABLE IF EXISTS grade RESTRICT;

-- 작업
DROP TABLE IF EXISTS work RESTRICT;

-- 유저
DROP TABLE IF EXISTS user RESTRICT;

-- 프로젝트
CREATE TABLE proj (
  proj_id    INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  com_id     INTEGER     NOT NULL COMMENT '주최기업번호', -- 주최기업번호
  loc_id     INTEGER     NOT NULL COMMENT '개발장소번호', -- 개발장소번호
  titl       VARCHAR(30) NOT NULL COMMENT '제목', -- 제목
  cont       TEXT        NOT NULL COMMENT '내용', -- 내용
  tot_people INTEGER     NULL     COMMENT '참여인원수', -- 참여인원수
  id         INTEGER     NULL     COMMENT '매니저번호' -- 매니저번호
)
COMMENT '프로젝트';

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT PK_proj -- 프로젝트 기본키
    PRIMARY KEY (
      proj_id -- 프로젝트번호
    );

ALTER TABLE proj
  MODIFY COLUMN proj_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트번호';

-- 매니저
CREATE TABLE mng (
  id     INTEGER     NOT NULL COMMENT '매니저번호', -- 매니저번호
  com_id INTEGER     NOT NULL COMMENT '주최기업번호', -- 주최기업번호
  tel    VARCHAR(30) NULL     COMMENT '팩스', -- 팩스
  name   VARCHAR(50) NULL     COMMENT '직위' -- 직위
)
COMMENT '매니저';

-- 매니저
ALTER TABLE mng
  ADD CONSTRAINT PK_mng -- 매니저 기본키
    PRIMARY KEY (
      id -- 매니저번호
    );

-- 매니저 유니크 인덱스
CREATE UNIQUE INDEX UIX_mng
  ON mng ( -- 매니저
  );

-- 참여자
CREATE TABLE parti (
  id       INTEGER      NOT NULL COMMENT '유저번호', -- 유저번호
  det_adrr VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  acc      VARCHAR(40)  NOT NULL COMMENT '계좌번호', -- 계좌번호
  phot     VARCHAR(255) NULL     COMMENT '사진', -- 사진
  addr_id  INTEGER      NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '참여자';

-- 참여자
ALTER TABLE parti
  ADD CONSTRAINT PK_parti -- 참여자 기본키
    PRIMARY KEY (
      id -- 유저번호
    );

-- 참여자 유니크 인덱스
CREATE UNIQUE INDEX UIX_parti
  ON parti ( -- 참여자
  );

-- 게시글
CREATE TABLE post (
  post_id INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  proj_id INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  cont    TEXT        NOT NULL COMMENT '내용', -- 내용
  cdt     DATETIME    NOT NULL COMMENT '등록일시', -- 등록일시
  mdt     DATETIME    NOT NULL COMMENT '수정일시', -- 수정일시
  mdt_id  VARCHAR(30) NOT NULL COMMENT '수정팀원아이디', -- 수정팀원아이디
  vw_cnt  INTEGER     NULL     COMMENT '조회수', -- 조회수
  id      INTEGER     NULL     COMMENT '유저번호' -- 유저번호
)
COMMENT '게시글';

-- 게시글
ALTER TABLE post
  ADD CONSTRAINT PK_post -- 게시글 기본키
    PRIMARY KEY (
      post_id -- 게시글번호
    );

ALTER TABLE post
  MODIFY COLUMN post_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 사용자_프로젝트
CREATE TABLE user_proj (
  proj_id INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  id      INTEGER     NOT NULL COMMENT '유저번호', -- 유저번호
  role    VARCHAR(20) NOT NULL COMMENT '역할', -- 역할
  contrib INTEGER     NULL     COMMENT '기여도' -- 기여도
)
COMMENT '사용자_프로젝트';

-- 사용자_프로젝트
ALTER TABLE user_proj
  ADD CONSTRAINT PK_user_proj -- 사용자_프로젝트 기본키
    PRIMARY KEY (
      proj_id, -- 프로젝트번호
      id       -- 유저번호
    );

-- 첨부파일
CREATE TABLE attch_file (
  attch_file_id INTEGER      NOT NULL COMMENT '첨부파일번호', -- 첨부파일번호
  post_id       INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
  name          VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  cdt           DATETIME     NOT NULL COMMENT '등록일시', -- 등록일시
  root          VARCHAR(255) NULL     COMMENT '경로', -- 경로
  size          VARCHAR(10)  NULL     COMMENT '사이즈' -- 사이즈
)
COMMENT '첨부파일';

-- 첨부파일
ALTER TABLE attch_file
  ADD CONSTRAINT PK_attch_file -- 첨부파일 기본키
    PRIMARY KEY (
      attch_file_id -- 첨부파일번호
    );

ALTER TABLE attch_file
  MODIFY COLUMN attch_file_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '첨부파일번호';

-- 주소
CREATE TABLE addr (
  addr_id  INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
  post_no  CHAR(5)      NOT NULL COMMENT '우편번호', -- 우편번호
  bas_addr VARCHAR(255) NOT NULL COMMENT '기본주소' -- 기본주소
)
COMMENT '주소';

-- 주소
ALTER TABLE addr
  ADD CONSTRAINT PK_addr -- 주소 기본키
    PRIMARY KEY (
      addr_id -- 주소번호
    );

ALTER TABLE addr
  MODIFY COLUMN addr_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- 게시글댓글
CREATE TABLE cmnt (
  cmnt_id INTEGER      NOT NULL COMMENT '댓글번호', -- 댓글번호
  ip_addr VARCHAR(255) NULL     COMMENT 'IP주소', -- IP주소
  post_id INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
  cont    TEXT         NOT NULL COMMENT '내용', -- 내용
  rdt     DATETIME     NOT NULL COMMENT '등록일시', -- 등록일시
  id      INTEGER      NULL     COMMENT '유저번호' -- 유저번호
)
COMMENT '게시글댓글';

-- 게시글댓글
ALTER TABLE cmnt
  ADD CONSTRAINT PK_cmnt -- 게시글댓글 기본키
    PRIMARY KEY (
      cmnt_id -- 댓글번호
    );

-- 게시글댓글 유니크 인덱스
CREATE UNIQUE INDEX UIX_cmnt
  ON cmnt ( -- 게시글댓글
    ip_addr ASC -- IP주소
  );

ALTER TABLE cmnt
  MODIFY COLUMN cmnt_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 주최기업
CREATE TABLE comp (
  com_id    INTEGER     NOT NULL COMMENT '주최기업번호', -- 주최기업번호
  comp_name VARCHAR(50) NOT NULL COMMENT '주최기업이름', -- 주최기업이름
  aid       INTEGER     NOT NULL COMMENT '지원금', -- 지원금
  cdt       DATETIME    NULL     COMMENT '주최일시', -- 주최일시
  region    VARCHAR(50) NOT NULL COMMENT '주최지역', -- 주최지역
  prize     INTEGER     NOT NULL COMMENT '프로그램매입비용(상금)' -- 프로그램매입비용(상금)
)
COMMENT '주최기업';

-- 주최기업
ALTER TABLE comp
  ADD CONSTRAINT PK_comp -- 주최기업 기본키
    PRIMARY KEY (
      com_id -- 주최기업번호
    );

ALTER TABLE comp
  MODIFY COLUMN com_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '주최기업번호';

-- 툴
CREATE TABLE tool (
  tool_id   INTEGER     NOT NULL COMMENT '툴번호', -- 툴번호
  tool_name VARCHAR(50) NOT NULL COMMENT '툴이름', -- 툴이름
  cost      INTEGER     NOT NULL COMMENT '사용비용', -- 사용비용
  dev_comp  VARCHAR(50) NULL     COMMENT '개발회사' -- 개발회사
)
COMMENT '툴';

-- 툴
ALTER TABLE tool
  ADD CONSTRAINT PK_tool -- 툴 기본키
    PRIMARY KEY (
      tool_id -- 툴번호
    );

ALTER TABLE tool
  MODIFY COLUMN tool_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '툴번호';

-- 프로젝트_툴
CREATE TABLE proj_tool (
  tool_id INTEGER NOT NULL COMMENT '툴번호', -- 툴번호
  proj_id INTEGER NOT NULL COMMENT '프로젝트번호' -- 프로젝트번호
)
COMMENT '프로젝트_툴';

-- 프로젝트_툴
ALTER TABLE proj_tool
  ADD CONSTRAINT PK_proj_tool -- 프로젝트_툴 기본키
    PRIMARY KEY (
      tool_id, -- 툴번호
      proj_id  -- 프로젝트번호
    );

-- 개발장소
CREATE TABLE loc (
  loc_id   INTEGER     NOT NULL COMMENT '개발장소번호', -- 개발장소번호
  loc_name VARCHAR(50) NOT NULL COMMENT '개발장소명', -- 개발장소명
  cpty     INTEGER     NOT NULL COMMENT '최대수용인원' -- 최대수용인원
)
COMMENT '개발장소';

-- 개발장소
ALTER TABLE loc
  ADD CONSTRAINT PK_loc -- 개발장소 기본키
    PRIMARY KEY (
      loc_id -- 개발장소번호
    );

ALTER TABLE loc
  MODIFY COLUMN loc_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '개발장소번호';

-- 참여자유형
CREATE TABLE user_type (
  user_type_id INTEGER     NOT NULL COMMENT '유형번호', -- 유형번호
  grade_id     INTEGER     NOT NULL COMMENT '학력번호', -- 학력번호
  age          INTEGER     NOT NULL COMMENT '연령', -- 연령
  major        VARCHAR(20) NULL     COMMENT '전공명', -- 전공명
  job          VARCHAR(30) NULL     COMMENT '직업', -- 직업
  chld         BOOLEAN     NULL     COMMENT '자녀여부', -- 자녀여부
  id           INTEGER     NULL     COMMENT '유저번호' -- 유저번호
)
COMMENT '참여자유형';

-- 참여자유형
ALTER TABLE user_type
  ADD CONSTRAINT PK_user_type -- 참여자유형 기본키
    PRIMARY KEY (
      user_type_id -- 유형번호
    );

ALTER TABLE user_type
  MODIFY COLUMN user_type_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '유형번호';

-- 분류
CREATE TABLE classfi (
  classfi_id INTEGER NOT NULL COMMENT '분류번호', -- 분류번호
  cont       TEXT    NULL     COMMENT '분류설명' -- 분류설명
)
COMMENT '분류';

-- 분류
ALTER TABLE classfi
  ADD CONSTRAINT PK_classfi -- 분류 기본키
    PRIMARY KEY (
      classfi_id -- 분류번호
    );

ALTER TABLE classfi
  MODIFY COLUMN classfi_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '분류번호';

-- 게시글_분류
CREATE TABLE post_classfi (
  post_id    INTEGER NOT NULL COMMENT '게시글번호', -- 게시글번호
  classfi_id INTEGER NOT NULL COMMENT '분류번호' -- 분류번호
)
COMMENT '게시글_분류';

-- 게시글_분류
ALTER TABLE post_classfi
  ADD CONSTRAINT PK_post_classfi -- 게시글_분류 기본키
    PRIMARY KEY (
      post_id,    -- 게시글번호
      classfi_id  -- 분류번호
    );

-- 학력
CREATE TABLE grade (
  grade_id   INTEGER     NOT NULL COMMENT '학력번호', -- 학력번호
  grade_name VARCHAR(50) NOT NULL COMMENT '학력명' -- 학력명
)
COMMENT '학력';

-- 학력
ALTER TABLE grade
  ADD CONSTRAINT PK_grade -- 학력 기본키
    PRIMARY KEY (
      grade_id -- 학력번호
    );

ALTER TABLE grade
  MODIFY COLUMN grade_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '학력번호';

-- 작업
CREATE TABLE work (
  work_id INTEGER     NOT NULL COMMENT '작업번호', -- 작업번호
  proj_id INTEGER     NOT NULL COMMENT '프로젝트번호', -- 프로젝트번호
  leader  VARCHAR(50) NOT NULL COMMENT '팀장', -- 팀장
  memb    VARCHAR(50) NOT NULL COMMENT '구성원', -- 구성원
  sdt     DATETIME    NOT NULL COMMENT '시작일', -- 시작일
  edt     DATETIME    NOT NULL COMMENT '종료일', -- 종료일
  tot_hr  INTEGER     NULL     COMMENT '총작업시간', -- 총작업시간
  day_hr  INTEGER     NULL     COMMENT '일작업시간', -- 일작업시간
  cal     TEXT        NULL     COMMENT '일정', -- 일정
  prog    INTEGER     NULL     COMMENT '진행률' -- 진행률
)
COMMENT '작업';

-- 작업
ALTER TABLE work
  ADD CONSTRAINT PK_work -- 작업 기본키
    PRIMARY KEY (
      work_id -- 작업번호
    );

ALTER TABLE work
  MODIFY COLUMN work_id INTEGER NOT NULL AUTO_INCREMENT COMMENT '작업번호';

-- 유저
CREATE TABLE user (
  id    INTEGER      NOT NULL COMMENT '유저번호', -- 유저번호
  name  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  id    VARCHAR(30)  NOT NULL COMMENT '아이디', -- 아이디
  pwd   VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  tel   VARCHAR(30)  NOT NULL COMMENT '핸드폰번호', -- 핸드폰번호
  nic   VARCHAR(30)  NULL     COMMENT '닉네임', -- 닉네임
  email VARCHAR(40)  NULL     COMMENT '이메일' -- 이메일
)
COMMENT '유저';

-- 유저
ALTER TABLE user
  ADD CONSTRAINT PK_user -- 유저 기본키
    PRIMARY KEY (
      id -- 유저번호
    );

-- 유저 유니크 인덱스
CREATE UNIQUE INDEX UIX_user
  ON user ( -- 유저
    email ASC -- 이메일
  );

ALTER TABLE user
  MODIFY COLUMN id INTEGER NOT NULL AUTO_INCREMENT COMMENT '유저번호';

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT FK_mng_TO_proj -- 매니저 -> 프로젝트
    FOREIGN KEY (
      id -- 매니저번호
    )
    REFERENCES mng ( -- 매니저
      id -- 매니저번호
    );

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT FK_comp_TO_proj -- 주최기업 -> 프로젝트
    FOREIGN KEY (
      com_id -- 주최기업번호
    )
    REFERENCES comp ( -- 주최기업
      com_id -- 주최기업번호
    );

-- 프로젝트
ALTER TABLE proj
  ADD CONSTRAINT FK_loc_TO_proj -- 개발장소 -> 프로젝트
    FOREIGN KEY (
      loc_id -- 개발장소번호
    )
    REFERENCES loc ( -- 개발장소
      loc_id -- 개발장소번호
    );

-- 매니저
ALTER TABLE mng
  ADD CONSTRAINT FK_comp_TO_mng -- 주최기업 -> 매니저
    FOREIGN KEY (
      com_id -- 주최기업번호
    )
    REFERENCES comp ( -- 주최기업
      com_id -- 주최기업번호
    );

-- 매니저
ALTER TABLE mng
  ADD CONSTRAINT FK_user_TO_mng -- 유저 -> 매니저
    FOREIGN KEY (
      id -- 매니저번호
    )
    REFERENCES user ( -- 유저
      id -- 유저번호
    );

-- 참여자
ALTER TABLE parti
  ADD CONSTRAINT FK_addr_TO_parti -- 주소 -> 참여자
    FOREIGN KEY (
      addr_id -- 주소번호
    )
    REFERENCES addr ( -- 주소
      addr_id -- 주소번호
    );

-- 참여자
ALTER TABLE parti
  ADD CONSTRAINT FK_user_TO_parti -- 유저 -> 참여자
    FOREIGN KEY (
      id -- 유저번호
    )
    REFERENCES user ( -- 유저
      id -- 유저번호
    );

-- 게시글
ALTER TABLE post
  ADD CONSTRAINT FK_parti_TO_post -- 참여자 -> 게시글
    FOREIGN KEY (
      id -- 유저번호
    )
    REFERENCES parti ( -- 참여자
      id -- 유저번호
    );

-- 게시글
ALTER TABLE post
  ADD CONSTRAINT FK_proj_TO_post -- 프로젝트 -> 게시글
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 사용자_프로젝트
ALTER TABLE user_proj
  ADD CONSTRAINT FK_proj_TO_user_proj -- 프로젝트 -> 사용자_프로젝트
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 사용자_프로젝트
ALTER TABLE user_proj
  ADD CONSTRAINT FK_parti_TO_user_proj -- 참여자 -> 사용자_프로젝트
    FOREIGN KEY (
      id -- 유저번호
    )
    REFERENCES parti ( -- 참여자
      id -- 유저번호
    );

-- 첨부파일
ALTER TABLE attch_file
  ADD CONSTRAINT FK_post_TO_attch_file -- 게시글 -> 첨부파일
    FOREIGN KEY (
      post_id -- 게시글번호
    )
    REFERENCES post ( -- 게시글
      post_id -- 게시글번호
    );

-- 게시글댓글
ALTER TABLE cmnt
  ADD CONSTRAINT FK_post_TO_cmnt -- 게시글 -> 게시글댓글
    FOREIGN KEY (
      post_id -- 게시글번호
    )
    REFERENCES post ( -- 게시글
      post_id -- 게시글번호
    );

-- 게시글댓글
ALTER TABLE cmnt
  ADD CONSTRAINT FK_parti_TO_cmnt -- 참여자 -> 게시글댓글
    FOREIGN KEY (
      id -- 유저번호
    )
    REFERENCES parti ( -- 참여자
      id -- 유저번호
    );

-- 프로젝트_툴
ALTER TABLE proj_tool
  ADD CONSTRAINT FK_tool_TO_proj_tool -- 툴 -> 프로젝트_툴
    FOREIGN KEY (
      tool_id -- 툴번호
    )
    REFERENCES tool ( -- 툴
      tool_id -- 툴번호
    );

-- 프로젝트_툴
ALTER TABLE proj_tool
  ADD CONSTRAINT FK_proj_TO_proj_tool -- 프로젝트 -> 프로젝트_툴
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );

-- 참여자유형
ALTER TABLE user_type
  ADD CONSTRAINT FK_parti_TO_user_type -- 참여자 -> 참여자유형
    FOREIGN KEY (
      id -- 유저번호
    )
    REFERENCES parti ( -- 참여자
      id -- 유저번호
    );

-- 참여자유형
ALTER TABLE user_type
  ADD CONSTRAINT FK_grade_TO_user_type -- 학력 -> 참여자유형
    FOREIGN KEY (
      grade_id -- 학력번호
    )
    REFERENCES grade ( -- 학력
      grade_id -- 학력번호
    );

-- 게시글_분류
ALTER TABLE post_classfi
  ADD CONSTRAINT FK_post_TO_post_classfi -- 게시글 -> 게시글_분류
    FOREIGN KEY (
      post_id -- 게시글번호
    )
    REFERENCES post ( -- 게시글
      post_id -- 게시글번호
    );

-- 게시글_분류
ALTER TABLE post_classfi
  ADD CONSTRAINT FK_classfi_TO_post_classfi -- 분류 -> 게시글_분류
    FOREIGN KEY (
      classfi_id -- 분류번호
    )
    REFERENCES classfi ( -- 분류
      classfi_id -- 분류번호
    );

-- 작업
ALTER TABLE work
  ADD CONSTRAINT FK_proj_TO_work -- 프로젝트 -> 작업
    FOREIGN KEY (
      proj_id -- 프로젝트번호
    )
    REFERENCES proj ( -- 프로젝트
      proj_id -- 프로젝트번호
    );