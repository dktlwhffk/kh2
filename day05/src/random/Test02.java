package random;

import java.lang.*;
import java.util.*;

public class Test02 {
	public static void main(String[] args) {
//		1.주사위 1개를 던진 결과
//		2.이번주 로또번호 1개를 추첨한 결과
//		3.무작위 두 자리 정수1개
//		4.otp번호 자리1개

		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		System.out.println(dice);

		int lotto = r.nextInt(45) + 1;
		System.out.println(lotto);

		int n = r.nextInt(90)+10;
		System.out.println(n);

		int otp1 = r.nextInt(1000000); 
		System.out.println(otp1); 
	}
}
