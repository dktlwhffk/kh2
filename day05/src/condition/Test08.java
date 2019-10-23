package condition;

import java.lang.*;
import java.util.*;

public class Test08 {
	public static void main(String[] arsg) {
//		사용자에게 시험점수를 입력받아서 출력하는 프로그램을 구현
//		만약 잘못된 점수가 입력되었다면"다시 입력하세요"를 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();

		sc.close();

		if (score >= 60 && score <= 100) {
			System.out.println(score + "점");
		} else if (score < 60) {
			System.out.println("재평가 대상자입니다");
		} else {
			System.out.println("다시 입력하세요");
		}
	}

}
