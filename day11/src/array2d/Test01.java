package array2d;
import java.lang.*;
import java.util.*;
public class Test01 {
	public static void main(String[] asrg) {
//		2차원 배열
//		[1] 선언만
//		[2] 선언+생성
//		[3] 선언+생성+초기화
		int[][]a;
		
		int[][]b=new int[2][3]; //2줄 3칸짜리 배열 생성
//		b -----> b[0] ---->[0][0][0]
//				 b[1] ---->[0][0][0]
		
		System.out.println(b.length);
		System.out.println(b[0].length);
		System.out.println(b[1].length);
		
		System.out.println(b[1][1]);
		
		int [][]c=new int[][] {
			{7,5,2},
			{1,6,9}
			};
			System.out.println();
		System.out.print(c[0][0]); System.out.print(c[0][1]); System.out.print(c[0][2]);
		System.out.println();
		System.out.print(c[1][0]); System.out.print(c[1][1]); System.out.println(c[1][2]);
//		줄 단위로 반복문으로 변경
		for(int i=0; i<c[0].length; i++) {
			System.out.print(c[0][i]+"\t");
		}
		System.out.println();
		for(int j=0; j<c[1].length; j++) {
			System.out.print(c[1][j]+"\t");
		}
		System.out.println();
		
//		줄단위도 반복문으로 변경
		for(int i=0; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
