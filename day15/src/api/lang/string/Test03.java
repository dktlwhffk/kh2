package api.lang.string;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//		사용자에게 아이디와 비밀번호를 입력받아 로그인을 처리하는 프로그램 구현
//		-아이디는 대소문자 상관없으며, "khacademy"라는 글자일 경우만 통과
//		-비밀번호는 대소문자를 지켜야하며 "Student"라는 글자일 경우만 통과
//		로그인 성공/실패를 판정한뒤 사용자에게 메세지 출력
		
		Scanner sc=new Scanner(System.in);
		System.out.println("아이디와 비밀번호를 입력하세요");
		String id=sc.next();
		String pw=sc.next();
		sc.close();
		
//		if(id.equalsIgnoreCase("khacademy")) {
////			System.out.println(id);
//		} else {
//			System.out.println("아이디가 잘못되었습니다");
//		}
//		if(pw.equals("Student")) {
////			System.out.println(pw);
//		} else {
//			System.out.println("비밀번호가 잘못되었습니다");
//		} //보안성때문에 생략
		
		if(id.equalsIgnoreCase("khacademy")&&pw.equals("Student")) {
			System.out.println("로그인 성공!");
		} else {
			System.out.println("로그인 실패!");
		}

	}
}