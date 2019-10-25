package loop;

import java.lang.*;

public class Test14 {
	public static void main(String[] asrg) {
//		반복문에서 사용할 수 있는 특수한 키워드 2종류
//		break는 if를 제외한 가장 가까운 구문을 탈출 / continue는 if를 제외한 가장 가까운 반복구문의 처음으로 이동
//		int stop = 6;
//		
//		for (int i = 1; i <= 10; i++) {
//			if(i==stop) {
//				break;
//			}
//			System.out.println(i);
//		}
		int stop = 6;
		
		for (int i = 1; i <= 10; i++) {
			if(i==stop) {
				continue;
			}
			System.out.println(i);
		}
	}
}
