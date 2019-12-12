create table MEMBER (
USERID varchar2(20) primary key,
PASSWORD varchar2(12) not null,
USERNAME varchar2(10),
AGE number,
GENDER varchar2(5) check (GENDER in('³²','¿©')),
ENROLLDATE date);

select*from member;
insert into member values('USER01','USER01','È«±æµ¿',19,'³²',sysdate);
insert into member values('USER012','USER01','È«µ¿',19,'³²','');
select USERID, USERNAME, GENDER, ENROLLDATE from member where age>=19; 

