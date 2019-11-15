--첫번째 문제
select
C.EMAIL 메일주소,
C.FIRST_NAME||' '||LAST_NAME 이름,
CUS.ADDRESS 주소
from
 customers CUS  inner join contacts C on (CUS.customer_id= c.contact_id) 
where C.EMAIL like '%microsoft.com%'
;

--두번째 문제
select
W.warehouse_name 관리지역,
R.region_name 대륙,
C.country_name 국가
from
    warehouses W inner join locations L on 
        (W.warehouse_id=L.location_id) 
            inner join countries C on
                (L.country_id=C.country_id)
                    inner join regions R on
                        (C.region_id=R.region_id)
order by 관리지역;

--세번째 문제: 재고가 가장 많은 상품 정보 5개 출력
--문제점: null이 내림차순에서 먼저 등장한다는 것이 문제
--해결책1: null을 빼고 조회, 조건where
--해결책2: null을 0으로 치환

select rownum, I.* from(
   select 
I.quantity 재고,
P.product_name 상품명,
P.description 상품설명,
sum(I.quantity) 재고합계
from
    inventories I left outer join products P on
        (I.product_id=P.product_id) group by I.quantity, P.product_name, P.description
        order by 재고 desc
) I where rownum<=5;

--네번째 문제:2017년에 주문한 고객 이름을 출력
select 
O.order_date 주문날짜,
CO.first_name||' '||last_name 고객명
from
    orders O inner join customers C on
        (c.customer_id=o.order_id) 
        inner join contacts CO on
                (c.customer_id=co.customer_id)
                where extract(year from O.order_date) = 2017 
                order by 고객명, 주문날짜;
                
--다섯번째 문제: 판매중인 모든 제품의 분류와 이름을 출력
select distinct
C.category_name 카테고리,
P.product_name 제품명
from
    product_categories C inner join products P on
    (c.category_id = p.category_id) order by 카테고리, 제품명;

--여섯번째 문제: 근로자 중에서 프로그래머 정보를 최신순으로 출력
select 
job_title 직책,
first_name||' '||last_name 이름,
email 이메일,
phone 휴대전화,
hire_date 입사일
from
    employees where job_title like '%Programmer%' ;
    
--그룹문제 1번: 고용된 직원들의 직종별 인원수를 조회
select 
    job_title 직종,
    count(*) 인원수
from
    employees group by job_title order by 직종;
    
--그룹문제 2번: 창고별 재고 개수(합계)
select distinct
    warehouse_id 창고번호,
    sum(quantity)
from
    inventories group by warehouse_id order by warehouse_id;

--그룹문제 3번:국가별 창고 개수

select 
    C.country_name 국가명,
    count(*) 창고개수
from
    countries C 
    inner join locations L on (c.country_id=L.country_id) 
    inner join warehouses W on (l.location_id=w.location_id) 
    group by C.country_name
    order by 국가명, 창고개수;

--nvl(항목, 대체값) = null을 대체해주는 함수

--그룹문제 4번:제품별 판매 금액 (합계)

--그룹문제 5번: 연도별 취소된 제품 주문 건수

--그룹문제 6번: 연도별 취소된 제품 주문 수량 합계
select
    연도,
    sum(quantity) 취소수량
from
    (
        select extract(year from order_date)연도, O.*,OI.*
        from
            orders O
                left outer join order_items OI on O.order_id = OI.order_id
        where
            O.status = 'Canceled'
    )
group by 연도 
order by 연도 asc;

--그룹문제 7번: 연/월별 전체 제품 주문 개수(합계)
select 
    --extract(year from order_date)연, extract(month from order_date)월, sum(OI.quantity)합계
    기간,
     sum(quantity) 
from
    (
        select 
            --extract(year from O.order_date)연, extract(month from O.order_date)월, 
            to_char(order_date, 'yyyy-mm') 기간,
            OI.quantity
        from
            orders O
            inner join order_items OI on O.order_id = OI.order_id
    )
group by
    기간
order by
    기간;
    
--  to_char: 어떠한 값을 문자열로 바꾸는 명령 cf) 자바의 String.valueOf()
--  사용법: to_char(날짜, 형식)

select to_char(order_date, 'yyyy-mm') 기간 from orders order by order_date;




commit;



