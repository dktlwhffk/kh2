package array;
import java.lang.*;
import java.util.*;
public class Test07 {
	public static void main(String[] asrg) {
//		10,20,30,40,50을 배열에 저장하고 다음 작업을 수행
//		1. 10과 40의 위치를 변경		2. 20과 30의 위치를 변경		3.전체 출력	4.전체 합계 출력
		
		int a[]=new int[] {10,20,30,40,50};
			
		int b=0;
		b=a[0];
		a[0]=a[3];
		a[3]=b;
		
		b=a[1];
		a[1]=a[2];
		a[2]=b;
	
		int total=0;
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
			total+=a[i];
		}
		System.out.println(total);
	}
}
