package array;

import java.lang.*;
import java.util.*;

public class Test19 {
	public static void main(String[] asrg) {
//		버블 정렬을 이용하여 3,5,2,1,4를 정렬하세요

		int[] data = new int[] { 3, 5, 2, 1, 4,9,66,123,125,577,796,6142 };

		for (int j = 1; j < data.length; j++) {
			for (int i = 0; i < data.length - j; i++) {
				if (data[i] > data[i + 1]) {
//				data[4]와 data[i]의 자리를 바꿔라
					int a = data[i];
					data[i] = data[i + 1];
					data[i + 1] = a;
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}