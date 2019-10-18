package variable;

import java.lang.*;

public class Test05 {
	public static void main (String [] arsg) {
		
//		어제 1시간30분 공부하고 오늘 2시간50분 공부했습니다.
//		내가 공부한 시간을 계산하여 화면에 찍어주세요
		
		int hour = 1;
		int min = 60;
		
		
		int yh =1*min; 
		int th = 2*min;
		
		int ym = 30;
		int tm = 50;
		
		int Y = yh+th;
		int T = ym +tm;
		
		
		
		System.out.println((Y+T)/60);
		System.out.println((Y+T)%60);
		
		
		
		

	}
	
}
