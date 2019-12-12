package beans;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("가격을 입력하세요");
		int price = sc.nextInt();
		
		sc.close();
		
		SnackDao snackdao = new SnackDao();
//		snackdao.insert(name, price);
		System.out.println("등록완료");
		
	}
}
