package home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller{

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "/WEB-INF/view/index.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
