package variable;

import java.lang.*;

public class Test04 {
	public static void main(String [] asrg) {
		
		//세 자리의 정수인 175라는 숫자가 있을 때 이 숫자를 각 자리별로 분해하여 출력
		
	int n = 175;
			
			System.out.println(n%10);
			n=n/10;
			System.out.println(n%10);
			n=n/10;
			System.out.println(n);
		
		
		
	}
}
