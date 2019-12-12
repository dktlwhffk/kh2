select avg(salary) from employees;
select salary from employees;


select J.job_title Á÷¾÷, avg(E.salary) ¿¬ºÀÆò±Õ 
from employees E inner join jobs J on E.job_id=J.job_id 
group by J.job_title order by Á÷¾÷;

select*from kh_member;
select id,pw from kh_member where id='rladyqja';
truncate table kh_member;
select*from kh_member;
drop sequence kh_member_seq;
create sequence kh_member_seq;

truncate table snack;
drop sequence snack_seq;
create sequence snack_seq;

select * from user_sequences; 

alter sequence snack_seq increment by  +1;
select snack_seq.nextval from dual;

truncate table kh_member;
select*from snack;
rollback;

select*from snack where name like '%a%';
select*from kh_member;
insert into kh_member values(kh_member_seq.nextval,'g','gg','gg',0,sysdate);
create sequence kh_member_seq;
drop sequence kh_member_seq;
insert into kh_member values(KH_MEMBER_SEQ.nextval, 'È²ÀÎºó', 'ghkddlsqls', 'ghkddlsqls', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '±è±â¿­', 'rlarlduf', 'rlarlduf', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '±èº¸°æ', 'rlaqhrud', 'rlaqhrud', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '±è¿¹Àº', 'rladPdms', 'rladPdms', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '±è¿ë¹ü', 'rladydqja', 'rladydqja', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '±è¿î±â', 'rladnsrl', 'rladnsrl', 6660, to_date('2018-05-09'));
insert into kh_member values(7, '±èÁ¤È¯', 'rlawjdghks', 'rlawjdghks', 6660, to_date('2018-05-09'));
select id, pw from kh_member where id = 'rladydqja';
commit;