package oop.method2;

public class Test01 {
	public static void main(String[] asrg) {
	//		다음 정보를 클래스와 객체를 이용하여 프로그래밍 데이터화 시키고 출력
	//
	//		초기화는 set 메소드, 출력은 print 메소드를 만들어서 진행
	//
	//		> 학생 성적 목록
	//		- 이름 : 마리오 , 국어 : 80점 , 영어 : 85점 , 수학 : 82점 , 총점 : 247점 , 평균 : 82.3점
	//		- 이름 : 루이지 , 국어 : 55점 , 영어 : 90점 , 수학 : 85점 , 총점 : 230점 , 평균 : 76.6점
	//		- 이름 : 쿠파 , 국어 : 77점 , 영어 : 65점 , 수학 : 23점 , 총점 : 165점 , 평균 : 55점
	//		소수점 자리수는 처리하지 않아도 됩니다.
//		객체 생성
		Student a =new Student();
		Student b =new Student();
		Student c =new Student();
		
		
//		값 설정(초기화)
		a.set("마리오",80,85,82);
		b.set("루이지",55,90,85);
		c.set("쿠파",77,65,23);
		
//		출력
		a.print();
		b.print();
		c.print();
	}
}
