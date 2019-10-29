package array;
import java.lang.*;
import java.util.*;
public class Test13 {
	public static void main(String[] asrg) {
//		과자이름 5개 저장 = 치토스, 허니버터칩, 새우깡, 프링글스, 스윙칩
		String x;
		String[]a=new String[] {"치토스","허니버터칩","새우깡","프링글스","스윙칩"};
		
//		4개일 때 2번 바꿈 5개일때 2번 바꿈 6개일 때 3번 바꿈 7개일 때 3번 바꿈 n개일 때 n/2번 바꿈
//		n=5 2번 바꿈
//		x=a[0];
//		a[0]=a[4];
//		a[4]=x;
//		x=a[1];
//		a[1]=a[3];
//		a[3]=x;
//		System.out.println(a[0]);
//		System.out.println(a[1]);
//		System.out.println(a[2]);
//		System.out.println(a[3]);
//		System.out.println(a[4]);
		for(int i=0; i<a.length/2; i++) {
			int target=(a.length-1)-i;
			System.out.println(i+" 위치와"+target+"위치를 교체");
			String t=a[i];
			a[i]=a[target];
			a[target]=t;
		}
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
