-- 테이블 식제
drop table x_board;

-- 게시판 테이블 생성
	create table x_board(
	  board_id int not null primary key auto_increment,
	  title varchar(255) not null,
	  contents text null,
	  created_date datetime null default now(),
	  view_count int null default 0
	);

-- 데이터 입력
insert into x_board(title, contents)
values('제목1','내용');
insert into x_board(title, contents)
values('제목2','내용');
insert into x_board(title, contents)
values('제목3','내용');
insert into x_board(title, contents)
values('제목4','내용');
insert into x_board(title, contents)
values('제목5','내용');

-- 데이터 조회
select board_id, title, created_date
from x_board
order by board_id desc;

select board_id, title, created_date, view_count
from x_board
where board_id = 3;

-- 데이터 변경
update x_board 
set view_count = view_count + 1, created_date = now()
where board_id = 3;

-- 데이터 삭제
delete from x_board
where board_id = 3;

  create table temp_board(
    board_id int,
    contents text,
    created_date datetime,
    view_count int
  );
  create table temp_member(
    member_id int,
    name varchar(10),
    mail varchar(20),
    password varchar(15),
    photo varchar(10),
    tel varchar(15),
    registered_date datetime
  );
  
  create table temp_lesson(
    lesson_id int,
    title varchar(15),
    contents varchar(50),
    started_date datetime,
    ended_date datetime,
    total int,
    day int
  );




