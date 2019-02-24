
-- 테이블 삭제
-- if exists : 존재한다면 ~하라
drop table if exists lms_lesson; 
drop table if exists lms_member;
drop table if exists lms_board;

-- 테이블 생성
create table lms_lesson (
  lesson_id int not null auto_increment primary key comment '수업데이터 식별 번호', 
  sdt datetime not null comment '수업 시작일',
  edt datetime not null comment '수업 종료일',
  tot_hr int not null comment '총 수업 시간',
  day_hr int not null comment '일 수업 시간',
  titl varchar(255) not null comment '수업명',
  conts text not null comment '수업내용'
) comment '수업';

create table lms_member (
  member_id int not null auto_increment primary key comment '회원데이터 식별 번호', 
  name varchar(30) not null comment '회원이름',
  email varchar(50) not null comment '회원이메일',
  pwd varchar(255) not null comment '회원암호',
  photo varchar(255) comment '회원사진',
  tel varchar(20) comment '회원전화',
  cdt datetime default now() comment '등록일'
) comment '회원';

create table lms_board(
  board_id int not null auto_increment primary key comment '게시물 식별 번호', 
  conts text not null comment '게시물 내용',
  cdt datetime default now() comment '게시물 등록일',
  vw_cnt int default 0 comment '게시물 조회수'
) comment '게시물';
