package oop.modifier4;

public class Test01 {
	public static void main(String[] args) {
//	다음 데이터를 구조화하여 출력
//
//	성적 목록
//
//	이름	국어점수	영어점수	수학점수	총점	평균	합격/불합격
//	david	80		70		85	-	-	-
//	ronaldo	91		53		77	-	-	-
//	messi	66		89		75	-	-	-
//	점수는 0 ~ 100점 사이만 설정 가능
//	총점과 평균은 자동으로 계산
//	평균이 60점 미만이면 불합격, 60점 이상이면 합격으로 출력 시 표시
		score a=new score();
		score b=new score();
		score c=new score();
		
		a.set("david", 80, 70, 85);
		b.set("ronaldo", 91, 53, 77);
		c.set("messi", 66, 89, 75);
		
		a.print();
		b.print();
		c.print();
	
	}	
}
