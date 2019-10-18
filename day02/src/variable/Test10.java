package variable;
import java.lang.*;

public class Test10 {
	public static void main (String [] args) {
		
		//연비 8.5km 휘발유 가격: 1500원
		//총 운행 거리: 350km 
		//주유비 얼마?
		

		double km = (double) 85/10;
		
		int won = 1500;
		int gd = 350;
		
		double L = (double) gd/km;
		
		double totalp = L*won;
				
				System.out.println(totalp);
				System.out.println(L);
				System.out.println((int)totalp);
		
		
		
	}
}
