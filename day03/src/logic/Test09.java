package logic;

import java.lang.*;

public class Test09 {
	public static void main(String [] asrg) {
		
		// &와 &&의 차이 => 
		//&는 양쪽을 다 실행해서 비교
		//&&는 불필요하다고 판간하는 경우 스킵한다.
		
//		int c = 1;
//		c=c+1; c=2
//		c++; c=3
		
		
//		true 라고 나오는 코드 값은? a=10 b=12
//		a와 b가 같고 a를 1증가시키면 b보다 큰가?
		int a =10; int b= 12;
		boolean r1=a==b&&++a>b;
		boolean r2=a==b&&++a>b;
		boolean r3=a==b&&++a>b;
		boolean r4=a==b&&++a>b;
		boolean r5=a==b&&++a>b;
		
		double n = 11.23;
		boolean test1 = n >= 10 || n <=12;
		boolean test2 = n >= 10 || n >=12;
		boolean test3 = n <= 10 || n <=12;
		boolean test4 = n <= 10 || n >=12;
		System.out.println(test4);
		
		
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		
	}
}
