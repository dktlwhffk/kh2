package array;

import java.util.Random;

public class Test15 {
	public static void main(String[] asrg) {
//		주사위를 1000번 던졌을 때 각각의 숫자가 몇 번씩 나왔는지를 세고 싶습니다.
//		프로그램 만들어서 해당 기능을 구현하세요

		Random r = new Random();

		int[] a = new int[] {};
		
		int countone=0, counttwo=0, countthree=0, countfour=0, countfive=0, countsix=0;
		for (int i = 0; i < 1000; i++) {
			int dice = r.nextInt(6) + 1;
//			System.out.println(dice);
			if(dice==1) {
				countone++;  
			} else if(dice==2) {
				counttwo++;
			} else if(dice==3) {
				countthree++;
			} else if(dice==4) {
				countfour++;
			} else if(dice==5) {
				countfive++;
			} else if(dice==6) {
				countsix++;
			}
		}
		System.out.println("1이 나온 경우= "+countone);
		System.out.println("2가 나온 경우= "+counttwo);
		System.out.println("3이 나온 경우= "+countthree);
		System.out.println("4가 나온 경우= "+countfour);
		System.out.println("5가 나온 경우= "+countfive);
		System.out.println("6이 나온 경우= "+countsix);
	}
}
