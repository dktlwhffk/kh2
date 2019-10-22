package input;
import java.lang.*;
import java.util.Scanner;
public class Test03 {
	public static void main (String[] args) {
//		사용자에게 다음 정보를 입력받아 화면에 출력해주세요
//		1.아이디 		2.비밀번호		3.닉네임
//		입력받은 뒤 입력받은 정보와 "글자수"를 구하여 화면에 출력
				
		//아이디 = a 비번 = b 닉 = c
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력해 주세요");
		String a= sc.next();
		System.out.println("비밀번호를 입력해 주세요");
		String b= sc.next();
		System.out.println("닉네임 입력해 주세요");
		String c= sc.next();
		
		sc.close();
		
		System.out.println(a);
		System.out.println(a.length());
		
		System.out.println(b);
		System.out.println(b.length());
		
		System.out.println(c);
		System.out.println(c.length());
	
	}
}
