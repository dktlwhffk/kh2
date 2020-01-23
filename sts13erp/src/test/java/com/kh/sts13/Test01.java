package com.kh.sts13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts13.entity.ProductDto;
import com.kh.sts13.repository.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
public class Test01 {
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void registTest() {
		ProductDto dto =  new ProductDto();
		dto.setName("포카리스웨트");
		dto.setPrice(1100);
//		dto.setWhen("20200105");
		productDao.regist(dto);
	}
}
