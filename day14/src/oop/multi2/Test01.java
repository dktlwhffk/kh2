package oop.multi2;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
//		Phone b= new Phone();
//		Phone IPhone10 = new Phone();
		Telecom a = new Telecom();
		
		
		
//		.sktfunction();
//		IPhone10.lgtfunction();
	
	
		a.airdrop();
		a.ktfunction();
		a.call();
		
		
		System.out.println("점심 뭐먹지?");
		Random r=new Random();
		int menu = r.nextInt(3);
		if(menu==0) {
			System.out.println("중국집");
		} else if(menu==1) {
			System.out.println("서브웨이");
		} else{
			System.out.println("김치볶음밥");
		}
	}
}
