package kh;

import java.util.Scanner;

public class Test01 {
public static void main(String[] args) throws Exception {
//	사용자에게 아이디, 비밀번호, 이름을 입력받아 등록하는 프로그램 구현
//	메소드 이름: regist
	
	KHMemberDao dao = new KHMemberDao();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("이름입력");
	String name =sc.next();
	System.out.println("아이디 입력");
	String id = sc.next();
	System.out.println("비밀번호 입력");
	String pw = sc.next();
	
	dao.regist(name, id, pw);
	sc.close();
	System.out.println("등록완료");
}
}
