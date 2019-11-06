package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) {
//		문제:apple, people이 음수면 문제가 된다(이걸 자바는 모른다)
//		-자바에게 강제로 예외를 발생시켜 알려준다(강제예외)
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("사과 개수와 인원수를 입력");
			int apple = sc.nextInt();
			if(apple<0) {
				throw new Exception("사과는 음수일 수 없어요!");
			}
			int people = sc.nextInt();
			if(people<0) {
				throw new Exception("사람은 음수일 수 없어요!");
			}
			sc.close();
			
			System.out.println("한 사람당 "+apple/people+"개씩 줄 수 있습니다");
			System.out.println("남은 개수는 "+apple%people+"개입니다");			
		}
		catch(Exception e){
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "오류가 발생했습니다"); //사용자에게 보여주는 메세지 코드
		}
	}
}