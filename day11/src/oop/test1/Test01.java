package oop.test1;

public class Test01 {
	public static void main(String[] asrg) {
//		내가 만든 student라는 형태의 객체를 생성
		Student a = new Student();
		Student b = new Student();
		
		System.out.println(a);
		System.out.println(b);
		
		a.name="메시";
		
		System.out.println(a.name); //a내부의 name을 확인
		System.out.println(b.name);
	}
}
