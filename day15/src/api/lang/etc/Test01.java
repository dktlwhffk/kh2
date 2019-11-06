package api.lang.etc;

public class Test01 {
	public static void main(String[] args) {
//		Math 클래스
//		Math a = new Math();
		System.out.println(Math.PI);
		
//		반지름이 5인 원의 넓이를 구해보세요
		System.out.println(5*5*Math.PI);
		System.out.println(Math.pow(5, 2)*Math.PI);
		
//		절대값
		int a = 5;
		int b = 2;
		System.out.println(Math.abs(a-b));
		System.out.println(Math.abs(b-a));
		
//		반올림(round), 올림(ceil), 버림(floor)
		double c = 1.5;
		System.out.println(Math.round(c));
		System.out.println(Math.ceil(c));
		System.out.println(Math.floor(c));
		
	}
}
