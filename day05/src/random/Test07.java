package random;

import java.lang.*;
import java.util.*;

public class Test07 {
	public static void main(String[] asrg) {
//		지하철 요금표는 다음과 같다.
//		성인(20~64) 	1250원
//		청소년(14~19) 720원
//		어린이(8~13) 	450원
//		유아 및 노인		0원
//		사용자에게 생년월일 8자리를 입력받아 요금을 계산하고
//		서울지하철 창립 5주년을 맞아서 주사위를 던져 5가 나오면 10% 할인을 진행
//		최종 요금 계산하여 출력

		Scanner sc = new Scanner(System.in);
		int birth = sc.nextInt();
		sc.close();

		int age = (2019 - (birth / 10000)) + 1; // 나이계산식

		int price;
		if (20 <= age && 64 >= age) {
			price = 1250;
		} else if (14 <= age && 19 >= age) {
			price = 720;
		} else if (8 <= age && 13 >= age) {
			price = 450;
		} else {
			price = 0;
		}

		Random r = new Random();
		double discount;
		int percent = r.nextInt(6) + 1;
		if (percent == 5) {
			discount = price * 0.9;
		} else {
			discount = price;
		}

		System.out.println(discount);
	}
}
