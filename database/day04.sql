-------------------------------------------------------------------------------------------------------------------------
--view(��): ���Ǹ� ���� �����ϴ� ������ ���̺�(�ڵ� �����)
-------------------------------------------------------------------------------------------------------------------------

--����: create [or replace] view �̸� as �ڵ�:
create view v1 as select * from employees where job_title = 'Programmer';
create or replace view v1 as select*from employees where job_title = 'Programmer';

select*from v1;

--order+order_items = duo
create or replace view duo as 
select 
    O.*, OI.item_id, OI.product_id, OI.quantity, OI.unit_price 
from 
    orders O 
        inner join order_items OI on O.order_id = OI.order_id;

--view�� �̿��� �پ��� ��ȸ�� ����
select * from duo;
select * from duo order by order_date desc;
select status, count(*) from duo group by status;

-- view ���� ����
-- [1] �� ������ ��� �� �� �ִ� �並 ����
create or replace view info as
    select * from contacts order by first_name;
    
select*from info;

create or replace view details as select
info.first_name,info.last_name,info.phone,info.email,c.address
from(
    info inner join customers C on info.customer_id=c.customer_id);

select * from details order by first_name, last_name;

--[2] �õ�� â���� ������� �� �� �ִ� �並 ����(��� ������ ����)
create or replace view sydney as
    select * from warehouses;
    
    select*from sydney;

create or replace view balance as
    select*from inventories;
    
    select*from balance;

create or replace view sydney_balances as
    select
    S.warehouse_name â���,
    B.quantity  ���
    from
        sydney S inner join balance B on S.warehouse_id = b.warehouse_id; 

select*from sydney_balances order by "���" desc;

--[3] ��ǰ�� ī������ �Բ� �� �� �ִ� �並 ���� (��ǰ�� ������ ����)
create or replace view product as
    select*from products;
create or replace view categories as
    select*from product_categories;

create or replace view pc as
    select p.product_name,C.category_name
    from products P inner join product_categories C on p.category_id=c.category_id;

select distinct
*from pc order by product_name;

-------------------------------------------------------------------------------------------------------------------------
--indext(�ε���): �˻� �ӵ��� ����Ű�� ��
-------------------------------------------------------------------------------------------------------------------------
-- ����: create index �̸�  on ���̺�(�׸�)
-- ����: drop index �̸� 
drop table sample;
create table sample(
no number primary key,
id varchar2(20) not null unique,
name varchar2(20) not null
);

create index sample_id_index on sample(name);
alter index sample_id_index rebuild;
drop index sample_id_index;

-------------------------------------------------------------------------------------------------------------------------
--sequence(������): ��ȣ �ڵ� �ο� �ý���
-------------------------------------------------------------------------------------------------------------------------
--����: create sequence �̸� [�ɼ�] 
--����: drop sequence �̸�
--������ȸ: select * from user_sequences;
--���� ��ȣ ����: ��������.currval
--��ȣ �߱�(���� ��ȣ): ��������.nextval

create sequence test_seq;

select test_seq.nextval from dual;
select test_seq.currval from dual;
select * from user_sequences;
drop sequence test_seq;

--�ɼǺο�
drop sequence test_seq;

create sequence test_seq
minvalue 1000
maxvalue 9999
increment by 10
start with 2000
--cache 100
nocache;

select test_seq.nextval from dual;
select*from user_sequences;

-------------------------------------------------------------------------------------------------------------------------
--���� ����: ��� ���� ���� ����
-------------------------------------------------------------------------------------------------------------------------
--union: ������, �ߺ��÷� ����
--union all: ������, �ߺ��÷� ���
--intersect: ������
--minus(except): ������
--��: ��ü �۾��� �߿��� Programmer�� �ƴ� ��� �� 100�� manager�� �Ҽӵ��� ���� �۾��� ��ȸ
select*from employees where job_title !='Programmer' and manager_id !=100;

select*from employees
minus
select*from employees where job_title='Programmer'
minus
select*from employees where manager_id=100;

-- ����: 30�ϱ����� �����ϴ� �޿� ���� ���� ����� ���
--ù��° Ǯ��
select*from employees where extract(month from hire_date) in(4,6,9,11) 
order by hire_date;
--�ι�° Ǯ��
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=4
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=6
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=9
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=11
order by hire_date;
--����: 2016�� ��ݱ� ���� ���� �� ��ȭ��ȣ�� 515�� �����ϸ� ���Ŵ����� �ְ� ������ ������ �ش��ϴ� ���� ����� ���(stock manager, stock clerk, sales representative, 
commit;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--DEFAULT ����: �������� ���� �׸� ���ؼ� �⺻���� �ο� (����Ʈ, ������)
--      �������Ǻ��ٴ� ���� ���δ�
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
drop table tmp;
create table tmp(
a number default 100 not null, 
b date default sysdate not null
);

insert into tmp values(null,null);
select*from tmp;

insert into tmp(a) values (10);

insert into tmp(b) values(to_date('20010101','yyyymmdd'));
select * from tmp;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--����(UPDATE)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--�̸����� microsoft.com���� ������ ���� firstname �� lastname�� ����
update contacts set first_name = '���', last_name = '��' 
where email like '%@microsoft.com%';
commit;

-- ��� ������ ������ 1000�޷��� ������Ű����
update products set  list_price = list_price+1000;
rollback;


