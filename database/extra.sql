------------------------------------------------------------------------------------------------------------------------------------
--외래키 조건
--          외래키 설정 시 삭제와 관련된 조건을 지정할 수 있다.
--          on delete cascade       하위 요소도 함께 삭제
--          on delete set null         하위 요소의 외래키를 null로 처리
------------------------------------------------------------------------------------------------------------------------------------

--학원 테이블 생성
create table academy(
no number primary key,
name varchar2(30) not null
);

--학생 테이블 생성
drop table student;
create table student(
stdno number primary key,
stdname varchar2(30) not null,
--academy constraint fk_student_academy references academy(no)
--academy constraint fk_student_academy references academy(no) on delete cascade
academy constraint fk_student_academy references academy(no) on delete set null
);

insert into academy values(1, 'KH당산점');
insert into student values(1,'슈퍼맨',1);
insert into student values(2,'배트맨',1);
insert into student values(3,'엑스맨',1);
commit;

select*from student;
delete academy where no=1;

------------------------------------------------------------------------------------------------------------------------------------
--  복합키 : 여러개의 항목을 묶어서 primary key로 사용하는 경우
--          예) 날짜+순서, 학년+반+번호 
------------------------------------------------------------------------------------------------------------------------------------
drop table school;
create table school(
grade number,
class number,
no number,
--복합키 제약조건 추가
CONSTRAINT pk_school primary key(grade,class,no)
);
 insert into school values(1,1,1);
 insert into school values(1,1,2);
 
 ------------------------------------------------------------------------------------------------------------------------------------
 --PLSQL : 오라클이 제공하는 프로그래밍 구문
 ------------------------------------------------------------------------------------------------------------------------------------
 
 --상황: 게시글과 댓글 테이블 구현
 drop table reply;
 drop table board;
 create table board(
 no number primary key,
 title varchar2(30) not null,
 --댓글 수를 따로 보관(성능 향상을 위해) 반정규화 과정
 replycount number default 0 not null
 );
 
 create table reply(
 no number primary key,
 content varchar2(100) not null,
 board constraint fk_reply_board references board(no)
 );
 
insert into board(no,title) values(1,'1번게시글');
insert into board(no,title) values(2,'2번게시글');

select*from board;
select*from reply;
--댓글 등록을 위해서는 insert+update 을 수행

insert into reply values(1,'1번 댓글',1);
update board set replycount=replycount + 1 where no = 1;

--PL/SQL로 생성
BEGIN
    insert into reply values(2,'2번댓글',1);
    update board set replycount= replycount+1 where no =1;
END;

--이름을 부여하여 저장 (stored)프로시저(procedure)로 생성
create or replace procedure reply_insert 
(
    reply_no IN number , 
    reply_content IN varchar2,
    board_no IN number
)
IS
BEGIN
    insert into reply values(reply_no,reply_content,board_no);
    update board set replycount= replycount+1 where no =1;
END;

-- 프로시저 호출
EXEC reply_insert(3,'3번댓글',1);

commit;

-- out 매개변수 확인을 위한 저장 프로시저 생성
-- 게시글 수와 댓글 수를 조회하기 위한 프로시저

--익명 프로시저
DECLARE
    board_count number;
    reply_count number;
BEGIN
    --board의 count 를 구하여 board_count에 대입하라
    select count(*) into board_count from board;
    select count(*) into reply_count from reply;
    dbms_output.put_line('게시글 수 : '|| board_count);
    dbms_output.put_line('댓글 수 : '|| board_count);
END;

--  저장프로시저
create or replace procedure get_count
(   
    board_count OUT number,
    reply_count OUT number
)
IS
BEGIN
    --board의 count 를 구하여 board_count에 대입하라
    select count(*) into board_count from board;
    select count(*) into reply_count from reply;
    dbms_output.put_line('게시글 수 : '|| board_count);
    dbms_output.put_line('댓글 수 : '|| board_count);
END;

-- 저장 프로시저 호출을 위해서는
-- [1]변수 2개를 준비한다
-- [2]프로시저 호출시 전달
-- [3]결과를 출력

DECLARE
    a number := 0;
    b number := 0;
BEGIN
    --a와 b를 줄테니 여기에 값 담아서 내놔라
    get_count(a,b);
    dbms_output.put_line(a);
    dbms_output.put_line(b);
END;