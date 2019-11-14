drop table kh_member;
create table kh_member(
no number primary key,
name varchar2(12) not null,
id varchar2(40) not null,
pw varchar2(32) not null,
point number check(point>=0),
joindate date not null
);

select*from kh_member;
truncate table kh_member;
insert into kh_member 
values (1,'»≤¿Œ∫Û','ghkddlsqls','ghkddlsqls',6660,'20180509');