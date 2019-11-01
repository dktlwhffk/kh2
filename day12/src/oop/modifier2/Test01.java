package oop.modifier2;

public class Test01 {
	public static void main(String[] asrg) {
//		휴대전화 신규 개통자 정보
//		이름:가나다 휴대폰: 갤럭시s10  통신사: SKT 	약정기간:24개월 	할부원금:110만원
//		이름:라마바 휴대폰: 아이폰 11 	통신사: KT 	약정기간:36개월 	할부원금:150만원
//		이름:사아자 휴대폰: v50 		통신사:LG 	약정기간:24개월 	할부원금:120만원
//		조건
//		통신사는 sk kt lg 알뜰폰 까지만 가능
//		약정기간은 0,24,30,36개월만 가능
//		할부원금은 음수가 될 수 없음 (0포함)
		phone a = new phone();
		phone b = new phone();
		phone c = new phone();

		a.set("가나다", "갤럭시s10", "skt", 24, 110);
		b.set("라마바", "아이폰11", "kt", 36, 150);
		c.set("사아자", "v50", "lg", 24, 120);
		
		
		a.print();
		b.print();
		c.print();
	}
}
