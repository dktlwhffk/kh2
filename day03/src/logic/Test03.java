package logic;

import java.lang.*;
import java.util.*;

public class Test03 {
	public static void main(String [] asrg) {
		
		//어떤 사람의 생년월일이 숫자로 다음과 같이 주어져 있다고 가정합니다.
		// 19990217
		// 이 사람이 "성인"인지 판정하여 출력하세요 (기준: 20세 이상)
				
		int a = 19990217; //생년월일
		int c = 2000; //기준 연도
		
		int x = a/10000; //생일을 뺀 연도만 구하는 식		
		
		//System.out.println(x);
		
		boolean adult = x<=c; 
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		System.out.println(adult);		
		System.out.println(year-x+1);
		
		/*
		 * 입력
		 * int birth = 19990217;
		 * 
		 * 계산
		 * int year = birth / 10000;
		 * 
		 * int age = 2019 - year + 1;
		 * 
		 * int year = Calendar.getInstance().get(Calendar.YEAR);
		 * 
		 * boolean adult = 나이 >= 20;
		 * sysout(adult);
		 */
	
		
	}
}
