package input;
import java.lang.*;
import java.util.*;
public class Test06 {
	public static void main(String[] args) {
		//사용자에게 국어, 영어, 수학 시험점수를 입력받아 "총점"과 "평균"을 구하여 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요");
		int math = sc.nextInt();
		
		int total = kor+eng+math;
		double avg = (double)(kor+eng+math)/3;
		
		sc.close();
		
		System.out.println("총점 = "+ total);
		System.out.println("평균 = "+ (Math.round(avg*100)/100.0));		
	}
}
/*	.next() => 공백을 기준으로 "단어를 입력받음"
	.nextInt() => 공백을 기준으로 "숫자를 입력받음"
*/