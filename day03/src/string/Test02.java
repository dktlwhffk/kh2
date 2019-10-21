package string;

import java.lang.*;

public class Test02 {
	public static void main (String [] asrg) {
		//K라는 알파벳을 변수에 저장한 뒤 다음을 검사하여 출력
//		1. 변수에 저장된 데이터가 "대문자 알파벳"인지 검사 후 출력
//		2. 변수에 저장된 데이터가 "소문자 알파벳"인지 검사 후 출력
//		3. 변수에 저장된 데이터가 "알파벳"인지 검사 후 출력
		
			char letter = 'd';
			
			boolean capital = 'A'<=letter&&letter<='Z';
			System.out.println(capital);
			
			boolean small = 97<=letter && letter <=122;
			System.out.println(small);
			
			boolean alphabet = capital || small;
			System.out.println(alphabet);
			
			if(small) {System.out.println("소문자 입니다.");}
			else {System.out.println("대문자 입니다.");}
	
			// 문제: 위의 글자가 한글인지 검사하여 출력
			boolean korean = '가'<=letter&&letter<='힣';
			
			if(korean) {
				System.out.println("한글입니다.");
			}
		}
	}
