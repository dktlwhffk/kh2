package oop.inherit6;

public class Galaxy extends phone{
	public Galaxy(String number) {
		super(number);
		// TODO Auto-generated constructor stub
	}
	protected String sms;
	public void sms() {
		System.out.println("문자메시지를 보냅니다");
	}
}
