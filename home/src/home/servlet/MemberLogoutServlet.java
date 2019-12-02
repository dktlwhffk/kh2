package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그아웃 처리 서블릿
@WebServlet(urlPatterns="/member/logout.do")
public class MemberLogoutServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		세션에 들어있는 회원 로그인 정보를 삭제시킨 뒤 메인 페이지로 redirect 
		req.getSession().removeAttribute("id"); //id항목 삭제
		resp.sendRedirect(req.getContextPath()); //홈으로 리다이렉트
		req.getSession().removeAttribute("grade"); //grade항목삭제
	}
}
