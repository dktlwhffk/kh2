package array;

import java.lang.*;
import java.util.*;

public class Test20_1 {
	public static void main(String[] asrg) {
//		삽입 정렬을 이용하여 3,5,2,1,4 를 정렬하여 출력하세요
		int data[] = new int[] { 3, 5, 2, 1, 4 };
		
//		for(int j=1; j<data.length-1; j++) {
			for(int i=0; i<data.length-1; i++) {
				int a = data[i+1];
				if(a>data[i]) {
					data[i+1]=data[i];
					data[i]=a;
				} 
			}			
//		}
		

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
