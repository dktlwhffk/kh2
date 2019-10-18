package variable;

import java.lang.*;

public class Test06 {
	public  static void main(String [] asrg) {
		//pc방 요금이 한시간에 600원입니다.
//		제가 pc방에 오후 2시 50분에 들어가서 오후 11시 15분에 나왔습니다. 요금은??
//		계산해야할 요금이 얼마인가요? (만약 10원짜리가 나온다면 어떻게 해야하나요?)
		
		int a = 2*60;
		int b = 50;
		int c = 11*60;
		int d = 15;
		
		int p = (c+d)-(a+b);
		int p60 = 600/60;
		
		//(p*p60)%100
		
		System.out.println("당신의 이용금액은"+(p*p60)+ "입니다.");
		System.out.println((p*p60)/100*100);	
	
		
	}
}
	