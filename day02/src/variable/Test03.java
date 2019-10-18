package variable;
import java.lang.*;
public class Test03 {
	public static void main(String [] asrg) {
		//문제: 10분당 500원 주차장
		//		2시간 30분 주차요금 계산
		//		9분까지는 0원
		
		
		int won = 500;
		int min = 10;
		int A = (2*60)/min;
		int B = 30/min;
		
		
		System.out.println ((A+B)*won);
		 
		
		
		/* 풀이
		 * int hour = 2;
		 * int minute = 30;
		 * int price = 500;
		 * int per = 10;
		 * 
		 * 
		 * int time = 60*hour+minute;
		 * 
		 *sysout (time / per * price);
		 *  
		 *  
		 */
		
		
		
	
	}
}
