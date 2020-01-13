package com.kh.sts10;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.sts10.entity.StudentVO;

@Controller
@RequestMapping("/param") //컨트롤러 대표 주소
public class ParamController {

	@RequestMapping("/test") //매핑 주소
	public String param() {
		return "param";
	}
//	방식1: 고전방식(jsp/servlet)
//	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String param(HttpServletRequest request) {
		String name=request.getParameter("name");
		int korean = Integer.parseInt(request.getParameter("korean"));
		int english = Integer.parseInt(request.getParameter("english"));
		
		System.out.println("name = "+name);
		System.out.println("korean = "+korean);
		System.out.println("english = "+english);
		System.out.println();
		
		return "redirect:/param/test";
	}
	
//	방식2: spring의 자동 설정을 이용
//	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String param(
			@RequestParam String name, 
			@RequestParam(required = false, defaultValue = "0") int korean, 
			@RequestParam int english) {
		System.out.println("name = "+name);
		System.out.println("korean = "+korean);
		System.out.println("english = "+english);
		System.out.println();
		
		return "redirect:test";
	}
//	방식3: dto를 이용한 방식
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String param(@ModelAttribute StudentVO studentVO) {
		System.out.println(studentVO);
		
		return "redirect:test";
	}
//	방식4: 주소형 변수(Pathvariable)를 사용하는 방법
//	-기존 주소: /param/test?name=aaa&korean=100&english=50
//	-변경 주소: /param/test/aaa/100/50
	@RequestMapping("/test2/{name}/{korean}/{english}")
	public String path(
			@PathVariable String name, 
			@PathVariable int korean, 
			@PathVariable int english) {
		System.out.println("name = "+name);
		System.out.println("korean = "+korean);
		System.out.println("english = "+english);
		System.out.println();
		
		return "redirect:/param/test";
	}
}
