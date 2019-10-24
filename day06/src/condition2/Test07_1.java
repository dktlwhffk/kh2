package condition2;
import java.util.Scanner;
public class Test07_1 {
	public static void main(String[] asrg) {
//		사용자에게 "통신사"와 "전화번호"를 입력받아 출력하는 프로그램 구현
//		단, 통신사는 다음에 제시된 것만 허용됩니다.(lgUplus kt skt 알뜰폰)
//		전화번호는 010으로 시작. 사용자에게 입력받은 값을 검사해서 검사 결과에 따라 다른 알림을 주세요
		
		Scanner sc=new Scanner(System.in);
		System.out.println("통신사를 입력해 주세요.(LGT, SKT, KT, 알뜰폰)");
		String company = sc.next();
		company=company.toUpperCase();
		switch(company){
		case "LGT": case "SKT": case "KT": case "알뜰폰":
			System.out.println(company);
			break;
		default:
			System.out.println("통신사 형식이 잘못되었습니다.");
			break;
		}
		
		System.out.println("전화번호를 입력해 주세요.");

		String num = sc.next();
		char a = num.charAt(0);
		char b = num.charAt(1);
		char c = num.charAt(2);
		if(a=='0'&&b=='1'&&c=='0'&&num.length()==11) {
			System.out.println("010으로 시작하는 올바른 번호입니다.");
		}
		else {
			System.out.println("전화번호 시작글자가 잘못되었습니다");
		}
		sc.close();
	}
}