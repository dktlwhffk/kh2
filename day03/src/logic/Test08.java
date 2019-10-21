package logic;

import java.lang.*;

public class Test08 {
	public static void main(String [] asrg) {
		
		//홀수 이지만 3의 배수는 아닌 숫자를 판정할 수 있는 프로그램 구현
		//279 라는 숫자를 이용하여 위의 프로그램을 실행한 뒤 결과 출력
		//--------------------------------------------------------------------
		//2의 배수는 곧 짝수, 3의 배수는 안되야 함 즉 2의배수 그리고 3의 배수의 전체 부정문
		
		int number = 3;
		
		boolean result = number%2==1 && !(number%3==0);
		
		System.out.println(result);
		
		
	}
}
