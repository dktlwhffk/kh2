package com.kh.sts13.repository;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.sts13.entity.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//RowMapper = 변환기(Database row ---> DTO/VO)
	private RowMapper<ProductDto> mapper = new RowMapper<ProductDto>(){
		@Override
		public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return ProductDto.builder()
					.no(rs.getInt("no"))
					.name(rs.getString("name"))
					.price(rs.getInt("price"))
					.when(rs.getString("when"))
					.build();														
		}
	};
	@Override
	public void regist(ProductDto productDto) {
		String sql="insert into product values(product_seq.nextval, ?, ?, sysdate)";
		Object[] param = {productDto.getName(), productDto.getPrice()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<ProductDto> getlist() {
		String sql = "select*from product order by no";
		List<ProductDto> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	@Override
	public List<ProductDto> getsearch(String keyword) {
		String sql = "select*from product where name like '%'||?||'%'";
		Object[] param = {keyword};
		List<ProductDto> search = jdbcTemplate.query(sql, param, mapper);
		return search;
	}
	
}
