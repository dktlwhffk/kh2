------------------------------------------------------------------------------------------------------------------------------------
--�ܷ�Ű ����
--          �ܷ�Ű ���� �� ������ ���õ� ������ ������ �� �ִ�.
--          on delete cascade       ���� ��ҵ� �Բ� ����
--          on delete set null         ���� ����� �ܷ�Ű�� null�� ó��
------------------------------------------------------------------------------------------------------------------------------------

--�п� ���̺� ����
create table academy(
no number primary key,
name varchar2(30) not null
);

--�л� ���̺� ����
drop table student;
create table student(
stdno number primary key,
stdname varchar2(30) not null,
--academy constraint fk_student_academy references academy(no)
--academy constraint fk_student_academy references academy(no) on delete cascade
academy constraint fk_student_academy references academy(no) on delete set null
);

insert into academy values(1, 'KH�����');
insert into student values(1,'���۸�',1);
insert into student values(2,'��Ʈ��',1);
insert into student values(3,'������',1);
commit;

select*from student;
delete academy where no=1;

------------------------------------------------------------------------------------------------------------------------------------
--  ����Ű : �������� �׸��� ��� primary key�� ����ϴ� ���
--          ��) ��¥+����, �г�+��+��ȣ 
------------------------------------------------------------------------------------------------------------------------------------
drop table school;
create table school(
grade number,
class number,
no number,
--����Ű �������� �߰�
CONSTRAINT pk_school primary key(grade,class,no)
);
 insert into school values(1,1,1);
 insert into school values(1,1,2);
 
 ------------------------------------------------------------------------------------------------------------------------------------
 --PLSQL : ����Ŭ�� �����ϴ� ���α׷��� ����
 ------------------------------------------------------------------------------------------------------------------------------------
 
 --��Ȳ: �Խñ۰� ��� ���̺� ����
 drop table reply;
 drop table board;
 create table board(
 no number primary key,
 title varchar2(30) not null,
 --��� ���� ���� ����(���� ����� ����) ������ȭ ����
 replycount number default 0 not null
 );
 
 create table reply(
 no number primary key,
 content varchar2(100) not null,
 board constraint fk_reply_board references board(no)
 );
 
insert into board(no,title) values(1,'1���Խñ�');
insert into board(no,title) values(2,'2���Խñ�');

select*from board;
select*from reply;
--��� ����� ���ؼ��� insert+update �� ����

insert into reply values(1,'1�� ���',1);
update board set replycount=replycount + 1 where no = 1;

--PL/SQL�� ����
BEGIN
    insert into reply values(2,'2�����',1);
    update board set replycount= replycount+1 where no =1;
END;

--�̸��� �ο��Ͽ� ���� (stored)���ν���(procedure)�� ����
create or replace procedure reply_insert 
(
    reply_no IN number , 
    reply_content IN varchar2,
    board_no IN number
)
IS
BEGIN
    insert into reply values(reply_no,reply_content,board_no);
    update board set replycount= replycount+1 where no =1;
END;

-- ���ν��� ȣ��
EXEC reply_insert(3,'3�����',1);

commit;

-- out �Ű����� Ȯ���� ���� ���� ���ν��� ����
-- �Խñ� ���� ��� ���� ��ȸ�ϱ� ���� ���ν���

--�͸� ���ν���
DECLARE
    board_count number;
    reply_count number;
BEGIN
    --board�� count �� ���Ͽ� board_count�� �����϶�
    select count(*) into board_count from board;
    select count(*) into reply_count from reply;
    dbms_output.put_line('�Խñ� �� : '|| board_count);
    dbms_output.put_line('��� �� : '|| board_count);
END;

--  �������ν���
create or replace procedure get_count
(   
    board_count OUT number,
    reply_count OUT number
)
IS
BEGIN
    --board�� count �� ���Ͽ� board_count�� �����϶�
    select count(*) into board_count from board;
    select count(*) into reply_count from reply;
    dbms_output.put_line('�Խñ� �� : '|| board_count);
    dbms_output.put_line('��� �� : '|| board_count);
END;

-- ���� ���ν��� ȣ���� ���ؼ���
-- [1]���� 2���� �غ��Ѵ�
-- [2]���ν��� ȣ��� ����
-- [3]����� ���

DECLARE
    a number := 0;
    b number := 0;
BEGIN
    --a�� b�� ���״� ���⿡ �� ��Ƽ� ������
    get_count(a,b);
    dbms_output.put_line(a);
    dbms_output.put_line(b);
END;