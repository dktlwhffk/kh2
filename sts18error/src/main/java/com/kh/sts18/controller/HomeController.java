package com.kh.sts18.controller;


import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/error1")
	public String error1() {
			int a = 10/0;
			return "error1";
	}
	
//	@ExceptionHandler(Exception.class)//예외 처리기
//	public String handler(Exception ex)	{//예외 객체
//		logger.error("예외 발생!", ex);
//		return "error/500";
//	}
}
