package condition;

import java.lang.*;
import java.util.*;

public class Test09 {
	public static void main(String[] args) {
//		다중조건그룹: 3가지 이상의 선택지를 필요로 할 때 사용할 수 있는 구문
////		목표: 시험점수를 이용하여 성적을 상중하로 구분하여 출력
////		상: 80점~100점
//			중: 60점~80점
//			하: 0점:~60점 미만

		int score = 89;

		if (score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다.");
		} else if (score >= 80) {
			System.out.println("상");
		} else if (score >= 60) {
			System.out.println("중");
		} else {
			System.out.println("하");
		}
	}
}
