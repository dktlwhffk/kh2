create view practice as select no, name, id from kh_member;
drop view v1;
select*from practice2;

create view practice2 as select no, name from SNACK;

create or replace view total as select practice.no, practice2.name from practice inner join practice2 on practice2.no = practice.no;
 select*from total;
 
 create view total2 as select practice.no, practice.name 이름, snack.name 제품명 from practice inner join snack on snack.no = practice.no;
 select * from total2;
 
 union 여러 sql 문의 결과에 대한 합집합 중복제거
 union all 여러 sql 문의 결과에 대한 합집합 중복제거안함
 intersection 여러 sql문의 결과에 대한 교집합 중복제거
 minus 앞의 sql문의 결과와 뒤의 sql문의 결과 사이의 차집합 중복제거