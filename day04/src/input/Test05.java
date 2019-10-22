package input;
import java.lang.*;
import java.util.*;
public class Test05 {
	public static void main(String[] args) {
//		사용자에게 숫자 형태로 8자리 생년월일을 입력 받습니다.
//		이 사용자의 출생년도,월,일을 따로따로 계산하여 출력.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생년월일을 입력해주세요.");
		int birth = sc.nextInt();

		int year = birth/10000;
		int month = (birth%10000)/100;
		int day = (birth%10000)%100;
		
		System.out.print(year+"년");
		System.out.print(month+"월");
		System.out.print(day+"일");
		
		sc.close();
		
	}
}
