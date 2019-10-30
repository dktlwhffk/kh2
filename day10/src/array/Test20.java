package array;

import java.lang.*;
import java.util.*;

public class Test20 {
	public static void main(String[] asrg) {
//		삽입 정렬을 이용하여 3,5,2,1,4 를 정렬하여 출력하세요
		int data[] = new int[] { 3, 5, 2, 1, 4 };
		
//		1회차
		int a = data[1];
		if (a < data[0]) {
			data[1] = data[0];
			data[0] = a;
		}// 3 5 2 1 4
		
		//2회차
			a = data[2]; // 비교위치를 int a에 저장 / 비교위치는 회차-1
		if (data[1] > data[2]) {
			data[2] = data[1]; 
		}//3 2 5 1 4
		if (a < data[0]) {
			data[1] = data[0];
			data[0] = a;
		}//2 3 5 1 4
		
		//3회차
		a = data[3];
		if (data[2] > data[3]) {
			data[3] = data[2]; 
		}//2 3 1 5 4
		if (a < data[1]) {
			data[2] = data[1];
			data[1] = a;
		}//2 1 3 5 4
		if (a < data[0]) {
			data[1] = data[0];
			data[0] = a;
		}//1 2 3 5 4
		
//		4회차
		a = data[4]; //a=4
		if (data[3] > data[4]) {
			data[4] = data[3]; 
		} //1 2 3 4 5
			data[3]=a;
		
//		if (a < data[2]) {
//			data[3] = data[2]; 
//			data[2]=a;
//		}
//		if (a < data[1]) {
//			data[2] = data[1];
//			data[1] = a;
//		}
//		if (a < data[0]) {
//		data[1] = data[0];
//		data[0] = a;
//		}
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
