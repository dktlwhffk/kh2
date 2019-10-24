package loop;

import java.util.Random;

public class Test06 {
	public static void main(String[] arsg) {
//		주사위 2개를 10번 던졌을 때"똑같은 숫자"가 나온 경우를 세서 출력

		Random r = new Random();

		int count=0;
		
		for (int i = 1; i <= 10; i++) {
			int dice1 = r.nextInt(6) + 1;
			int dice2 = r.nextInt(6) + 1;
//			System.out.print(dice1+" ");
//			System.out.println(dice2);
			if (dice1 == dice2) {
				count++;
			}
		}
		System.out.println(count);
	}
}