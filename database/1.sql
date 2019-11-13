select username from dba_users;

--계정 잠금 해제
alter user hr account unlock;
alter user hr identified by hr;