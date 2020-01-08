package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		//필터가 최종 소멸될 때 1회 호출되는 메소드
		// - 초기화했던 내용 중 정리할 것들이 있다면 정리하는 코드 작성
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//목표 : 관리자인지 아닌지 검사하여 차단 설정
		// - session의 grade 값이 "관리자" 일 때
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();		
		String grade = (String) session.getAttribute("grade");
		
		if(grade.equals("관리자")) {//관리자일 경우 통과
			chain.doFilter(request, response);
		}
		else {//사용자에게 403 에러 송출
			resp.sendError(403);			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터가 최초 실행될 때 1번 실행되는 구문
		// - 파일을 불러온다던가... DB에서 설정을 불러온다던가...
		// - 초기화 작업 코드를 작성
	}

	

}
