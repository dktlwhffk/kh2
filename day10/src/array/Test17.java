package array;

import java.lang.*;
import java.util.*;

public class Test17 {
	public static void main(String[] asrg) {
//		3,5,2,1,4를 배열에 저장하고 "가장 작은 값의 위치"를 구하여 출력
		int[] data = new int[] { 1, 5, 2, 4, 3,-1 };
		int min = data[0];

		int location = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] < min) {
				min = data[i];
				location = i;
			}
		}
		System.out.println("최소값= "+min + "위치= " + location);
	}
}
