package loop;

import java.util.Scanner;

public class Test16 {
	public static void main(String[] asrg) throws InterruptedException {
//		타이머 만들기
//		사용자에게 분/초를 입력받습니다.
//		해당되는 시간만큼의 메시지를 출력

		Scanner sc = new Scanner(System.in);
		System.out.print("분 입력= ");
		int min = sc.nextInt();
		System.out.print("초 입력= ");
		int sec = sc.nextInt();
		sc.close();

		int sectotal = (min * 60) + sec;
		for (int i = sectotal-1; i >= 0; i--) {
			int min1 = i / 60;
			int sec1 = i % 60;

			System.out.println(min1 + "분 " + sec1 + "초 남았습니다.");
			if(min1+sec1==0) System.out.println("시간 초과!");	
			Thread.sleep(1000L);		
			//if(min1+sec1==0) 
		}
	}
}
