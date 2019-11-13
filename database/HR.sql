select * from tab;

--조회: select
--데이터 상태의 변화가 없으므로 동시다발적으로 진행이 가능
--commit 또는 rollback의 영향을 받지 않음
--DML 중에서도 DQL(Data Query language)로 분류가 된다

--형식
--select 항목 from 테이블이름 [조건] [그룹] [정렬]...;
desc employees;

--이름만 조회
select first_name, last_name from employees;

--전체 조회
select * from employees;

--조건 설정 where
--데이터 필터링을 위하여 사용
--select * from employees where 조건식;

--작업자 id가 200이상인 데이터만 조회
select * from employees where employee_id>=200;
--작업자 id가 150이상 160이하인 데이터만 조회
select * from employees where employee_id>=150 and employee_id<=160;
--비트윈은 이상이하만 해당
select * from employees
where employee_id BETWEEN 150 and 160;
--작업자 ID 150번을 조회
select * from employees where employee_id = 150;
--작업자 id 150번이 아닌 데이터를 조회
select * from employees where employee_id != 150;
--이름이 alexander인 작업자를 조회
SELECT * FROM employees where first_name = 'Alexander';
--이름이 a로 시작하는 사람을 조회 (유사검색)
select * from employees where first_name between 'A' and 'B';
--like 검색 이용
select * from employees where first_name like '%a%';
--문제: 전화번호에 2,0,1,9 중에 하나라도 들어간 데이터 조회
select * from employees where 
phone_number like '%2%' or phone_number like '%0%' or phone_number like'%1%' or phone_number like '%9%';
select * from employees where regexp_like(phone_number, '[2019]');

-- 날짜 : like도 되고 일반 비교도 가능. 단위가 날짜
--24시간 전부터 현재까지 고용된 작업자 조회
select * from employees where hire_date between sysdate-1 and sysdate;

--문제: 2000년부터 2003년 사이에 고용된 작업자 조회
select * from employees where hire_date between to_date('2000','yyyy') and to_date('2003','yyyy');
--시분초 계산
select * from employees where hire_date between 
to_date('20000101000000','yyyymmddhh24miss')and to_date('20031231235959','yyyymmddhh24miss');

--extract를 이용하면 날짜에서 원하는 값을 뽑을 수 있다.(year month day hour minute second)
--select extract(YEAR from hire_date) from employees;
select * from employees
where extract(YEAR from hire_date) between 2000 and 2003;

--문제: 가을(9,10,11)에 고용된 작업자 조회
select*from employees
where extract (MONTH from hire_date) = 9 or extract (MONTH from hire_date) = 10 or extract (MONTH from hire_date) = 11;
--두번째 방법
select*from employees
where extract(MONTH from hire_date) between 9 and 11;

--오라클 주요 함수
select * from dual;
--1234+5678 =?
select 1234+5678 from dual;
select 1234+5678 as result from dual;

--ASCII 숫자를 글자로
select chr(90) from dual;
--ASCII 글자를 숫자로
select ascii('Z')from dual;
select ascii('K') as "심심해서 해봄" from dual;

--대문자 전환 upper()
select upper('Hello Java') from dual;
--소문자 전환 lower()
select lower('Hello Java') from dual;
-- 첫글자만 대문자로: initcap()
select initcap('hello java') from dual;
--치환: replace('원본' '대상 문자열' '바꿀문자열)
select replace('Hello Java','Java','SQL') from dual;
--자르기: substr(원본, 시작점, 글자수)
select substr('www.naver.com',5,5)from dual;
--------------------------------------------------------------------------------------------------------------------------------------
--존재하는 데이터 테이블에 함수를 적용
--------------------------------------------------------------------------------------------------------------------------------------
select first_name, last_name from employees;
select initcap(first_name), initcap(last_name) from employees;
select initcap(first_name) as 이름, initcap(last_name) as 성 from employees;
--이름과 성을 붙여서 보고 싶다면 연결연산을 사용:||
select first_name || last_name from employees;
select initcap(first_name) ||' '|| lower(last_name) as 이름 from employees;


select salary from employees;

select 
    sum(salary) as "급여 합계" ,
    avg(salary) as 평균임금, 
    max(salary) as 최고소득, 
    min(salary) as 최저소득,
    count(*) as 직원수 
from 
    employees;
commit;

------------------------------------------------------------------------------------------------------------
--응용
------------------------------------------------------------------------------------------------------------
--문제: 가장 급여가 높은 사람의 "이름"을 출력
--아래의 작업은 명령 1개로 끝날 수 없다
--1. 최고 급여액을 구한다
select max(salary) from employees;
--2. 1번에서 구한 값을 조건으로 이름을 구한다
select first_name, last_name from employees 
where salary=(select max(salary) from employees); --서브 쿼리

--문제: 급여가 평균 이하인 사람의 인원수를 구해라
--1. 평균 급여액을 구한다
select avg(salary) from employees;

--2.1번에서 구한 값을 조건으로 평균 이하인원을 출력한다
select count(*) as "급여 평균 이하 인원"  from employees
where salary<=(select avg(salary) from employees);
-------------------------------------------------------------------------------------------------------------------------------
--정렬(Order)
--      데이터를 원하는 기준에 부합하는 순서대로 나열하는 것
--      order by 항목 순서[, ...]
--      asc는 생략가능
--      주의: 조건 앞에 위치할 수 없다.
--------------------------------------------------------------------------------------------------------------------------------
--급여 순으로 정렬
select * from employees order by salary desc;

--급여 순, 고용일 순으로 정렬
select * from employees order by salary desc, hire_date asc;

--급여가 10000달러 이상인 사람을 급여순, 고용일 순으로 정렬
select * from employees 
where salary>=10000 
order by salary desc, hire_date;

--rownum: 결과의 줄번호

select rownum, first_name from employees;
--select rownum, * from employees;

--employees를 E라고 부르며, 그 안의 first_name과 rownum을 출력!
select rownum, E.first_name from employees E;
--별칭 있는 버전
select rownum, E.* from employees E;
--별칭 없는 버전
select rownum, employees.* from employees;
--------------------------------------------------------------------------------------------------------------------------------
--Top N 쿼리: 내가 원하는 순서의 데이터를 출력하는 명령
--------------------------------------------------------------------------------------------------------------------------------
--정렬을 하고 나서 번호를 붙여야 내가 원하는 형태로 필터링이 가능
-- 1. 데이터를 원하는 상태로 정렬한다.
-- 2. 1번의 데이터에 줄번호를 부여한다.

--다음 명령은 정렬을 늦게하므로 쓸 수 없다.
select rownum, E.* from employees E order by E.salary desc;

--순서를 맞추기 위하여 서브쿼리 사용
-- 1. select * from employees order by salary desc
-- 2. select rownum, E.* from(1) E
select rownum, E.* from(
select * from employees order by salary desc
) E;
--top3 구하기
select rownum, E.* from(
    select * from employees order by salary desc
) E where rownum<=3;

select rownum, E.*from(
    select*from employees order by hire_date
)E where rownum<=3;

select rownum, E.*from(
    select*from employees order by hire_date desc
)E where rownum<=3;

-- rownum은 무조건 1부터 부여되어야 한다.
-- 주의 : 중간부분은 부여하면서 조회가 불가

-- 중간부분까지 조회하고 싶다면 한번 더 SQL 명령을 작성해야함
-- select * from (2차 결과) where 아까 rownum between ? and ?

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

--지역 테이블에서 미국에 속한 지역을 주 이름순으로 3개 출력
select*from(
    select rownum rn, S.* from (
             select*from locations where country_id = 'US' order by state_province asc
    ) S 
) where rn<=3;

--작업자 테이블에서 우리회사에 77번째로 입사한 행운사원 출력

select*from employees order by hire_date; --내림차순 입사일 정렬

select rownum rn, H.* from(
    select*from employees order by hire_date
    )H;                                                                        --줄번호 부여

select*from(
select rownum rn, H.* from(
    select*from employees order by hire_date     --77번째 줄 찾기 완료
    )H
) where rn = '77';

--작업자 테이블에서 매니저 아이디가 100인 사람중에서 최근 입사자 2명 출력
select * from employees;

select*from(
    select rownum rn, M.* from(
        select * from employees where manager_id=100 order by hire_date desc
        )M
    ) where rn <=2;

select* from countries;
select*from employees;
select*from locations;



