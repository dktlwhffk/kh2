package com.kh.sts18.exception;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(annotations = Controller.class)
@ControllerAdvice(basePackages = {"com.kh.sts18"})
public class ErrorController {	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(SQLException.class)
	public String sqlHandler(Exception ex) {
		logger.error("DB예외 발생", ex);
			return "error/500";
	}
	@ExceptionHandler(Exception.class)//예외 처리기
	public String handler(Exception ex)	{//예외 객체
		logger.error("예외 발생!", ex);
		return "error/500";
	}
}
