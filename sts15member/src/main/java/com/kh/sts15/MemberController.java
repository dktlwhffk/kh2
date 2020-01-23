package com.kh.sts15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.sts15.dto.MemberDto;
import com.kh.sts15.service.MemberService;


@Controller
@RequestMapping("/regist")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		return "regist/home";
	}
	@PostMapping("/regist")
	public String regist(@ModelAttribute MemberDto memberDto) {
		System.out.println(memberDto.toString());
		memberService.store(memberDto);
		return "redirect:./";
	}
}
