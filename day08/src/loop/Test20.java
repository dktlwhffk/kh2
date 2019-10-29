package loop;

import java.lang.*;
import java.util.*;

public class Test20 {
	public static void main(String[] asrg) throws InterruptedException {
//		중첩 반복문
//		화면에0시0분0초부터 23시59분59초까지 출력하세요

		for (int t = 0; t <= 23; t++) {
			for (int m = 0; m <= 59; m++) {
				for (int s = 0; s <= 59; s++) {
					System.out.println(t + "시" + " " + m + "분" + " " + s + "초");
					Thread.sleep(1000L);
				}
			}
		}
	}
}