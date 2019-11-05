package oop.inherit5;

public class Iphone11 extends Iphone{
//메소드 재정의(override)
//-상위 클래스의 메소드를 다시 만들어서 고쳐지는 효과가 발생하도록 하는 것
//-상위 클래스의 메소드와 똑같이 만듦
	public void camera() {
		System.out.println("아이폰11의 선명한 카메라로 촬영!");
	}
	
//	@Override 하단 코드의 행위를 강제하는 역할(명찰)
		public void power() {
			System.out.println("내사진을 띄우며 전원 기능을 사용한다!");
		}
}
