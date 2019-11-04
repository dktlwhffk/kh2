package oop.inherit5;

//아이폰 상위 클래스
//-이 클래스가 인스턴스가 되는 것이 아니라 누군가가 상속받아간다
public class Iphone {
//변수(필드)	접근제한(private, protected)
//	private int series;
	protected int series;	//자신(this)+패키지(package)+상속(inherit)
	protected int memory;	//자식에게는 public, 외부에는 private 효과
//메소드		재정의(override)를 고려
	public void camera() {//반드시 수정
		System.out.println("아이폰으로 사진을 찍습니다");
	}
	public void power() {//수정 불가
		System.out.println("아이폰의 전원버튼을 누릅니다");
	}
	public void airdrop() {//수정 선택
		System.out.println("근처 아이폰에게 사진을 보냅니다");
	}
	
//생성자
}
