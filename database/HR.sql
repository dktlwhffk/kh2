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
update snack set price=1700 where name='처음처럼';
rollback;
update snack set price=1700 where name='테라';
update snack set price=1700 where name='처음처럼';
update snack set price=1700 where name='허니버터칩';

select*from user_objects;