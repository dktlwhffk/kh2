package home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	컨트롤러(Controller)
 *	- 서블릿의 명령에 의해 비즈니스 로직을 수행하는 도구
 *	- GET/POST 처리명령을 각각 만들어둬야 편하다
 *	- 일을 하기위해서 필요한 도구가 있는가? 
 *		- 요청정보(request) , 응답정보(response)
 *	- 일을 하고나면 서블릿에게 보고해야할 데이터가 있는가?
 *		- 주소(String)
 */
public interface Controller {
	String doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	String doPost(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}














