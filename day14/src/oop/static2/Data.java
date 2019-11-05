package oop.static2;

public class Data {
//	변수 하나만 독자적으로 이용 가능
	static int number;
//	static 초기화 전용구문
	static {
		for(int i=1; i<=100; i++) {
			number+=i;
		}
	}
}
