package opp.method3;

public class Cafe {
	String name, type;
	int price;
	boolean event;

	
	void set(String name, int price, String type, boolean event) {
		this.name=name;
		this.price=price;
		this.type=type;
		this.event=event;
	}
	void print() {
		int discount = this.price*90/100;
		if(event) {
			System.out.print("품명: "+this.name);
			System.out.print("\t"+"가격: "+discount);
			System.out.print("\t"+"종류: "+this.type);
			System.out.print("\t"+"\t"+this.event);
			System.out.println();
		} else {
			System.out.print("품명: "+this.name);
			System.out.print("\t"+"가격: "+this.price);
			System.out.print("\t"+"종류: "+this.type);
			System.out.print("\t"+"\t"+this.event);
			System.out.println();
		}
	}
}
