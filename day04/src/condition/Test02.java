package condition;

import java.lang.*;
import java.util.*;

public class Test02 {
	public static void main(String[] args) {
//		60점 이상이면 "통과입니다"를 출력, 아니면 "재평가를 보셔야합니다."

		Scanner sc = new Scanner(System.in);

		int score = sc.nextInt();
		sc.close();
//		if (score>=60) {
//			System.out.println("통과입니다.");
//		}
//		
//		if (score<60 ) {
//			System.out.println("재평가를 보셔야 합니다.");
//		}

		if (score >= 60) {
			System.out.println("통과입니다.");
		} else {
			System.out.println("재평가를 보셔야 합니다.");
		}

	}
}
