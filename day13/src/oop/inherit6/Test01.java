package oop.inherit6;

public class Test01 {
	public static void main(String[] args) {
		
		GalaxyS10 s10=new GalaxyS10("010-1212-3242");
		s10.name();
		s10.call();
		s10.sms();
		s10.bixby();
		System.out.println();
		
		Galaxynote10 note10=new Galaxynote10("010-1212-3213");
		note10.name();
		note10.call();
		note10.sms();
		note10.memo();
		System.out.println();
		
		Iphone10 iphone10=new Iphone10("010-1231-1231");
		iphone10.name();
		iphone10.call();
		iphone10.airdrop();
		iphone10.itunes();
		System.out.println();
		
		Iphone11 iphone11=new Iphone11("010-1233-2323");
		iphone11.name();
		iphone11.call();
		iphone11.number();
		iphone11.airdrop();
		iphone11.siri();
	}
}