package com.kh.sts21;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Test01 {
	private JavaMailSender sender;
	
	@Before
	public void prepare() {
		//sender 준비
		 JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		 senderImpl.setHost("smtp.gmail.com");
		 senderImpl.setPort(587);
		 senderImpl.setUsername("testkimyb@gmail.com");
		 senderImpl.setPassword("admin8153");
				 
		 Properties prop = new Properties();
		 prop.put("mail.smtp.auth", true);
		 prop.put("mail.smtp.starttls.enable", true);
		 
		 senderImpl.setJavaMailProperties(prop);
		 
		 sender = senderImpl;
	}
	
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
