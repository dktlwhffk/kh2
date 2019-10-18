package variable;
import java.lang.*;

public class Test09 {
	public static void main(String[] asrg) {
		
		//비만도를 측정하기 위해 키와 몸무게를 재었더니 180cm에 80kg이 나왔습니다.
		//이 사람의 비만도를 계산하여 출력하세요.
		//비만도= 체중/(키*키)
		
		
		int w = 80 ;
		int h = 180;
		double m = (double)h/100;
		
		
		double bmi = (w/(m*m));
		
		
		//System.out.println(h);
		System.out.println(bmi);
		
	}
}
