package loop;

public class Test01 {
	public static void main(String[] asrg) {
//		반복(loop): 똑같거나 규칙이 있는 코드를 계속 실행하기 위한 방법
//		-for, while, do~while
		
//		반복 없이 안녕하세요를 10번 출력
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");
//		System.out.println("안녕하세요");

//		반복으로 안녕하세요를 10번 출력
		for(int n = 1; n<=20; n*=5) {
			System.out.println(n);
			System.out.println("안녕하세요");
		}
	}
}
