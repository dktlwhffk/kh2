package oop.test2;

public class Test01 {
	public static void main(String[] asrg) {
//	다음 정보를 클래스와 객체를 이용하여 프로그래밍 데이터화 시키고 출력
//	역대 동계올림픽 선수 메달 현황
//	이름: 김연아, 종목: 피겨스케이팅 	금메달:3개 은메달:2개 동메달:2개
//	이름: 이상화, 종목: 스피드스케이팅	금메달:4개 은메달:2개 동메달:3개
//	이름: 김동성, 종목: 쇼트트랙 		금메달:2개 은메달:5개 동메달:1개

		player a = new player();
		player b = new player();
		player c = new player();

		a.name = "김연아";
		a.type = "피겨스케이팅";
		a.gmedal = 3;
		a.smedal = 2;
		a.bmedal = 2;
		b.name = "이상화";
		b.type = "스피드스케이팅";
		b.gmedal = 4;
		b.smedal = 2;
		b.bmedal = 3;
		c.name = "김동성";
		c.type = "쇼트트랙";
		c.gmedal = 2;
		c.smedal = 5;
		c.bmedal = 1;
		System.out.println("이름: " + a.name);
		System.out.println("종목: " + a.type);
		System.out.println("금: " + a.gmedal);
		System.out.println("은: " + a.smedal);
		System.out.println("동: " + a.bmedal);
		System.out.println();
		System.out.println(b.name);
		System.out.println(b.type);
		System.out.println(b.gmedal);
		System.out.println(b.smedal);
		System.out.println(b.bmedal);
		System.out.println();
		System.out.println(c.name);
		System.out.println(c.type);
		System.out.println(c.gmedal);
		System.out.println(c.smedal);
		System.out.println(c.bmedal);
	}
}
