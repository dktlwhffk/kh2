-------------------------------------------------------------------------------------------------------------
--������Ʈ �����̽�
drop table subject_price;
create table subject_price(
name varchar2(60) primary key,
type varchar2(60) not null
check(type in('����','����')),
price number not null check(price>=0),
startdate date,
finishdate date
);
truncate table subject_price;

insert into subject_price values('�ڹ�','����',500000,to_date('2019-11-20','yyyy-mm-dd'),to_date('20191220','yyyymmdd'));
insert into subject_price values('JSP','����',600000,to_date('2019-12-21','yyyy-mm-dd'),to_date('2020-01-15','yyyy-mm-dd'));
insert into subject_price values('������','����',800000,to_date('2019-11-15','yyyy-mm-dd'),to_date('2019-12-10','yyyy-mm-dd'));
insert into subject_price values('�Ǽ��ڵ�м�','����',950000,to_date('2020-01-05','yyyy-mm-dd'),to_date('2020-02-01','yyyy-mm-dd'));

commit;

select * from subject_price;
-----------------------------------------------------------------------------------------------------------------------
drop table naver_member;
create table naver_member(
id varchar2(60) primary key,
pw varchar2(60) not null,
pwcheck varchar2(60) not null,
name varchar2(120) not null,
birth date not null check(to_date('19190101','yyyymmdd')<=birth and birth<=TO_DATE('2019-01-01', 'YYYY-MM-DD')),
gender varchar(6) not null check(gender in('����','����')),
confirm_email varchar2(120) not null,
phone_nation varchar2(40) not null,
phone_num varchar2(40) not null unique
);
commit;
select * from naver_member;
