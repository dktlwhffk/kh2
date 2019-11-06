package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test03 {
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
//		catch(RuntimeExecption e) 하위클래스
//		catch(Throwable e) 상위클래스
//		catch(Error e) 내가 고쳐야 할 에러까지 넘기면 안돼서 안씀
		catch(Exception e){
//			System.err.println("에러!");
//			System.out.println(e);
//			System.out.println(e.getClass()); // 오류난 클래스 정보
//			System.out.println(e.getMessage()); // 원인 정보
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "오류가 발생했습니다"); //사용자에게 보여주는 메세지 코드
		}
	}
}
