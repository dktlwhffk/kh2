package array;

import java.lang.*;
import java.util.*;

public class Test08 {
	public static void main(String[] asrg) {
//		자바 파이썬 루비 HTML CSS
//		모든 단어 출력
//		모든 단어별 글자수 출력
//		"자바"와 HTML의 위치를 변경

		String[] a = new String[] { "자바", "파이썬", "루비", "HTML", "CSS" };

		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		System.out.println();
		
//		string t = b[0]
//		b[0] = b[3]
//		b[3] = t
		String x = "";
		x = a[0];
		a[0] = a[3];
		a[3] = x;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " " + "글자수= " + a[i].length());
		}
	}
}