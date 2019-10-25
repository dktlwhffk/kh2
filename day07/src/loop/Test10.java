package loop;

import java.lang.*;
import java.util.Scanner;

public class Test10 {
	public static void main(String[] asrg) {
//		사용자에게 5개의 숫자를 입력받아 입력받은 모든 값의 합계와 평균을 출력

		int total = 0;
		int count = 5;
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("다섯 개의 숫자를 입력하시오");
		for (int i = 1; i <= count; i++) {
			System.out.println("숫자 입력");
			double input = sc.nextInt();
			total += input;
		}
		sc.close();
		
		double average=(double)total/count;
		System.out.println("합계= "+total);
		System.out.println("평균= "+average);
	}
}