-------------------------------------------------------------------------------------------------------------------------
--view(뷰): 편의를 위해 생성하는 가상의 테이블(코드 저장소)
-------------------------------------------------------------------------------------------------------------------------

--생성: create [or replace] view 이름 as 코드:
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

--view를 이용한 다양한 조회가 가능
select * from duo;
select * from duo order by order_date desc;
select status, count(*) from duo group by status;

-- view 생성 문제
-- [1] 고객 정보를 모두 볼 수 있는 뷰를 생성
create or replace view info as
    select * from contacts order by first_name;
    
select*from info;

create or replace view details as select
info.first_name,info.last_name,info.phone,info.email,c.address
from(
    info inner join customers C on info.customer_id=c.customer_id);

select * from details order by first_name, last_name;

--[2] 시드니 창고의 재고목록을 볼 수 있는 뷰를 생성(재고량 순서로 정렬)
create or replace view sydney as
    select * from warehouses;
    
    select*from sydney;

create or replace view balance as
    select*from inventories;
    
    select*from balance;

create or replace view sydney_balances as
    select
    S.warehouse_name 창고명,
    B.quantity  재고량
    from
        sydney S inner join balance B on S.warehouse_id = b.warehouse_id; 

select*from sydney_balances order by "재고량" desc;

--[3] 제품을 카레고리와 함께 볼 수 있는 뷰를 생성 (제품명 순으로 정렬)
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
--indext(인덱스): 검색 속도를 향상시키는 것
-------------------------------------------------------------------------------------------------------------------------
-- 형식: create index 이름  on 테이블(항목)
-- 삭제: drop index 이름 
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
--sequence(시퀀스): 번호 자동 부여 시스템
-------------------------------------------------------------------------------------------------------------------------
--생성: create sequence 이름 [옵션] 
--삭제: drop sequence 이름
--상태조회: select * from user_sequences;
--현재 번호 보기: 시퀀스명.currval
--번호 발급(다음 번호): 시퀀스명.nextval

create sequence test_seq;

select test_seq.nextval from dual;
select test_seq.currval from dual;
select * from user_sequences;
drop sequence test_seq;

--옵션부여
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
--집합 연산: 결과 집합 간의 연산
-------------------------------------------------------------------------------------------------------------------------
--union: 합집합, 중복컬럼 제거
--union all: 합집합, 중복컬럼 허용
--intersect: 교집합
--minus(except): 차집합
--예: 전체 작업자 중에서 Programmer가 아닌 사람 중 100번 manager에 소속되지 않은 작업자 조회
select*from employees where job_title !='Programmer' and manager_id !=100;

select*from employees
minus
select*from employees where job_title='Programmer'
minus
select*from employees where manager_id=100;

-- 문제: 30일까지만 존재하는 달에 고용된 직원 목록을 출력
--첫번째 풀이
select*from employees where extract(month from hire_date) in(4,6,9,11) 
order by hire_date;
--두번째 풀이
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=4
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=6
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=9
union
select hire_date, first_name ||' '||last_name from employees where extract(month from hire_date)=11
order by hire_date;
--문제: 2016년 상반기 고용된 직원 중 전화번호가 515로 시작하며 담당매니저가 있고 직업이 다음에 해당하는 직원 목록을 출력(stock manager, stock clerk, sales representative, 
commit;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--DEFAULT 조건: 설정되지 않은 항목에 대해서 기본값을 부여 (포인트, 가입일)
--      제약조건보다는 먼저 쓰인다
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
--수정(UPDATE)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--이메일이 microsoft.com으로 끝나는 고객의 firstname 과 lastname을 수정
update contacts set first_name = '흥민', last_name = '손' 
where email like '%@microsoft.com%';
commit;

-- 모든 직원의 연봉을 1000달러씩 증가시키세요
update products set  list_price = list_price+1000;
rollback;


