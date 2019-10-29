package array;

import java.lang.*;
import java.util.*;

public class Test11 {
	public static void main(String[] asrg) {
//		성적: 71점 89점 90점 92점 85점 92점 63점 99점 78점
//		80점 이상인 사람은 몇 명인지 세어서 출력
//		사용자에게 시험 점수를 입력받아 예상 등수를 출력

		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요!");
		int user = sc.nextInt();
		int[] score = new int[] { 71, 89, 90, 92, 85, 88, 92, 63, 99, 78, user }; // +91

//		System.out.println(score[0~8]>=80 총 몇명? count);
		int count = 0;
		for (int i = 1; i < score.length; i++) {
			if (score[i] >= 80) {
				count++;
			}
		}
		System.out.println("80점 이상인 사람= " + count + "명");
//		전체 개수에서 입력값보다 높은 개수 빼면 등수 (동점이 있는 경우 중복으로 계산)
		int rank = 1;
		for (int i = 1; i < score.length; i++) {
			if (user < score[i]) {
				rank++;
			}
		}
		System.out.println("등수= " + rank + "등");
		sc.close();
	}
}
