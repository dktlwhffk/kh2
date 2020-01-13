package com.kh.sts10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 새롭게 배우는 컨트롤러의 형태
 * -기존에는 상속을 통해서 만드는 형태로 구현
 * -meta programming 방식을 사용(어노테이션, annotation)
 */

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String home(/*필요한 것만*/) /*필요한 예외만 전가*/{
		return "test";  //web-inf/views/test.jsp
	}
	
	@RequestMapping(value="/test2", method = RequestMethod.GET)
	public String home2() {
		return "test";
	}
}
