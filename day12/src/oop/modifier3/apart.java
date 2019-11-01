package oop.modifier3;

public class apart {
private boolean balcony;
private int size, room, toilet, price;

void setBalcony(boolean balcony) {
	this.balcony=balcony;
}
void setSize(int size) {
	this.size=size;
}
void setRoom(int room) {
	if (room<1) {
		return; //설정거부
//		room =1; 1로 설정
	}
	this.room=room;
}
void setToilet(int toilet) {
	if (toilet<1) {
		return;
	}
	this.toilet=toilet;
}
void setPrice(int price) {
	if (price<0) {
		return;
	}
	this.price=price/1000000*1000000;
}
void set(int size, int room, int toilet, boolean balcony, int price) {
	this.setSize(size);
	this.setRoom(room);
	this.setToilet(toilet);
	this.setBalcony(balcony);
	this.setPrice(price);
}
int getSize() {
	return this.size;
}
int getRoom() {
	return this.room;
}
int getToilet() {
	return this.toilet;
}
boolean getBalcony() {
	return this.balcony;
}
int getPrice() {
	return this.price;
}
void print() {
	System.out.println("평형: "+this.getSize());
	System.out.println("방 개수: "+this.getRoom());
	System.out.println("화장실 개수: "+this.getToilet());
	if (balcony) {
		System.out.println("베란다 여부: 있음");
	} else {
		System.out.println("베란다 여부: 없음");
	}
//	System.out.println("베란다 여부: "+this.getBalcony());
	System.out.println("가격: "+this.getPrice()+"원");
	System.out.println();
}
}
