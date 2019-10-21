package logic;
import java.lang.*;
public class Test04 {
	public static void main(String [] asrg) {
		//목표: 어떤 사람의 나이가 주어졌을 때 이 사람이 "청소년"인지 파악
		//구간: 14세 이상 19세 이하(20세 미만)
		
		int age = 15;
		
		boolean a = age >= 14;
//		boolean b = age <= 19;
		boolean b = age < 20;
		
		System.out.println(a);
		System.out.println(b);
		
//		a와 b가 모두 true라면 청소년이라고 볼 수 있다.(and연산 사용)
		boolean c = a && b;
		
		System.out.println(c);
// 		한번에 쓴다면 
		boolean d = age >= 14 && age < 20;
		System.out.println(d);
		
	}
}
