package com.kh.sts13.repository;

import java.util.List;

import com.kh.sts13.entity.ProductDto;

public interface ProductDao {
	void regist(ProductDto productDto);
	List<ProductDto> getlist();
	List<ProductDto> getsearch(String keyword);
}
