package logic;

import java.lang.*;

public class Test01 {
	public static void main(String [] asrg) {
		//논리 : 참(true) 또는 거짓(false)이라는 값만 가질 수 있는 데이터 유형
		
		boolean a = true;
		boolean b = false;
		
		System.out.println(a);
		System.out.println(b);
		
//		boolean c = 1;
//		boolean d = "안녕";
		
//		계산 예: 가진돈이 2만 5천원이고 피자가 2만원일 때 피자를 먹을 수 있을까요?
		int money = 25000;
		int pizza = 20000;
		
		boolean order = money >= pizza;
		System.out.println(order);
		
	}
}
