package loop;

import java.util.Scanner;

public class Test26 {
	public static void main(String[] asrg) {
//		끝말잇기 프로그램 (제시어: 반복문)
//		사용자에게 입력을 받아 제시어와 연결되는 경우 계속 진행
//		사용자에게 입력받은 단어가 제시어와 연결되지 않은 경우 게임 종료
//		게임 종료시 제대로 입력한 횟수를 구하여 화면에 출력
		String topic = "반복문"; // 제시어
		int count = 1;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("제시어: " + topic);
			String user = sc.next();
			char last = topic.charAt(topic.length() - 1);

			char first = user.charAt(0);

			if (last == first) {
				count++;
				topic = user;
			} else {
				System.out.println("도전 횟수: " + count + '\n' + "연결되지 않은 단어");
				break;
			}
		}
		sc.close();
	}
}