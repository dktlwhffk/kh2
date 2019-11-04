package oop.inherit2;

//cat 클래스에서 animal 클래스를 상속받는다.
//animal 클래스가 가진 모든 내용을 내것처럼 사용 가능
public class Cat extends Animal{
	
	public void punch() {
		System.out.println("냥냥펀치");
	}
}
