package array2d;
import java.lang.*;
import java.util.*;
public class Test03 {
	public static void main(String[] asrg) {
//		2차원 배열을 이용하여 다음 모양으로 데이터 초기화 후 출력
//		1	2	3	4	5				1	6	11	16	21	
//		6	7	8	9	10				2	7	12	17	22
//		11	12	13	14	15				3	8	13	18	23
//		16	17	18	19	20				4	9	14	19	24
//		21	22	23	24	25				5	10	15	20	25
		
		//인덱스가 0일때 1 1일때 2 2일때 3...n일때 n+1 	0행
		//인덱스가 0일때 6 1일때 7 ........n일때 n+6	1행
//									  n일때 n+11	2행
//		행은 0<5	인덱스 0~5	값 1~n+1 n=인덱스

		int a[][]=new int[6][6];
		
		for(int j=0; j<a.length; j++) {
			for(int i=0; i<a.length; i++) {
				a[j][i]=j*5+i+1;
			}	
		}
		for(int j=0; j<a.length; j++) {
			for(int i=0; i<a[j].length; i++) {
				System.out.print(a[j][i]+"\t"+"\t");
			}	
			System.out.println();
		}
	}
}
