package loop;

import java.lang.*;
import java.util.*;

public class Test19 {
	public static void main(String[] asrg) {

//		반복문을 여러번 겹쳐야 하는 상황
//		1학년 1반 1번부터 3학년 5반 30번까지 출력
//		한 학년당 5개의 반이 있으며, 각 반에는 30명의 학생이 존재

//		for(int i = 1; i<=450; i++) {
//			System.out.println(i+"번째 학생");	
//		}

		for (int i = 1; i <= 3; i++) {
//			System.out.print(i+"학년");
			for (int j = 1; j <= 5; j++) {
//				System.out.println(i+"학년"+" "+j+"반");
				for (int k = 1; k <= 30; k++) {
					System.out.println(i + "학년" + " " + j + "반" + " " + k + "번");
				}
			}
		}
	}
}