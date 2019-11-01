package oop.method4;

public class bank {
	int money;
	
//	500원 이상은 저금을 못하게...
	void save(int money) {
		if(this.money+money<=500) {
			this.money+=money;			
		}
	}
	void print() {
		System.out.println(this.money);
	}
}
