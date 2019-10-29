package array;
import java.lang.*;
import java.util.*;
public class Test05 {
	public static void main(String[] asrg) {
//		다음 형태로 배열을 만들고 요구하는 정보를 출력하세요
//		a----->[10] [20] [0] [50] [30] [40]
//		1. +2지점 출력		2.+1지점과 +4지점 합계 출력		3.배열 칸수 출력	4.전체 데이터 출력
		
		int[]a=new int[6];
		int size=6;
		a[0]=10;	a[1]=20;	a[3]=50;	a[4]=30;	a[5]=40;
		
		System.out.println("+2지점: "+a[2]);
		System.out.println("+1지점과 +4지점 합계= "+(a[1]+a[3]));
		System.out.println(a.length);
		System.out.println();
		
		for(int i=0; i<a.length; i++) {//배열 전체를 반복하는 반복문
			System.out.println(a[i]);
		}
	}
}