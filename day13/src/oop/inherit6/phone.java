package oop.inherit6;

public class phone {
	protected String number;	
	protected String name;
//	생성자
	public phone(String number) {
		this.number=number;
	}

	
	public void name() {
		System.out.println(name);
	}
	
	public void call() {
		System.out.println("전화를 겁니다");
	}
	public void number() {
		System.out.println(number);
	}
}
