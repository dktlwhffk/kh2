package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/*")
public class EFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		사용자의 요청정보를 utf-8로 복원
		request.setCharacterEncoding("utf-8");
		
//		통과
		chain.doFilter(request, response);
	}

}
