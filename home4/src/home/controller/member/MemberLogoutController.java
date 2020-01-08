package home.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.controller.Controller;

public class MemberLogoutController implements Controller{

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		session.removeAttribute("id");
		session.removeAttribute("grade");
		return "redirect:/index.do";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
