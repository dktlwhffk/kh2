package array;

import java.lang.*;
import java.util.*;

public class Test01 {
	public static void main(String[] asrg) {
//		변수: 단일 저장소
//		배열: 다중 저장소

//		예: 변수를 이용하여 숫자 5개를 저장 후 출력
		int a, b, c, d, e;

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 5개를 입력하세요");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		sc.close();
		System.out.println("a= " + a);
		System.out.println("a= " + b);
		System.out.println("a= " + c);
		System.out.println("a= " + d);
		System.out.println("a= " + e);

		int total = a + b + c + d + e;
		System.out.println("total= " + total);
	}
}