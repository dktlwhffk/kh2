package loop;
import java.lang.*;
public class Test09 {
	public static void main(String[] asrg) {
//		부자가 되기 위해서 kh뱅크에 계좌를 만들고 돈을 모을 계획
//		30일 모으기 (첫날은 1원 예금->둘째날부터는 전날의 2배를 예금)
//		30일동안 모을 수 있는 금액과 일자별 예금액을 출력하고 40일로도 풀어볼 것
	
		double money = 1;
		long totalm =0;
		
		for(int day=1; day<=40; day++) {
			totalm+=money;
			System.out.println(day+"일 "+(long)money+"원 "+"총 금액= "+totalm);
			money*=2;  
		}
		System.out.println("총 금액= "+totalm);
	}
}