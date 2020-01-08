package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns = {
//	"/admin/*",	
//	"/member/info.jsp",
//	"/member/change_info.do",
//	"/member/change_info.jsp",
//	"/member/check.do",
//	"/member/check.jsp",
//	"/member/exit.do",
//	"/member/logout.do",
//	"/member/change_pw.jsp",
//	"/member/change_pw.do",
//	"/member/change_pw_result.jsp"
//})
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		목표 : session을 검사해서 로그인 여부를 판정한 뒤 상황에 맞게 처리
//		세션을 가져오려면
//		1. request를 HttpServletRequest 형태로 다운캐스팅
//		2. session을 1번에서 추출
		
		HttpServletRequest req = (HttpServletRequest) request;//1
		HttpSession session = req.getSession();//2
		
		String id = (String) session.getAttribute("id");
		
		if(id != null) {//로그인 상태라면 --> 통과
			chain.doFilter(request, response);
		}
		else {//로그인 상태가 아니라면 --> 로그인 페이지로 리다이렉트
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
		}
	}
	
}



