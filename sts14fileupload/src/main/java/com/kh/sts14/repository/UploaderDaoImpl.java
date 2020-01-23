package com.kh.sts14.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts14.dto.UploaderDto;

@Repository
public class UploaderDaoImpl implements UploaderDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getSequence() {
		String sql = "select uploader_seq.nextval from dual";
		int no = jdbcTemplate.queryForObject(sql, Integer.class);
//		int no = jdbcTemplate.queryForInt(sql);
		return no;
	}

	@Override
	public void regist(UploaderDto uploaderDto) {
		String sql = "insert into uploader values(?,?)";
		Object[] param = {uploaderDto.getNo(), uploaderDto.getName()};
		jdbcTemplate.update(sql, param);
	}

}
