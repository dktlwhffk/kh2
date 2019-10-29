package array;

import java.lang.*;
import java.util.*;

public class Test03 {
	public static void main(String[] asrg) {
//		변수: 단일 저장소
//		배열: 다중 저장소

//		예: 배열을 이용하여 숫자 5개를 저장 후 출력
//		->배열을 5칸 만든다
//		->t라는 리모컨 --------------->[0][0][0][0][0]
		int[] t = new int[5];
		int size = 5;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자" + size + "개를 입력하세요");
		for (int i = 0; i < size; i++) {
			t[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < size; i++) {
			System.out.println("t[" + i + "]=" + t[i]);
		}

		int total = 0;
		for (int i = 0; i < size; i++) {
			total += t[i];
		}
		System.out.println("total= " + total);
	}
}