package logic;
import java.lang.*;

public class Test05 {
	public static void main(String [] asrg) {
		// 이번 시험에서 87점을 맞은 사람이 있습니다.
		// 이 사람의 성적이 "우수" 인지 판정하여 출력 ( "우수" 등급은 80점 이상 90점 미만에 해당되는 점수임)
		
		int score = 87;
		
		boolean great = 80 <= score && score < 90;
		
		System.out.println(great);

	}
}
