package com.kh.sts15.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts15.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void regist(MemberDto memberDto) {
		String sql="insert into member values(member_seq.nextval,?,?,?)";
		Object[] param = {memberDto.getMember_id(), memberDto.getMember_pw(), memberDto.getMember_nick()};
		jdbcTemplate.update(sql,param);
	}
	@Override
	public int getSequence() {
		String sql = "select member_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql, Integer.class);

		return no;
	}

}
