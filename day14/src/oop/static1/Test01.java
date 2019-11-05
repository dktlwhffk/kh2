package oop.static1;

public class Test01 {
	public static void main(String[] args) {
//static 데이터는 인스턴스가 없어도 접근이 가능
		Iphone11.company="애플";
		System.out.println(Iphone11.company);
		
//		인스턴스 생성
		Iphone11 a = new Iphone11();
		System.out.println(a.company);
		
		Iphone11 b = new Iphone11();
		System.out.println(b.company);
		
		b.company="삼성";
		System.out.println(a.company);
		System.out.println(b.company);
	}
}
