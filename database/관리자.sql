--���� ����Ǯ�̿� ���� ����
create user hr2 identified by h2;
grant connect, resource, dba to hr2;
-- create new user
CREATE USER OT IDENTIFIED BY test;

-- grant priviledges
GRANT CONNECT, RESOURCE, DBA TO OT;
