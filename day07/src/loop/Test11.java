package loop;

import java.util.Random;
import java.util.Scanner;
//구구단 문제
public class Test11 {
	public static void main(String[] asrg) {

		Scanner sc = new Scanner(System.in);
		int count = 0;
		for (int i = 1; i <= 5; i++) {
		Random r = new Random();
		int a = r.nextInt(8) + 2;
		int b = r.nextInt(9) + 1;
		System.out.print(a + "X" + b + "=");
		int answer = sc.nextInt();
		if (answer == a * b) {
		count ++;
		System.out.println("정답입니다.");
		} else {
		System.out.println("오답입니다.");
		}
		}
		sc.close();
		System.out.println();
		System.out.println("총 맞은 개수= " + count);
	}
}