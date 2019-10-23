package condition;

import java.lang.*;
import java.util.*;

public class Test07 {
	public static void main(String[] args) {
//		조건 그룹
//		사용자에게 이름을 입력받습니다.
//		그 단어의 시작글자가 한글인지 검사하는 프로그램을 만들 계획입니다.
//		만약 한글로 시작한다면 "올바른 입력값입니다" 출력, 아니면 "잘못된 입력값입니다"를 출력하세요

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.next();

		sc.close();

//		System.out.println(name.charAt(0)); 첫글자 추출식

		char first = (name.charAt(0));

//		System.out.println((int)'힣'); 
//		가:44032 힣:55203

		if (first >= '가' && first <= '힣') {
			System.out.println("올바른 입력값입니다.");
		} else {
			System.out.println("잘못된 입력값입니다.");
		}
	}
}
