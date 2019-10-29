package array;

import java.lang.*;
import java.util.*;

public class Test09 {
	public static void main(String[] asrg) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = new int[] { 1, 2, 3, 4, 5 };
		int[] c = a;
		
		System.out.println(a); System.out.println(b); System.out.println(c);
		
		a[1]=7;
		System.out.println(c[1]); //7. a와 완벽하게 동일
	}
}