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
//[1] 상속을 받는다(javax.servlet.Filter)
//[2] 주소를 등록한다
//		- 주소를 만드는 것이 아니라 기존에 있는 주소를 검사
//[3] 메소드를 구현한다(doFilter)
//@WebFilter(urlPatterns = "/index.jsp")
public class TestFilter implements Filter{

	@Override
	public void doFilter(
			ServletRequest request, 	//요청 상위 객체
			ServletResponse response, //응답 상위 객체
			FilterChain chain)			//체인 정보 객체
			throws IOException, ServletException {
		System.out.println("테스트 필터 실행중!");
		
//		통과 명령
//		chain.doFilter(request, response);//가던길 가세요
		
//		강제이동 명령
//		- redirect는 HTTP 통신에만 존재(다른 방식에는 없음)
//		- HttpServletResponse에만 존재하는 기능
//		- 다운캐스팅 후 사용 가능
//		- request도 이렇게 사용 가능
//		HttpServletResponse resp = (HttpServletResponse) response;
//		resp.sendRedirect("/home/member/login.jsp");
//		resp.sendError(403);
	}

}
