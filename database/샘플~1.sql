create view practice as select no, name, id from kh_member;
drop view v1;
select*from practice2;

create view practice2 as select no, name from SNACK;

create or replace view total as select practice.no, practice2.name from practice inner join practice2 on practice2.no = practice.no;
 select*from total;
 
 create view total2 as select practice.no, practice.name �̸�, snack.name ��ǰ�� from practice inner join snack on snack.no = practice.no;
 select * from total2;
 
 union ���� sql ���� ����� ���� ������ �ߺ�����
 union all ���� sql ���� ����� ���� ������ �ߺ����ž���
 intersection ���� sql���� ����� ���� ������ �ߺ�����
 minus ���� sql���� ����� ���� sql���� ��� ������ ������ �ߺ�����