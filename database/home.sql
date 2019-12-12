select*from(
    select rownum rn, A.* from(
        select*from board order by no desc
    )A
)where rn between 1 and 10;


        
alter table board add(
groupno number,
superno constraint fk_board_superno references board(no) on delete cascade,
depth number default 0);



update board set groupno = no;
alter table board modify groupno not null;

update board set depth = 0;
alter table board modify depth not null;

--board의 모든 데이터를 조회하는데
select*from board 
--no와 superno가 연결되어있고
connect by  prior no=superno
--superno가 null인 항목이 시작점이야
start with superno is null
--전체 데이터는 groupno 역방향, no 정방향순이야
order siblings by groupno desc, no asc;

create table reply(
rno number primary key,
no number,
rwriter constraint fk_reply_rwriter references member(id) on delete cascade,
rcontent varchar2(4000),
rdate date default sysdate not null
);
create sequence reply_seq;
select*from board;

update board set readcount = readcount+1 where no=30035;
drop table files;
create table files(
no number primary key,
origin constraint fk_files_board references board(no) on delete set null,
uploadname varchar2(260) not null,
savename varchar2(260) not null unique,
filetype varchar2(50),
filesize number default 0
);
create sequence files_seq;
select*from files;
delete files where no=3;