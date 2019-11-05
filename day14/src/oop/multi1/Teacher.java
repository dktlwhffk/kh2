package oop.multi1;
//인터페이스
//다중상속 전용 클래스
public interface Teacher {
//변수: 객체 내부에 존재할 수 없음(Static), 변경할 수 없음(final) = 상수(constant)
	public static final String name="홍길동";
	
	
	String subject="자바";
//	private int age=30;
	
	
	
	//메소드 재정의 금지, 추상만 가능(public abstract)
	public abstract void teach();
	
	void speak();
	
	//생성자: 가질 수 없음(객체 생성 불가)
	// public Teacher(){
//}
}
