package condition;

import java.lang.*;
import java.util.*;

public class Test04 {
	public static void main(String[] asrg) {
//		사용자에게 생년월일 8자리를 입력받습니다.
//		생년월일이 다음 조건에 해당되면 할인을 진행
//		-21세기 출생자(20xxxxxx)	5천원
//		-여름에 태어난 사람(6,7,8)		10% 할인
//		10만원인 물건을 구매할 때 사용자의 생년월일에 따른 결제금액을 구하여 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("금액을 입력하세요.");
		int cost = sc.nextInt();
		System.out.println("생년월일 8자리를 입력하세요.");
		int birth = sc.nextInt();

		sc.close();

		int d1 = 5000; // 연도 할인
		double d2 = 0.9; // 여름 할인률

//		int cost = 100000; //구매금액
		int year = birth / 10000;
		int month = (birth % 10000) / 100;

//		경우의 수: 
//		21세기 출생자 /여름 아님 d1
//		21세기 출생자 /여름 d1 d2
//		21세기 출생자 아님 /여름  d2
//		21세기 출생자 아님/여름 아님 x

		if (year >= 2000 && !(month == 6 || month == 7 || month == 8)) {
			System.out.println((int) (cost - d1));
		} else if (year >= 2000 && (month == 6 || month == 7 || month == 8)) {
			System.out.println(((int) (cost - d1)) * d2);
		} else if (year < 2000 && (month == 6 || month == 7 || month == 8)) {
			System.out.println(((int) (cost * d2)));
		} else
//		(year<2000 && !(month ==6 || month ==7 || month ==8)) 
		{
			System.out.println((int) (cost));
		}
	}
}
