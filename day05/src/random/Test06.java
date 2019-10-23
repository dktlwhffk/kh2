package random;
import java.lang.*;
import java.util.*;
public class Test06 {
	public static void main(String[] asrg) {
//		랜덤으로 카드 한 장을 뽑는 프로그램 구현
//		카드는 13장씩 4세트, 조커 2장
//		조커 빼고 일반카드 중에서 한 장을 추첨
		
		Random r = new Random();
		
		int shape = r.nextInt(4)+1; 
		int number = r.nextInt(13)+1;
		
		
		String shapeStr;
		if (shape==1) {
			shapeStr = "스페이드";
		} else if (shape==2) {
			shapeStr = "클로버";
		} else if (shape==3) {
			shapeStr = "다이아몬드";
		} else {
			shapeStr = "하트";
		}
		
		String numberStr;
		if (number==1) {
			numberStr = "A";
		} else if (number==11) {
			numberStr = "J";
		} else if (number==12) {
			numberStr = "Q";
		} else if (number==13) {
			numberStr = "K";
		} else {
			numberStr = ""+number;
		}
		System.out.println(shapeStr+" "+numberStr);
	}
}
