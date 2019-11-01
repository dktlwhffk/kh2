package opp.method3;

public class Cafe {
	String name, type, event;
	double price;
	
	void set(String name, double price, String type, String event) {
		this.name=name;
		this.price=price;
		this.type=type;
		this.event=event;
	}
	void print() {
		System.out.print("품명: "+this.name);
		System.out.print("\t"+"가격: "+(int)this.price);
		System.out.print("\t"+"종류: "+this.type);
		System.out.print("\t"+"\t"+this.event);
		System.out.println();
	}
}
