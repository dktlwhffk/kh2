package oop.constructor2;

import java.util.Scanner;

public class Test01 {
public static void main(String[] args) {
//	사용자에게 필요한 정보를 입력받아서 회원 1명을 생성 후 출력
//	아이디 비밀번호 닉네임 권한 포인트
//	권한은 사용자가 입력하면 해당하는 권한으로 설정
//	권한을 입력하지 않으면 "엔터"으로 설정
//	포인트는 무조건 0으로 생성
//	닉네임은 2~7글자로만 설정
	member a=new member();
	
	Scanner sc=new Scanner(System.in);
	String id=sc.next();
	String password=sc.next();
	String nick=sc.next();
	String authority=sc.next();
	sc.close();
	a.set(id, password, nick, authority, 0);
	
	a.print();
	
}
}
