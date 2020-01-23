package com.kh.sts21.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts21.entity.CertDto;
import com.kh.sts21.repository.CertDao;
import com.kh.sts21.service.RandomService;

@Controller
@RequestMapping("/pw")
public class EmailPasswordController {
	
	@Autowired
	private RandomService randomService;
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private CertDao certDao;
	
	@GetMapping("/input")
	public String input() {
		return "pw/input";
	}
	
	@PostMapping("/input")
	public String input(@RequestParam String email) throws MessagingException {
		//1.랜덤번호를 3자리 생성
		String cert = randomService.generateCertificationNumber(3);
		
		//2.DB에 랜덤번호/이메일/시간 저장
		certDao.regist(CertDto.builder().email(email).cert_no(cert).build());
		
		//3.이메일 전송
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(email);
		helper.setSubject("비밀번호 변경 메일");
		
		String url = "http://localhost:8080/sts21/pw/change?cert="+cert+"&email="+email;
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>비밀번호 변경을 위해 하단 링크를 누르세요</h1>");
		buffer.append("<h2>");
		buffer.append("<a href='");
		buffer.append(url);
		buffer.append("'>");
		buffer.append("이동");
		buffer.append("</a>");
		buffer.append("</h2>");
		
		helper.setText(buffer.toString(), true);
		
		sender.send(message);
		
		//4.사용자화면 전환
		return "redirect:result";
	}
	
	@GetMapping("/result")
	public String result() {
		return "pw/result";
	}
	
	@GetMapping("/change")
	public String change( 
			@RequestParam String cert,
			@RequestParam String email) {
//		필요한 작업
//		-사용자가 이메일에서 링크를 누르면 이곳으로 들어온다.
//		-들어오면서 정상적인 링크라면 cert라는 param과 email이라는 param을 가지고온다
//		-위의 두 파라미터를 받아서 DB에 검증을 실시
		boolean enter = certDao.check(email, cert);
		if(!enter) {
//			에러코드 송출
//			resp.setStatus(403);
		}
		return "pw/change";
	}
}
