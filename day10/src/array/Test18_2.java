package array;

import java.lang.*;
import java.util.*;

public class Test18_2 {
	public static void main(String[] asrg) {
//		3,5,2,1,4를 배열에 저장하고 "가장 작은 값을 맨 앞에 위치"하도록 구현
//		"두번째 작은 값은 두 번째에 위치"하도록 구현
//		위와같이 진행하여 전체가 정렬되도록 구현하는 것이 목표
		int[] data = new int[] { 3, 5, 2, 1, 4 };
//		정렬
//		n번째 자리 정렬(n=0,1,2,3)
//		1.data[0]~data[4] 사이에서 가장 작은 수의 위치를 찾는다
//		2. 1번에서 찾은 위치와 data[0]을 교체한다.
		for (int n = 0; n <= 3; n++) {
			int index = n;
			for (int i = n + 1; i < data.length; i++) {
				if (data[index] > data[i]) {
					index = i;
				}
			}
//			System.out.println("index= " + index);
			int t = data[n];
			data[n] = data[index];
			data[index] = t;
		}
		for (int x : data) {
			System.out.println(x);
		}
	}
}
