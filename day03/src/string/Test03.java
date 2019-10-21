package string;

import java.lang.*;

public class Test03 {
	public static void main (String [] asrg) {
		//문자열: 자바에 존재하는 가장 특이한 형태
		//-기본 제공되는 자료형태가 아님
		//-기본 형태처럼 사용이 가능
		//-참조형 데이터(복잡한 데이터)
		
		String a = "hello";
		System.out.println(a);
		
		//특징: 참조형이기 때문에 각종 기능을 제공
		System.out.println(a.length());
		System.out.println(a.isEmpty());
		System.out.println(a.charAt(1));
		
		//문제: a의 마지막 글자를 화면에 출력
		System.out.println(a.charAt(a.length()-1));
		
		//특징 : 기본연산은 안되지만 특별히 "더하기"는 가능
		String b = "kh";
		System.out.println(b+"정보교육원");
		System.out.println(b+100); //String + int...등등 = 무조건 String
		int c =20; int d = 20;
		System.out.println("합계 = "+(c+d));
	}
}
