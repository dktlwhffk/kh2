package loop;

import java.util.Scanner;

public class Test12_1 {
	public static void main(String[] asrg) {
//		끝말잇기 게임
//		필요한 값 = 사용자로부터의 단어 입력값 / 횟수:5번 / 제대로입력하든 잘못입력하든 5번 무조건 실행
//		제시어: 자바 
//		제대로 끝말이 이어지도록 입력한 횟수를 세어 출력 (끝말잇기 먼저 구현 후 5번 반복 시키기)
		Scanner sc = new Scanner(System.in);

		int count = 0;
		char first;
		char last;
		
		System.out.println("자바");
		for (int i = 1; i <= 5; i++) {
			System.out.println("단어를 입력하세요");
			String a = sc.next();
			System.out.println(a);
			first = a.charAt(a.length() - 1); // 그다음 마지막 단어
			last = a.charAt(0);
			if (first == last) {
				count++;
			}
		}
		System.out.println("제대로 입력한 횟수= " + count);
		sc.close();
	}
}