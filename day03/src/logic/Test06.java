package logic;

import java.lang.*;

public class Test06 {
	public static void main(String [] asrg) {
		//어떤 숫자가 2,3,5,7 의 배수일 경우 이 숫자는 "아리수"라고 합니다.
		//2730이 "아리수" 인지 판단하여 출력
//		-----------------------------------------------------------------------------
		//2730을 2,3,5,7 각각의 숫자로 나누었을 때 나머지가 0이면 배수관계 성립
		
		int a = 2;
		int b = 3;
		int c = 5;
		int d = 7;
		
		int number = 2730;
		
		boolean arisu = (number%a) == 0 
				                    && (number%b) == 0 
				                    && (number%c) == 0 
				                    && (number%d) == 0;
		//boolean arisu = number % (2*3*5*7) == 0;
		
		System.out.println(arisu);
		// 같지 않다 => !=
	}
}