package array;
import java.lang.*;
import java.util.*;
public class Test04 {
	public static void main(String[] asrg) {
//		배열의 생성과 접근
//		-배열은 참조형이다
//		숫자 5개를 저장할 배열 생성
		int[] a = new int[5];
		System.out.println(a);
		System.out.println(a.length);
		
		int b[]=new int[5];
		System.out.println(b);
		System.out.println(b.length);
		
		int[]c;
//		뭐가 있는지 몰라서 출력 불가(쓰레기값)
		
		int[]d=null;
		System.out.println(d);
//		System.out.println(d.length);
		
//		new 는 만듦과 동시에 초기화를 진행(초기값으로)
		c=new int[3];
		System.out.println(c[0]);
//		System.out.println(c[3]); //존재하지 않는 위치
		
//		a라는 배열에 데이터를 집어넣고 출력
		a[0]=10; a[1]=20; a[2]=30; a[3]=40; a[4]=50;
		System.out.println(a[0]); System.out.println(a[1]);
		System.out.println(a[2]); System.out.println(a[3]); System.out.println(a[4]);
	}
}
