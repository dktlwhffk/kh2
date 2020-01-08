package home.controller;

import home.controller.board.BoardListController;
import home.controller.member.MemberLoginController;
import home.controller.member.MemberLogoutController;
import home.controller.member.MemberRegistController;

/**
 * 컨트롤러 생성 공장
 *	- 주소를 이용해서 컨트롤러를 생성한 뒤 반환
 *	- 생성만 전담하는 클래스를 팩토리 클래스(factory class)라고 부른다
 */
public class ControllerFactory {
	//생성 메소드
	public static Controller create(String uri){
		switch(uri) {
		case "/index.do" : return new IndexController();
		case "/member/login.do" : return new MemberLoginController();
		case "/member/regist.do" : return new MemberRegistController();
		case "/member/logout.do" : return new MemberLogoutController();
		case "/board/list.do" : return new BoardListController();
		}
		return null;
	}
}



