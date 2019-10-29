package array;

import java.lang.*;
import java.util.*;

public class Test02 {
	public static void main(String[] asrg) {
//		변수: 단일 저장소
//		배열: 다중 저장소

//		예: 배열을 이용하여 숫자 5개를 저장 후 출력
//		->배열을 5칸 만든다
//		->t라는 리모컨 --------------->[0][0][0][0][0]
		int[] t =new int[5];

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 5개를 입력하세요");
		t[0] = sc.nextInt();
		t[1] = sc.nextInt();
		t[2] = sc.nextInt();
		t[3] = sc.nextInt();
		t[4] = sc.nextInt();
		sc.close();
		System.out.println("t[0]= " + t[0]);
		System.out.println("t[1]= " + t[1]);
		System.out.println("t[2]= " + t[2]);
		System.out.println("t[3]= " + t[3]);
		System.out.println("t[4]= " + t[4]);

		int total = t[0] + t[1] + t[2] + t[3] + t[4];
		System.out.println("total= " + total);
	}
}