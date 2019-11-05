package api.lang.Integer;

public class Test06 {
	public static void main(String[] args) {
//		주의사항: 비교 방법이 다르다
//		-원시형은 데이터를 비교
//		-참조형은 자리(위치)를 비교
		int a = 10;
		int b = 10;
		System.out.println(a==b);
		
		Integer c=new Integer(10);
		Integer d=new Integer(10);
		
		System.out.println(c.equals(d)); //동등비교
		System.out.println(c==d); //동일비교
	}
}
