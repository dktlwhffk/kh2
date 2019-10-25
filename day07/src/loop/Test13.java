package loop;

import java.util.Scanner;

public class Test13 {
	public static void main(String[] asrg) {
//		1.Factorial 계산기
//		어떤 수부터 1까지 곱한 결과(5!=5x4x3x2x1)
//		사용자에게 입력받은 숫자의 팩토리얼 값을 구해서 출력
//		2.피보나치 수열
//		황금비율 계산하는 숫자 모음
//		1번째와 2번째 자리 숫자가 1 / 3번째부터는 앞의 2개를 더한 결과
//		예:1,1,2,3,5,8,13.... 이 수열을 10번째 자리까지 화면에 출력하세요

//		문제 2

		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 1; i <= 10; i++) {
		a = b;
		b = c;
		c = a + b;
		System.out.println(c);
		}
	}
}

//1	1	2	3	5	8	13	21	34	55
//  a+  b = c	
//	    a+	b=	c
//			a+	b=	c
//				a+	b=	c
//					a+	b=	c
//						a+	b=	c
