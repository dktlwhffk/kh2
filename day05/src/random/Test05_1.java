package random;

import java.lang.*;
import java.util.*;

public class Test05_1 {
	public static void main(String[] asrg) {
//		윷놀이 한턴을 구현
//		1. 그냥(도/개/걸/윷/모/빽도 중 1개가 랜덤으로 출력되는 프로그램을 구현)
//		2. 상대적으로 잘 나오고 안 나오는 항목들을 고려하여 출력하도록 구현
//		3. 뒤집어질 확률 40 
//		2번-------------------------------------------------
		Random r = new Random();

		int gamble = r.nextInt(16) + 1;
		int shape = r.nextInt(10) + 1;
		
//		if (shape>=1 && shape<=4); int back = shape;
//		if (shape<=4 && shape<=10); int front = shape;
		// 16개의 경우 중에 각각의 경우의 수 도:3/16 개:6/16 걸:4/16 윷:1/16 모:1/16 빽도:1/16
		
			String result;
		if (gamble >= 1 && gamble <= 3) {
			result = "도"; //40 60 60 60
		} else if (gamble <= 9) {
			result = "개"; // 40 40 60 60
		} else if (gamble <= 13) {
			result = "걸"; // 40 40 40 60
		} else if (gamble == 14) {
			result = "윷"; // 40 40 40 40
		} else if (gamble == 15) {
			result = "모"; // 60 60 60 60
		} else {
			result = "빽도"; 
		}
		System.out.println(result);
	}
}
