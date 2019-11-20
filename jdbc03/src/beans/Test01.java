package beans;

import java.sql.Connection;


public class Test01 {
	public static void main(String[] args) throws Exception{
//		자바 빈즈(java beans)의 활용
//		DB를 쉽게 사용할 수 있도록 도와주는 자바 객체
		
//		Dao의 인스턴스를 만들어서 연결을 대행해달라고 부탁
		Dao dao = new Dao();
		dao.oracle("황인빈", "황인빈", "황인빈");
		System.out.println("등록완료");
		
	}
}
