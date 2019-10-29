package loop;

import java.lang.*;
import java.util.*;

public class Test30 {
	public static void main(String[] asrg) {
//	로또 1등에 당첨될 확률이 0.02%라고 가정합니다.
//		로또는 한 장에 1000원입니다.
//		로또에 당첨되기 위해 필요한 금액을 시뮬레이션으로 계산하여 출력하세요.(1000번정도 테스트하여 평균값을 출력)

		Random r = new Random();

		int count = 0;
		int avg = 0;
		int test = 0;
		for (int i = 1; i >= 1; i++) {
			int win = r.nextInt(10000) + 1;
			count++;
			if (win == 1 || win == 2)
				break;
		}
		int cost = 1000 * count;
		System.out.println("시도 횟수: " + count + " 금액: " + cost);
//		while(true) {
//			test+=1;			
//			if (test==1000) break;
//		}		
	}
}