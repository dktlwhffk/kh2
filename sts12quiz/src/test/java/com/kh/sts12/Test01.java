package com.kh.sts12;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts12.entity.MemoDto;
import com.kh.sts12.repository.MemoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
public class Test01 {
	@Autowired
	private MemoDao memoDao;
	
	//@Test
	public void registTest() {
		MemoDto dto = new MemoDto();
		dto.setContent("테스트");
		memoDao.regist(dto);
	}

	@Test
	public void listTest()	{
		List<MemoDto> list = memoDao.getList();
		for(MemoDto s : list) {
			System.out.println(s);
		}
	}
}
