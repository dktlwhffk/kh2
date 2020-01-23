package com.kh.sts14.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.sts14.dto.UploadFileDto;

@Repository
public class UploadFileDaoImpl implements UploadFileDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void regist(UploadFileDto uploadfileDto) {
		String sql = "insert into upload_file values(upload_file_seq.nextval, ?, ?, ?)";
		Object[] param = {uploadfileDto.getOrigin_name(), uploadfileDto.getStore_name(), uploadfileDto.getUploader()};
		jdbcTemplate.update(sql, param);
	}
}
