package condition2;

import java.util.Random;

public class Test04 {
	public static void main(String[] asrg) {
//		내년 2월은 29일까지
//		랜덤을 이용하여 내년 중 무작위로 날짜를 1개 뽑아서 출력 (예:2020년??월??일)

		Random r = new Random();
		int month = r.nextInt(12) + 1;
		
		int count;
		switch (month) {
		case 2:count = 29;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 30;
			break;
		default:
			count = 31;
			break;
		}
		int day = r.nextInt(count) + 1;
		System.out.println("2020년 " + month + "월 " + day + "일");
	}
}