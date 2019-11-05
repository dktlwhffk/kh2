package oop.inherit7;
//추상 클래스: 개념적인 내용을 정의하는 상위 클래스
//일반클래스와 다른점
//추상 메소드를 가질 수 있음
//인스턴스 생성 불가
public abstract class phone {

//	변수
	protected String number;
	
//	생성자
	public phone(String number) {
		this.number=number;
	}
	
//	추상 메소드
//	내용은 모르겠지만 반드시 있어야 하는 기능에 사용(강제 재정의)
//	상속을 받으려면 이 메소드를 무조건 재정의해야 함
	public abstract void call();
}
