package com.kh.sts21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
public class Test02 {
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void sendMail()	{
		//메시지 객체 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		//정보 설정: 대상정보, 제목, 내용
		String[] to = {"dktlwhffk@naver.com"};
		message.setTo(to);
		
		String[] cc = {"dktlwhffk@gmail.com"};
		message.setCc(cc);
		
		String[] bcc = {"dktlwhffk@naver.com"};
		message.setBcc(bcc);
		
		message.setSubject("테스트 메일");
		
		message.setText("테스트 메일을 발송해봤습니다~ 참 쉽죠?");
		
		sender.send(message);
	}
}
