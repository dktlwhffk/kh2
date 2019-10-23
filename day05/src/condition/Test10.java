package condition;

import java.lang.*;
import java.util.*;

public class Test10 {
	public static void main(String[] arsg) {
//		2와 3 모두의 배수인 경우 6, 12
//		2의 배수이지만 3의 배수는 아닌 경우 4, 8
//		3의 배수이지만 2의 배수는 아닌 경우 3, 9
//		둘다 아닌 경우 5, 7

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n % 6 == 0) {
			System.out.println(n + ", 2와 3의 배수입니다");
		} else if (n % 2 == 0) {
			System.out.println(n + ", 2의 배수이지만 3의 배수는 아닙니다");
		} else if (n % 3 == 0) {
			System.out.println(n + ", 3의 배수이지만 2의 배수는 아닙니다");
		} else {
			System.out.println(n + ", 둘다 아닙니다");
		}
	}
}