package loop;

import java.lang.*;
import java.util.*;

public class Test29 {
	public static void main(String[] asrg) {
//		do~while 반복구문
//		-do 구문을 실행해보고 반복 여부를 판정

		Scanner sc = new Scanner(System.in);
//		do while문을 이용하여 점수 입력받기
		int score;

//		do: 반복 전에 선행되어야 할 내용을 작성
		do {
			System.out.println("점수 입력");
			score = sc.nextInt();
		}
//		while: 반복을 수행할 조건
		while (score < 0 || score > 100);

		System.out.println("입력 점수: " + score);

		sc.close();
	}
}