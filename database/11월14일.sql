--ù��° ����
select
C.EMAIL �����ּ�,
C.FIRST_NAME||' '||LAST_NAME �̸�,
CUS.ADDRESS �ּ�
from
 customers CUS  inner join contacts C on (CUS.customer_id= c.contact_id) 
where C.EMAIL like '%microsoft.com%'
;

--�ι�° ����
select
W.warehouse_name ��������,
R.region_name ���,
C.country_name ����
from
    warehouses W inner join locations L on 
        (W.warehouse_id=L.location_id) 
            inner join countries C on
                (L.country_id=C.country_id)
                    inner join regions R on
                        (C.region_id=R.region_id)
order by ��������;

--����° ����: ��� ���� ���� ��ǰ ���� 5�� ���
--������: null�� ������������ ���� �����Ѵٴ� ���� ����
--�ذ�å1: null�� ���� ��ȸ, ����where
--�ذ�å2: null�� 0���� ġȯ

select rownum, I.* from(
   select 
I.quantity ���,
P.product_name ��ǰ��,
P.description ��ǰ����,
sum(I.quantity) ����հ�
from
    inventories I left outer join products P on
        (I.product_id=P.product_id) group by I.quantity, P.product_name, P.description
        order by ��� desc
) I where rownum<=5;

--�׹�° ����:2017�⿡ �ֹ��� �� �̸��� ���
select 
O.order_date �ֹ���¥,
CO.first_name||' '||last_name ����
from
    orders O inner join customers C on
        (c.customer_id=o.order_id) 
        inner join contacts CO on
                (c.customer_id=co.customer_id)
                where extract(year from O.order_date) = 2017 
                order by ����, �ֹ���¥;
                
--�ټ���° ����: �Ǹ����� ��� ��ǰ�� �з��� �̸��� ���
select distinct
C.category_name ī�װ�,
P.product_name ��ǰ��
from
    product_categories C inner join products P on
    (c.category_id = p.category_id) order by ī�װ�, ��ǰ��;

--������° ����: �ٷ��� �߿��� ���α׷��� ������ �ֽż����� ���
select 
job_title ��å,
first_name||' '||last_name �̸�,
email �̸���,
phone �޴���ȭ,
hire_date �Ի���
from
    employees where job_title like '%Programmer%' ;
    
--�׷칮�� 1��: ���� �������� ������ �ο����� ��ȸ
select 
    job_title ����,
    count(*) �ο���
from
    employees group by job_title order by ����;
    
--�׷칮�� 2��: â�� ��� ����(�հ�)
select distinct
    warehouse_id â���ȣ,
    sum(quantity)
from
    inventories group by warehouse_id order by warehouse_id;

--�׷칮�� 3��:������ â�� ����

select 
    C.country_name ������,
    count(*) â����
from
    countries C 
    inner join locations L on (c.country_id=L.country_id) 
    inner join warehouses W on (l.location_id=w.location_id) 
    group by C.country_name
    order by ������, â����;

--nvl(�׸�, ��ü��) = null�� ��ü���ִ� �Լ�

--�׷칮�� 4��:��ǰ�� �Ǹ� �ݾ� (�հ�)

--�׷칮�� 5��: ������ ��ҵ� ��ǰ �ֹ� �Ǽ�

--�׷칮�� 6��: ������ ��ҵ� ��ǰ �ֹ� ���� �հ�
select
    ����,
    sum(quantity) ��Ҽ���
from
    (
        select extract(year from order_date)����, O.*,OI.*
        from
            orders O
                left outer join order_items OI on O.order_id = OI.order_id
        where
            O.status = 'Canceled'
    )
group by ���� 
order by ���� asc;

--�׷칮�� 7��: ��/���� ��ü ��ǰ �ֹ� ����(�հ�)
select 
    --extract(year from order_date)��, extract(month from order_date)��, sum(OI.quantity)�հ�
    �Ⱓ,
     sum(quantity) 
from
    (
        select 
            --extract(year from O.order_date)��, extract(month from O.order_date)��, 
            to_char(order_date, 'yyyy-mm') �Ⱓ,
            OI.quantity
        from
            orders O
            inner join order_items OI on O.order_id = OI.order_id
    )
group by
    �Ⱓ
order by
    �Ⱓ;
    
--  to_char: ��� ���� ���ڿ��� �ٲٴ� ��� cf) �ڹ��� String.valueOf()
--  ����: to_char(��¥, ����)

select to_char(order_date, 'yyyy-mm') �Ⱓ from orders order by order_date;




commit;



