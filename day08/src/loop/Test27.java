package loop;

import java.lang.*;
import java.util.*;

public class Test27 {
	public static void main(String[] asrg) {
//		대칭문자열인지 판독하여 출력
//		대칭문자열은 좌우가 똑같은 문자열을 말한다.
//		"기러기"는 대칭문자열 "짝짝"도 대칭문자열
//		최소한 2글자 이상이어야 대칭문자열이 된다.
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		int len = word.length();
//		System.out.println(len);

		int count = 0;
		for (int i = 0; i < len / 2; i++) {
			int k = len - i - 1;

			char left = word.charAt(i);
			char right = word.charAt(k);
			if (left == right) {
//				System.out.println("같은 글자가 발견되었습니다");
				count++;
			}
		}
		System.out.println("word : " + word);
		System.out.println("같은 글자수 : " + count);
		if (count == len / 2) {
			System.out.println("대칭문자열입니다");
		} else {
			System.out.println("대칭문자열이 아닙니다");
		}
		sc.close();
	}
}
