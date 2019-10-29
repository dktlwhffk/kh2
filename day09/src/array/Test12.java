package array;

import java.lang.*;
import java.util.*;

public class Test12 {
	public static void main(String[] asrg) {
//		이번주 로또번호를 추첨하여 화면에 출력
//		로또는 1부터 45까지 무작위로 6개의 숫자를 추첨
//		단, 똑같은 숫자는 나올 수 없습니다.

		Random r = new Random();
		int[] lotto = new int[6];

		lotto[0] = r.nextInt(45) + 1;

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			for (int k = 0; k < i; k++) {
				if (lotto[i] == lotto[k]) {
					System.out.println("중복!");
					i--;
					break;
				}
			}
			System.out.println(lotto[i]);
		}
	}
}
