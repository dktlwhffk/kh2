package logic;

import java.lang.*;

public class Test07 {
	public static void main(String [] asrg) {
		
		//or 연산 명령어  =  ||(역슬래쉬+shift)
		//목표: 어떤 사람의 나이가 "청소년"에 해당되지 않는지 확인
		//14세 미만 또는 20세 이상인 경우를 구해야함
		
		int age = 15;
		
		boolean result = 14>age || 20<=age;
//		boolean result = !(청소년입니까)
		boolean result1 = !(age>=14&&age<20);
		
		System.out.println(result);
		
	}
}
