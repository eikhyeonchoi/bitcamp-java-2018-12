-- 2단계
select lano, lno , m.name
from lect_appl la
join memb m on la.mno=m.mno;

-- 3단계
select lano, lno , m.name, s.work
from lect_appl la
join memb m on la.mno=m.mno
join stnt s on la.mno=s.mno;

-- 4단계
select lano, l.titl , m.name, s.work
from lect_appl la
join memb m on la.mno=m.mno
join stnt s on la.mno=s.mno
join lect l on la.lno=l.lno;

-- 5단계
select lano 신청번호, l.titl 신청강의명, m.name 학생이름, s.work 재직여부, r.name 강의실명
from lect_appl la
join memb m on la.mno=m.mno
join stnt s on la.mno=s.mno
join lect l on la.lno=l.lno
left outer join room r on l.rno=r.rno;

-- 6단계
select lano 신청번호, l.titl 신청강의명, m.name 학생이름, s.work 재직여부, r.name 강의실명, m2.name 매니저이름
from lect_appl la
join memb m on la.mno=m.mno
join stnt s on la.mno=s.mno
join lect l on la.lno=l.lno
left outer join room r on l.rno=r.rno
left outer join memb m2 on m2.mno=l.mno;

-- 6단계
select lano 신청번호, l.titl 신청강의명, m.name 학생이름, s.work 재직여부, r.name 강의실명, m2.name 매니저이름, mg.posi 매니저직위
from lect_appl la
join memb m on la.mno=m.mno
join stnt s on la.mno=s.mno
join lect l on la.lno=l.lno
left outer join room r on l.rno=r.rno
left outer join memb m2 on m2.mno=l.mno
left outer join mgr mg on mg.mno=l.mno;

select la.lano 신청번호, la.lno 강의번호, m.name 학생이름
from lect_appl la
join memb m on la.mno=m.mno;

select la.lano 신청번호, la.lno 강의번호, m.name 매니저이름
from lect_appl la
join lect l on la.lno=l.lno
join mgr mg on l.mno=mg.mno
join memb m on m.mno=mg.mno;

select m.mno
from memb m 
join stnt s on m.mno=s.mno;

select m.mno
from memb m 
join mgr mg on m.mno=mg.mno;

select m.mno, t.bank
from memb m 
join tcher t on m.mno=t.mno;

























