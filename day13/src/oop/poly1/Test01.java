package oop.poly1;

public class Test01 {
	public static void main(String[] args) {
//	GalaxyS10 생성
		GalaxyS10 a = new GalaxyS10();
//	Galaxynote10 생성
		Galaxynote10 b = new Galaxynote10();
		
//	아래와 같은 관계 성립
//	-> 통합하여 사용하기 위한 구조
		
		Galaxy c = new GalaxyS10();
		
		
		Galaxy d = new Galaxynote10();
		
//	궁금점: c가 무슨형태인지 알고 싶다면?
		System.out.println(c instanceof GalaxyS10);
		System.out.println(c instanceof Galaxynote10);
		System.out.println(c instanceof Galaxy);
		
	}	
}
