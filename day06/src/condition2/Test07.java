package condition2;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] asrg) {
//		사용자에게 "통신사"와 "전화번호"를 입력받아 출력하는 프로그램 구현
//		단, 통신사는 다음에 제시된 것만 허용됩니다.(lgUplus kt skt 알뜰폰)
//		전화번호는 010으로 시작. 사용자에게 입력받은 값을 검사해서 검사 결과에 따라 다른 알림을 주세요
		
		boolean first, second;
		//통신사 검증
		Scanner sc=new Scanner(System.in);
		System.out.println("통신사를 입력해 주세요.(LGT, SKT, KT, 알뜰폰)");
		String company = sc.next();
		company=company.toUpperCase();
		switch(company){
		case "LGT": case "SKT": case "KT": case "알뜰폰":
			first=true;
			break;
		default:
			first=false;
			break;
		}
		//번호 검증
		System.out.println("전화번호를 입력해 주세요.");

		String num = sc.next();
		char a = num.charAt(0);
		char b = num.charAt(1);
		char c = num.charAt(2);
		if(a=='0'&&b=='1'&&c=='0'&&num.length()==11) {
			second=true;
		}
		else {
			second=false;
		}
		sc.close();
		if(first&&second) {
			System.out.println(company+" "+num);
		}
		else if(first&&!second){
			System.out.println("번호가 잘못되었습니다.");
		}
		else if(!first&&second) {
			System.out.println("통신사가 잘못되었습니다.");
		}
		else {
			System.out.println("통신사와 번호가 잘못된 형식입니다.");
		}
	}
}
