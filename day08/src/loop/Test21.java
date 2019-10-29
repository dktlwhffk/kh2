package loop;

import java.lang.*;
import java.util.*;

public class Test21 {
	public static void main(String[] asrg) {
//		총 5번의 회차 동안 주사위 2개를 3번 던져 나오는 모든 수의 합계를 출력

		Random r1 = new Random();
		Random r2 = new Random();

//		System.out.println(one+two); 주사위 2개를 던졌을 때의 합계
		int total = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				int one = r1.nextInt(6) + 1;
				int two = r2.nextInt(6) + 1;
				total += (one + two);
			}
			System.out.println(i + "회차" + " " + "합계= " + total);
		}
	}
}