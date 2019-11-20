package kh;

import java.util.List;
import java.util.Scanner;

public class Test04 {
public static void main(String[] args) throws Exception {
//	사용자에게 아이디와 비밀번호를 입력받아 로그인 처리를 수행하는 프로그램 구현
//	메소드 이름 : login
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("아이디를 입력하세요");
//	String id = sc.next();
//	System.out.println("비밀번호를 입력하세요");
//	String pw = sc.next();
//	sc.close();
//	
//	KHMemberDao dao = new KHMemberDao();
//	List<KHMemberDto> login = dao.login(id, pw);
//	KHMemberDto dto = new KHMemberDto();
	
	
		
	
		KHMemberDto dto = new KHMemberDto();
		dto.setId("rladnsrl");
		dto.setPw("rladnsrl");

		KHMemberDao dao = new KHMemberDao();
		boolean result = dao.login(dto);

		if(result) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("정보가 일치하지 않습니다");
		}
	}
}

