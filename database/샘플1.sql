select avg(salary) from employees;
select salary from employees;


select J.job_title ����, avg(E.salary) ������� 
from employees E inner join jobs J on E.job_id=J.job_id 
group by J.job_title order by ����;

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
insert into kh_member values(KH_MEMBER_SEQ.nextval, 'Ȳ�κ�', 'ghkddlsqls', 'ghkddlsqls', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '��⿭', 'rlarlduf', 'rlarlduf', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '�躸��', 'rlaqhrud', 'rlaqhrud', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '�迹��', 'rladPdms', 'rladPdms', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '����', 'rladydqja', 'rladydqja', 6660, to_date('2018-05-09'));
insert into kh_member values(KH_MEMBER_SEQ.nextval, '����', 'rladnsrl', 'rladnsrl', 6660, to_date('2018-05-09'));
insert into kh_member values(7, '����ȯ', 'rlawjdghks', 'rlawjdghks', 6660, to_date('2018-05-09'));
select id, pw from kh_member where id = 'rladydqja';
commit;