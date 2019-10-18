package variable;
import java.lang.*;

public class Test08 {
	public static void main(String[] asrg) {
		
		//목표: 65와 80의 평균 구하기
		 
		int a = 65;
		int b = 80;
		
		int total = a + b;
		//		한 개는 실수여야 소수점 아래의 데이터가 유지됨
		//		double avg = total / 2.0;
		double avg = (double)total / 2; //total을 double로 강제 변환 후 계산
		
		System.out.println(avg);
		
	}
}
