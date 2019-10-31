package array2d;
import java.lang.*;
import java.util.*;
public class Test02 {
	public static void main(String[] asrg) {
//		2차원 배열을 이용하여 다음 모양으로 데이터를 저장한 뒤 출력
//		8	1	6
//		3	5	7
//		4	9	2
		
		int[][]a=new int[][] {{8,1,6},{3,5,7},{4,9,2}};
		for(int j=0; j<a.length; j++) {
			for(int i=0; i<a[j].length; i++) {
				System.out.print(a[j][i]+"\t");
			}	
			System.out.println();
		}
	}
}
