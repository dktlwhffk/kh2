package loop;

import java.util.Random;
import java.util.Scanner;

public class Test17 {
	public static void main(String[] asrg) {
//		랜덤으로 1부터 1000사이의 정수를 추첨 / 총 10번의 기회 / 문제 맞추면 게임 종료
//		10번 기회중 정답 못맞추면 게임오버 / 기회 안에 맞추면 게임 클리어 

		Random r = new Random();
		int n = r.nextInt(1000) + 1;
//		System.out.println(n); 랜덤으로 뽑힌 수

		int count = 10;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= count; count--) {
		int player = sc.nextInt();
		if (n == player) {
			System.out.println("게임 클리어!");
			break;
		} else if (n > player) {
			System.out.println("업!");
		} else {
			System.out.println("다운");
		}
		}
		if (count == 0) {
		System.out.println("게임 오버");
		}
		sc.close();
	}
}