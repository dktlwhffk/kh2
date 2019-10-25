package loop;

import java.lang.*;

public class Test08 {
	public static void main(String[] asrg) {
//		다이어트를 위해 30일간 운동계획을 작성하려고 합니다.
//		첫날은 워밍업으로 푸쉬업 10개만 실시 -> 둘째날부터는 전날보다 4개씩 더 실시
//		출력해야 하는 항목: 30일 동안 하게 되는 푸쉬업 개수, 매일매일 하게되는 푸쉬업 개수

		int total=10;
		int count=10;
//		int day=1;
		
		for (int i=1; i<=30; i++) {				
			
			if(i>=2) {
				 count+=4; total+=count;		
			}
			System.out.println(i+" 일"+" "+count+"개");
		}
		System.out.println("총 개수: "+total);
	}
}