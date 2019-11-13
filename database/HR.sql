select * from tab;

--��ȸ: select
--������ ������ ��ȭ�� �����Ƿ� ���ôٹ������� ������ ����
--commit �Ǵ� rollback�� ������ ���� ����
--DML �߿����� DQL(Data Query language)�� �з��� �ȴ�

--����
--select �׸� from ���̺��̸� [����] [�׷�] [����]...;
desc employees;

--�̸��� ��ȸ
select first_name, last_name from employees;

--��ü ��ȸ
select * from employees;

--���� ���� where
--������ ���͸��� ���Ͽ� ���
--select * from employees where ���ǽ�;

--�۾��� id�� 200�̻��� �����͸� ��ȸ
select * from employees where employee_id>=200;
--�۾��� id�� 150�̻� 160������ �����͸� ��ȸ
select * from employees where employee_id>=150 and employee_id<=160;
--��Ʈ���� �̻����ϸ� �ش�
select * from employees
where employee_id BETWEEN 150 and 160;
--�۾��� ID 150���� ��ȸ
select * from employees where employee_id = 150;
--�۾��� id 150���� �ƴ� �����͸� ��ȸ
select * from employees where employee_id != 150;
--�̸��� alexander�� �۾��ڸ� ��ȸ
SELECT * FROM employees where first_name = 'Alexander';
--�̸��� a�� �����ϴ� ����� ��ȸ (����˻�)
select * from employees where first_name between 'A' and 'B';
--like �˻� �̿�
select * from employees where first_name like '%a%';
--����: ��ȭ��ȣ�� 2,0,1,9 �߿� �ϳ��� �� ������ ��ȸ
select * from employees where 
phone_number like '%2%' or phone_number like '%0%' or phone_number like'%1%' or phone_number like '%9%';
select * from employees where regexp_like(phone_number, '[2019]');

-- ��¥ : like�� �ǰ� �Ϲ� �񱳵� ����. ������ ��¥
--24�ð� ������ ������� ���� �۾��� ��ȸ
select * from employees where hire_date between sysdate-1 and sysdate;

--����: 2000����� 2003�� ���̿� ���� �۾��� ��ȸ
select * from employees where hire_date between to_date('2000','yyyy') and to_date('2003','yyyy');
--�ú��� ���
select * from employees where hire_date between 
to_date('20000101000000','yyyymmddhh24miss')and to_date('20031231235959','yyyymmddhh24miss');

--extract�� �̿��ϸ� ��¥���� ���ϴ� ���� ���� �� �ִ�.(year month day hour minute second)
--select extract(YEAR from hire_date) from employees;
select * from employees
where extract(YEAR from hire_date) between 2000 and 2003;

--����: ����(9,10,11)�� ���� �۾��� ��ȸ
select*from employees
where extract (MONTH from hire_date) = 9 or extract (MONTH from hire_date) = 10 or extract (MONTH from hire_date) = 11;
--�ι�° ���
select*from employees
where extract(MONTH from hire_date) between 9 and 11;

--����Ŭ �ֿ� �Լ�
select * from dual;
--1234+5678 =?
select 1234+5678 from dual;
select 1234+5678 as result from dual;

--ASCII ���ڸ� ���ڷ�
select chr(90) from dual;
--ASCII ���ڸ� ���ڷ�
select ascii('Z')from dual;
select ascii('K') as "�ɽ��ؼ� �غ�" from dual;

--�빮�� ��ȯ upper()
select upper('Hello Java') from dual;
--�ҹ��� ��ȯ lower()
select lower('Hello Java') from dual;
-- ù���ڸ� �빮�ڷ�: initcap()
select initcap('hello java') from dual;
--ġȯ: replace('����' '��� ���ڿ�' '�ٲܹ��ڿ�)
select replace('Hello Java','Java','SQL') from dual;
--�ڸ���: substr(����, ������, ���ڼ�)
select substr('www.naver.com',5,5)from dual;
--------------------------------------------------------------------------------------------------------------------------------------
--�����ϴ� ������ ���̺� �Լ��� ����
--------------------------------------------------------------------------------------------------------------------------------------
select first_name, last_name from employees;
select initcap(first_name), initcap(last_name) from employees;
select initcap(first_name) as �̸�, initcap(last_name) as �� from employees;
--�̸��� ���� �ٿ��� ���� �ʹٸ� ���Ῥ���� ���:||
select first_name || last_name from employees;
select initcap(first_name) ||' '|| lower(last_name) as �̸� from employees;


select salary from employees;

select 
    sum(salary) as "�޿� �հ�" ,
    avg(salary) as ����ӱ�, 
    max(salary) as �ְ�ҵ�, 
    min(salary) as �����ҵ�,
    count(*) as ������ 
from 
    employees;
commit;

------------------------------------------------------------------------------------------------------------
--����
------------------------------------------------------------------------------------------------------------
--����: ���� �޿��� ���� ����� "�̸�"�� ���
--�Ʒ��� �۾��� ��� 1���� ���� �� ����
--1. �ְ� �޿����� ���Ѵ�
select max(salary) from employees;
--2. 1������ ���� ���� �������� �̸��� ���Ѵ�
select first_name, last_name from employees 
where salary=(select max(salary) from employees); --���� ����

--����: �޿��� ��� ������ ����� �ο����� ���ض�
--1. ��� �޿����� ���Ѵ�
select avg(salary) from employees;

--2.1������ ���� ���� �������� ��� �����ο��� ����Ѵ�
select count(*) as "�޿� ��� ���� �ο�"  from employees
where salary<=(select avg(salary) from employees);
-------------------------------------------------------------------------------------------------------------------------------
--����(Order)
--      �����͸� ���ϴ� ���ؿ� �����ϴ� ������� �����ϴ� ��
--      order by �׸� ����[, ...]
--      asc�� ��������
--      ����: ���� �տ� ��ġ�� �� ����.
--------------------------------------------------------------------------------------------------------------------------------
--�޿� ������ ����
select * from employees order by salary desc;

--�޿� ��, ����� ������ ����
select * from employees order by salary desc, hire_date asc;

--�޿��� 10000�޷� �̻��� ����� �޿���, ����� ������ ����
select * from employees 
where salary>=10000 
order by salary desc, hire_date;

--rownum: ����� �ٹ�ȣ

select rownum, first_name from employees;
--select rownum, * from employees;

--employees�� E��� �θ���, �� ���� first_name�� rownum�� ���!
select rownum, E.first_name from employees E;
--��Ī �ִ� ����
select rownum, E.* from employees E;
--��Ī ���� ����
select rownum, employees.* from employees;
--------------------------------------------------------------------------------------------------------------------------------
--Top N ����: ���� ���ϴ� ������ �����͸� ����ϴ� ���
--------------------------------------------------------------------------------------------------------------------------------
--������ �ϰ� ���� ��ȣ�� �ٿ��� ���� ���ϴ� ���·� ���͸��� ����
-- 1. �����͸� ���ϴ� ���·� �����Ѵ�.
-- 2. 1���� �����Ϳ� �ٹ�ȣ�� �ο��Ѵ�.

--���� ����� ������ �ʰ��ϹǷ� �� �� ����.
select rownum, E.* from employees E order by E.salary desc;

--������ ���߱� ���Ͽ� �������� ���
-- 1. select * from employees order by salary desc
-- 2. select rownum, E.* from(1) E
select rownum, E.* from(
select * from employees order by salary desc
) E;
--top3 ���ϱ�
select rownum, E.* from(
    select * from employees order by salary desc
) E where rownum<=3;

select rownum, E.*from(
    select*from employees order by hire_date
)E where rownum<=3;

select rownum, E.*from(
    select*from employees order by hire_date desc
)E where rownum<=3;

-- rownum�� ������ 1���� �ο��Ǿ�� �Ѵ�.
-- ���� : �߰��κ��� �ο��ϸ鼭 ��ȸ�� �Ұ�

-- �߰��κб��� ��ȸ�ϰ� �ʹٸ� �ѹ� �� SQL ����� �ۼ��ؾ���
-- select * from (2�� ���) where �Ʊ� rownum between ? and ?

--Top n query
select * from(
select rownum rn, E.* from(
    select * from employees order by salary desc
    ) E 
)where rn between 3 and 5; 


select*from(
select rownum rn, L.* from(
    select*from locations where country_id like '%US%'
    ) L
);

--���� ���̺��� �̱��� ���� ������ �� �̸������� 3�� ���
select*from(
    select rownum rn, S.* from (
             select*from locations where country_id = 'US' order by state_province asc
    ) S 
) where rn<=3;

--�۾��� ���̺��� �츮ȸ�翡 77��°�� �Ի��� ����� ���

select*from employees order by hire_date; --�������� �Ի��� ����

select rownum rn, H.* from(
    select*from employees order by hire_date
    )H;                                                                        --�ٹ�ȣ �ο�

select*from(
select rownum rn, H.* from(
    select*from employees order by hire_date     --77��° �� ã�� �Ϸ�
    )H
) where rn = '77';

--�۾��� ���̺��� �Ŵ��� ���̵� 100�� ����߿��� �ֱ� �Ի��� 2�� ���
select * from employees;

select*from(
    select rownum rn, M.* from(
        select * from employees where manager_id=100 order by hire_date desc
        )M
    ) where rn <=2;

select* from countries;
select*from employees;
select*from locations;



