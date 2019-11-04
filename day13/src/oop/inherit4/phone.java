package oop.inherit4;

public class phone {
	private String number;//선택
	private int memory;//필수
	
	public phone(int memory) {
		this.memory=memory;
	}
	
	public void setNumber(String number) {
		if(number.length()==11||number.length()==8) {
			this.number=number;			
		}
	}
//	void setMemory(int memory) {
//		if(memory==128||memory==256||memory==512) {
//			this.memory=memory;
//		}
//	}
	public void set(String number, int memory) {
		this.setNumber(number);
//		this.setMemory(memory);
	}
	
	public String getNumber() {
		return this.number;
	}
	public int getMemory() {
		return this.memory;
	}
	
	public void number() {
		System.out.println(number);
	}
	
	public void call() {
		System.out.println("전화를 걸고 있습니다");
	}
	public void sms() {
		System.out.println("문자메시지를 전송합니다");
	}
	public void photo() {
		System.out.println("사진 촬영을 시작합니다");
	}
}
