package loop;

import java.lang.*;
import java.util.*;

public class Test25 {
	public static void main(String[] asrg) {
//		주사위 2개를 던져 같은 숫자가 연속으로 2번 나와야 탈출가능
//		주사위를 몇번 던져야 탈출 가능한지 계산하는 프로그램 구현
		Random r1 = new Random();
		int max = 5;
		int count = 0; // 2개가 같은경우
		int count1 = 0; // 2개가 2번 나온 경우
		while (true) {
			int dice1 = r1.nextInt(6) + 1;
			int dice2 = r1.nextInt(6) + 1;
			count1 += 1;
//			System.out.println(dice1 + " / " + dice2);
			if (dice1 == dice2) {
				count += 1;
			} else {
				count = 0;
			}
			if (count == max)
				break;
		}
		System.out.println("던진 횟수= " + count1);
	}
}