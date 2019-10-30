package array;

import java.lang.*;

public class Test16 {
	public static void main(String[] asrg) {

		int[] data = new int[] { 3, 5, 2, 1, 4, 92 };

		int max = data[0];
//		최대값 찾기
//		1. 맨 앞자리가 가장 크다고 가정
//		2. 뒤의 값들을 지속적으로 비교하여 더 큰 값이 나오면 교체 (for문)
//		
//		if(max<data[1]) {
//			max=data[1];
//		}
//		if(max<data[2]) {
//			max=data[2];
//		}										------>반복문으로
//		if(max<data[3]) {
//			max=data[3];
//		}
//		if(max<data[4]) {
//			max=data[4];
//		}
//		System.out.println("max= "+max);
		for (int i = 1; i < data.length; i++) {
			if (max < data[i]) {
				max = data[i];
			}
		}
		System.out.println("max= " + max);
	}
}
