package variable;

import java.lang.*;

public class Test11 {
	public static void main(String [] asrg) {
//		숙제		
//		영화관 이용 요금은 다음과 같습니다.
//		성인 10000원
//		청소년 7000원
//		성인 2명, 청소년 3명이 영화를 보러가서 제휴카드로 25% 할인을 받았습니다.
//		결제금액을 구하여 출력하시오.
			
//--------------------------------------------------------------		
//		성인 인원 수: a          성인 영화 요금: x
//		청소년 인원 수: t        청소년 영화 요금: y
//		제휴카드 할인률: percent      할인률 적용 식: discount
//      최종 요금: price
//--------------------------------------------------------------
		
		int a = 2;
		int t = 3;
		int x = 10000;
		int y = 7000;
		int percent = 25;
		double discount = (1-(0.01*percent));
		double price = ((a*x)+(t*y))*(discount);
		
		
		System.out.println((int)(price)+"원");
		
	}
}
