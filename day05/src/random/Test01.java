package random;

import java.lang.*;
import java.util.*;
import java.math.*;

public class Test01 {
	public static void main(String[] arsg) {
//		랜덤(Random): 무작위 데이터(예측이 불가능한 데이터)
//		-로또,주사위,사다리,동전던지기
//		프로그램 내에서 다양한 처리를 수행
//		-확률의 구현이 가능

//		구현방법
//		1. math라는 도구를 이용하는 방법(java.lang)
		double a = Math.random();
		System.out.println(a);

//		1부터 10사이의 정수를 a를 이용하여 만든다
		double b = a * 10;
		System.out.println((int) b);

		int c = (int) b;

		int d = c + 1;
		System.out.println(d);
		
//		한 줄로 정리
		int n = (int)(Math.random()*10)+1;
		System.out.println(n);
		
//		2. Random이라는 도구를 이용하는 방법(java.util)
//		도구를 만들고 버튼을 눌러 명령을 이용
//		-scanner는 통로(stream)이기 때문에 close를 수행
		Random r = new Random();
		
		int v1=r.nextInt();//랜덤으로 인트값 생성
		System.out.println(v1);
		
		int v2 = r.nextInt(10)+1;
		System.out.println(v2);
	}
}
