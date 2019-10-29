package array;

import java.lang.*;
import java.util.*;

public class Test14 {
	public static void main(String[] asrg) {
//		Test13.java와 같은 형태의 배열을 준비한 뒤 이 배열을 "무작위"로 섞어서 출력
//		무작위라는 것은 너무 추상적인 단어이므로 다음과 같이 정의합니다.
//		- 모든 자리가 1번씩 위치가 바뀌어야 합니다.
//		- 바뀔 대상의 자리는 같은 자리일 수 없습니다.(예 : 1번 위치와 1번 위치 교체는 불가)
//		- 즉, 모든 자리가 1번씩 자신이 아닌 다른 위치와 교체되면 "무작위"로 섞였다고 간주합니다.
		Random r = new Random();

		String[] snack = new String[] { "치토스", "허니버터칩", "새우깡", "프링글스", "스윙칩" };
		for (int i = 0; i < snack.length; i++) {
			int x = r.nextInt(snack.length);
			int target = i;
			if (target == x) i--;
			String t = snack[x];
			snack[x] = snack[target];
			snack[target] = t;
		}
		for (int i = 0; i < snack.length; i++) {
			System.out.println(snack[i]);
		}
	}
}