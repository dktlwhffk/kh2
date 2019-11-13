create table kh_member(
no number primary key,
name varchar2(12) not null check(name<=12),
id varchar2(40) check(id>=16 and id<=40),
pw varchar2(32) check(pw>=16 and pw<=32),
point number check(point>=0),
joindate date not null
);

select*from kh_member;

insert into kh_member values(1,'»≤¿Œ∫Û','ghkddlsqls','ghkddlsqls',6660,'20180509')