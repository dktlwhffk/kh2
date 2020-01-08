package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

//필터(Filter)
//[1]상속을 받는다
//[2]주소를 등록한다
//	-주소를 만드는 것이 아니라 기존에 있는 주소를 검사
//[3]메소드를 구현한다
//@WebFilter(urlPatterns = "/index.jsp")
public class TestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
							//요청 상위 객체			응답 상위 객체			체인 정보 객체
			throws IOException, ServletException {
		System.out.println("테스트 필터 실행중!");
//		통과 명령
		arg2.doFilter(arg0, arg1);//가던길 가세요
		
//		강제이동 명령
//		HttpServletResponse resp = (HttpServletResponse) response;
//		resp.sendRedirect("home/member/login.jsp");
		
	}
	
}
