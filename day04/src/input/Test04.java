package input;

import java.lang.*;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		숫자를 입력받는 방법
//		1.문자열 입력받아서 바꾸는 방법
//		2.숫자를 입력받는 방법

		Scanner sc = new Scanner(System.in);

		String a = sc.next();
//		int b = a;
//		int b = (int)a;
		int b = Integer.parseInt(a); // a를 int로 바꾸세요
		System.out.println(b);

//		--------------------------밑에 명령문을 주로 쓸 예정
		int c = sc.nextInt();
		System.out.println(c);

		sc.close();
	}
}
