package api.lang.Integer;

public class Test02 {
	public static void main(String[] args) {
// 	Integer는 int의 클래스 형태(참조형)
//	10+20을 각각 원시형과 참조형으로 풀어보자!
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);
		
		Integer d =new Integer(10);
		Integer e =new Integer(20);
		
		Integer f = Integer.sum(d, e);
		System.out.println(f);
	}
}
