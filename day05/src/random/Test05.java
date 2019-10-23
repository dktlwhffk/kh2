package random;

import java.lang.*;
import java.util.*;

public class Test05 {
	public static void main(String[] asrg) {
//		윷놀이 한턴을 구현
//		1. 그냥(도/개/걸/윷/모/빽도 중 1개가 랜덤으로 출력되는 프로그램을 구현)
//		2. 상대적으로 잘 나오고 안 나오는 항목들을 고려하여 출력하도록 구현

//		1번-------------------------------------------------
		Random r = new Random();

		int gamble = r.nextInt(6) + 1;
		// 1부터 6까지 순차적으로 도개걸윷모빽도
		String result;
		if (gamble == 1) {
			result = "도";
		} else if (gamble == 2) {
			result = "개";
		} else if (gamble == 3) {
			result = "걸";
		} else if (gamble == 4) {
			result = "윷";
		} else if (gamble == 5) {
			result = "모";
		} else {
			result = "빽도";
		}
		System.out.println(result);
	}
}
