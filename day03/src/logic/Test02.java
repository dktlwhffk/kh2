package logic;
import java.lang.*;

public class Test02 {
	public static void main(String [] asrg) {
		
		//자장면 한 그릇에 5천원, 짬뽕 한 그릇에 6천원인 중국집이 있습니다.
		// 3만원 이상 구매시 15% 할인 행사를 진행하고 있다고 할 때,
		//자장면 4그릇, 짬뽕 2그릇을 주문하면 할인 대상이 되는지 계산하여 출력하세요
		
		// 자장면 가격 = a         짬뽕 가격 = b
		// 자장면 그릇 수 = j       짬뽕 그릇 수 = z
		// 할인 대상 여부 = d      총 가격 = p
		
		int a = 5000;
		int b = 6000;
		
		int j = 4;
		int z = 2;
		int p = (a*j)+(b*z);
		int event = 30000; //행사금액
		double discount = 0.15;
		
		boolean d = p >= event;
		double t = (p*(1-discount));
			
		System.out.println(p);
		System.out.println(d);
		System.out.println ((int)t);
		
	}
}
