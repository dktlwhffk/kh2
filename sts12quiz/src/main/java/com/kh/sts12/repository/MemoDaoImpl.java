package com.kh.sts12.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts12.entity.MemoDto;
import com.kh.sts12.entity.MemoDto.MemoDtoBuilder;

@Repository
public class MemoDaoImpl implements MemoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//RowMapper = 변환기(Database row ---> DTO/VO)
	private RowMapper<MemoDto> mapper = new RowMapper<MemoDto>(){
		@Override
		public MemoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MemoDto s = new MemoDto();
//			s.setNo(rs.getInt("no"));
//			s.setContent(rs.getString("content"));
//			s.setWhen(rs.getString("when"));
//			return s;
			return MemoDto.builder()
					.no(rs.getInt("no"))
					.content(rs.getString("content"))
					.when(rs.getString("when"))
					.build();														
			
		}
	};
	@Override
	public void regist(MemoDto memoDto) {
		String sql = "insert into memo values(memo_seq.nextval, ?, sysdate)";
		Object[] param = {memoDto.getContent()};
		jdbcTemplate.update(sql,param);
	}

	@Override
	public List<MemoDto> getList() {
		String sql = "select*from memo order by no desc";
		List<MemoDto> list = jdbcTemplate.query(sql, mapper);
		return list;
	}
}
