package com.kh.sts15.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts15.dto.MemberProfileDto;

@Repository
public class MemberProfileDaoImpl implements MemberProfileDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void regist(MemberProfileDto memberProfileDto) {
		String sql = "insert into member_profile values(member_profile_seq.nextval,?,?,?)";
		Object[] param = {memberProfileDto.getProfile_uploadname(),
								memberProfileDto.getProfile_size(),
								memberProfileDto.getMember_no()};
		jdbcTemplate.update(sql, param);
	}
}


