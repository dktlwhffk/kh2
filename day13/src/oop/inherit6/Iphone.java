package oop.inherit6;

public class Iphone extends phone{
	public Iphone(String number) {
		super(number);
		// TODO Auto-generated constructor stub
	}
	protected String airdrop;
	public void airdrop() {
		System.out.println("에어드랍이 활성화되었습니다");
	}
}
