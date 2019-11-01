package oop.method4;

public class Test01 {
	public static void main(String[] asrg) {
//		저금통 생성
		bank b=new bank();
		
//		500원 저금
		b.save(500);
		
//		출력
		b.print();
		
//		500원 저금
		b.save(500);
		
//		출력
		b.print();
	}
}
