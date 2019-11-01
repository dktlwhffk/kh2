package oop.modifier1;

public class bank {
	private String name;
	private int money;
	
//	name의 setter 메소드
//	조건 없음
	void setName(String name) {
		this.name=name;
	}
//	money의 setter method
//	조건: money가 0이상이면 설정
	void setMoney(int money) {
		if(money>=0) {
			this.money=money;			
		}
	}
//name의 getter method
	String getName() {
//		나의 이름을 외부로 반환해라
		return this.name;		
	}
//money의 getter method
	int getMoney() {
		return this.money;
	}
}