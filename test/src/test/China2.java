package test;

import java.lang.*;

public class China2 {
	public static void main(String[] args) {
//		자주 나오는 값들을 이름을 붙여 저장하고 불러오도록 변경
// 		5000*3, 6000*2
		int a = 5000*3; //int 라는 크기를 가진 a에 5000*3을 계산해서 넣어라
		System.out.println(a);
		
		int b = 6000*2;
		System.out.println(b);
		
		int c = a + b;
		System.out.println(c);
		
		int d = c-3000;
		System.out.println(d);
		
		double e = d * 0.9;
		int f = d * 90/100;
		System.out.println(e);
		System.out.println(f);
		
	}
}
