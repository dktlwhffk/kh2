package api.exception;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
//		finally: 최종 실행 구문
		
		Scanner sc = new Scanner(System.in);
		try {
			
		}
		catch(Exception e) {
			
		}
		finally {//예외 여부와 관계없이 무조건 실행: 마무리 작업을 수행
			sc.close();			
		}
	}
}
