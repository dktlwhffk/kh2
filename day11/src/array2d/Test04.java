package array2d;

import java.lang.*;
import java.util.*;

public class Test04 {
	public static void main(String[] asrg) {

		int a[][] = new int[5][5];

//		Random r = new Random();
//		for (int j = 0; j < a.length; j++) {
//			for (int i = 0; i < a.length; i++) {
//				int x=r.nextInt(25)+1;
//				a[j][i] = x;
//				if(x==a[j+1][i+1]) {
//					i--;
//				}
//			}
//		}
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a[j].length; i++) {
//				int bingor = r.nextInt(5);
//				int bingoc = r.nextInt(5);
				System.out.print(a[j][i] + "\t" + "\t");
			}
			System.out.println();
		}
	}
}
