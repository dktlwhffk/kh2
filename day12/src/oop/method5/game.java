package oop.method5;

public class game {
	String name;
	int coin;
	int income;
	int playcount;
	
	void set(String name, int coin) {
		this.name=name;
		this.coin=coin;
	}
	
//	void play() {
//		this.income+=this.coin;
//	}
	
	void play(int usercount) {
		for(int i=0; i<usercount; i++) {
//			this.play();
			playcount++;
		}
		this.income=playcount*this.coin;
	}
	
	void print() {
		System.out.println("게임 이름: "+this.name);
		System.out.println("가격: "+this.coin);
		System.out.println("플레이 횟수: "+playcount);
		System.out.println("누적 수입: "+this.income+"원");
		System.out.println();
	}
	//method overloading 
//	-같은 이름의 메소드를 여러개 만드는 것
//	-이 기능을 호출(이용)하는 대상이 편하도록 다양한 경우를 고려
//	-아무때나 되는 것은 아니고 특정 조건을 만족해야함
//	()내부의 형태가 구분이 가능해야한다
//	void play(){
//	void play(int count){
}
