package loop;

import java.lang.*;

public class Test03 {
	public static void main(String[] asrg) {
//		1~100 정수 중에서 5가 들어있는 숫자만 화면에 출력하고 싶습니다.
	for (int n = 1; n < 10000; n++) {
	if (n / 10 == 5 || n % 10 == 5 || (n / 10) % 10 == 5 || (n / 100) % 100 == 5) {
	System.out.println(n);
}
}
}
}