create sequence menu_coffee_seq;
truncate table menu_coffee;
drop table kh_member;
create table kh_member(
no number primary key,
name varchar2(12) not null,
id varchar2(20) not null unique,
pw varchar2(16) not null,
point number default 0 not null check(point >= 0),
joindate date not null
);
create sequence kh_member_seq;
truncate table kh_member;
delete sequecne kh_member_seq;
drop sequence kh_member_seq;
create sequence kh_member_seq;
select * from kh_member;
truncate table sports_player;
create sequence sports_player_seq;
update snack set price=1700 where name='ó��ó��';
rollback;
update snack set price=1700 where name='�׶�';
update snack set price=1700 where name='ó��ó��';
update snack set price=1700 where name='��Ϲ���Ĩ';

select*from user_objects;