package random;

import java.lang.*;
import java.util.*;

public class Test03 {
	public static void main(String[] asrg) {
//		랜덤으로 구구단 문제 한개를 출제하는 프로그램을 구현
//		9X9 = ?

		Random r = new Random();

		int a = r.nextInt(18) + 2;
		int b = r.nextInt(18) + 2;
		
		if(a>=12 && b>=2) {
			System.out.println("어려운 문제! 보너스 점수가 있어요!");
		}
		System.out.print(a);
		System.out.print(" X ");
		System.out.println(b); 
		System.out.println(a*b);
	}
}