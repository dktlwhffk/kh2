package com.kh.sts11;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.sts11.entity.Student;
import com.kh.sts11.repository.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
public class Test04 {

//	크게 유연하게 의미로 StudentDao
//	autowired는 이어주는 어노테이션
	@Autowired
	private StudentDao studentDao;
	
	//@Test
	public void registTest() {
		Student student = new Student();
		student.setName("김용범");
		student.setScore(50);
		studentDao.regist(student);
	}
	@Test
	public void listTest() {
		List<Student> list = studentDao.getList();
//		System.out.println(list.size());
	}
	@Test
	public void searchTest() {
		
//		List<Student> search = studentDao.search("%"+"김"+"%");
		List<Student> search = studentDao.search("홍");
		for(Student s : search) {
			System.out.println(s);
		}
	}
	
}