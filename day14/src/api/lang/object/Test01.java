package api.lang.object;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
//	Object라는 클래스의 인스턴스를 생성해봅시다.
		Object a =new Object();
		
		System.out.println(a.getClass());
		System.out.println(a.hashCode());
		System.out.println(a.toString());
		
		Object b = 10;
		Object c = "hello";
		Object d = new Scanner(System.in);
		Object e =new int[5];
		
//		b의 형태는 무엇입니까
		System.out.println(b.getClass());
		System.out.println(c.getClass());
		System.out.println(c instanceof String);
		
}
}
