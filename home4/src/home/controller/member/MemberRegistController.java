package home.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.controller.Controller;

public class MemberRegistController implements Controller{

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "/WEB-INF/view/member/regist.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
