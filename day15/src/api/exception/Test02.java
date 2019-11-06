package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		테스트 결과
//		- 예외는 총 2종류가 발생
//		- ArithmeticException: 0으로 나눌 경우(사람이 0인 경우)
//		- InputMismatchExecption: 정수가 아닌 값이 입력된 경우
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("사과 개수와 인원수를 입력");
			int apple = sc.nextInt();
			int people = sc.nextInt();
			
			sc.close();
			
			System.out.println("한 사람당 "+apple/people+"개씩 줄 수 있습니다");
			System.out.println("남은 개수는 "+apple%people+"개입니다");			
		}
		catch(ArithmeticException e){
			System.err.println("사람이 없으면 말이 되냐 임마");
		}
		catch(InputMismatchException e){
			System.err.println("정수를 입력해야지 임마");
		}
	}
}
