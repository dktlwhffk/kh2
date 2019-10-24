package condition2;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//		사용자에게 월을 입력받아 해당하는 월의 날짜 수를 구하여 출력
//		2월은 28일까지 (예) 1입력--->1월은 31일까지 있습니다.

		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		sc.close();
		// 1,3,5,7,8,10,12= 31/ 4,6,9,11= 30/ 2= 28
		switch (day) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(day + "월은 31일까지 있습니다.");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(day + "월은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(day + "월은(는) 28일까지 있습니다.");
			break;
		default:
			System.out.println("1월에서 12월 사이의 값을 입력하세요.");
		}
	}
}
/*
 * int day= 28 or 30 or 31;
 * int day;
 * switch(month){
 * case 2:
 * 		day = 28;
 * 		break;
 * case1: case3: case5: case7:...
 * day=31;
 * break;
 * default;
 * 		day = 30;
 * 		break;
 * }
 * sysout(month+"월은"+day+"일 까지 있습니다.")
 */


