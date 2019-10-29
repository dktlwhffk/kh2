package loop;

import java.lang.*;
import java.util.*;

public class Test24 {
	public static void main(String[] asrg) {
//		주사위를 6이 나올때까지 던지는 프로그램 구현

		Random r = new Random();
		int count = 1;
		while (true) {
			int dice = r.nextInt(6) + 1;
			if (dice == 6) {
				System.out.println("주사위 눈= "+dice);
				break;
			}
			count++;
		}
		System.out.println("던진 횟수= " + count);
	}
}