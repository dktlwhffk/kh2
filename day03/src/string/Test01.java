package string;

import java.lang.*;

public class Test01 {
	public static void main(String [] asrg) {
		//문자(char), 문자열(String)
		//문자: 숫자 번호가 부여되어 있으므로 숫자(정수)로 간주
		//-한글(유니코드)도 기본 탑재
		
		char a = 100;
		System.out.println(a);
		
		char b =90;
		System.out.println(b);
		
		char c = 'd';
		System.out.println(c);
		
		char d = 55203;
		System.out.println(d);
		
		int e = d;
		System.out.println(e);
		
		System.out.println((char)55203);
	
	}
}
