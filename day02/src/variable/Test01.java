package variable;

import java.lang.*;

public class Test01 {
	public static void main(String[] args) {
		//정수 : 소수점이 없는 숫자
		//[1] 계산중에 범위를 넘어가면 뒤집힘(순환형 구조 21억~-21억)
		//[2] 자신의 형태에 맞는 데이터만 대입(=) 가능
		//정수끼리 계산하면 결과가 정수
		
		int a = 10;
		int b = 100*200;
		
		System.out.println(a);
		System.out.println(b);
		
		//byte c = 500;
		//500을 byte에 맞게 강제로 바꿔서 넣어라
		byte c = (byte) 500;
		System.out.println(c);
		
		
		int d = 10 / 3;
		System.out.println(d);
		
		int e = 10 % 3;//나머지
		System.out.println(e);
		
		long f = 10;
		System.out.println(f);

		long g = 220000000000L;
		System.out.println(g);
		
		
	}
}















