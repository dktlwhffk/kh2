package condition2;

public class Test02 {
	public static void main(String[] args) {
//		Test01을 switch~case구문으로 변경

		int season = 10;

		switch (season) {
		case 12:
		case 1:
		case 2:
			System.out.println("겨울");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름");
			break;
//		case 9:
//		case 10:
//		case 11:
		default://해당되는 내용이 없을 때 자동으로 실행
			System.out.println("가을");
			break; //마지막 브레이크는 생략 가능
		}
	}
}
