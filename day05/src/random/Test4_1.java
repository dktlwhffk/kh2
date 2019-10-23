package random;

import java.lang.*;
import java.util.*;

public class Test4_1 {
	public static void main(String[] asrg) {
//		랜덤으로 앞 또는 뒤 라는 글자 중 1개를 화면에 출력하고 싶습니다.

		Random r = new Random();

		int coin = r.nextInt(2) + 1;

//		System.out.println(coin);
		
//		1=앞 2=뒤
		
		if (coin == 1) {
			System.out.println("앞");
		} else {
			System.out.println("뒤");
		}

	}
}
