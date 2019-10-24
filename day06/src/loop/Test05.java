package loop;

import java.lang.*;

public class Test05 {
	public static void main(String[] asrg) {
//		횟수측정
//		1부터100사이의 짝수 개수 세기
		int count;
		count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("횟수= " + count);
	}
}
