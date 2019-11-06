package api.lang.string;

public class Test01 {
	public static void main(String[] args) {
//		String class 객체 생성
		String a = "hello";
		String b=new String("hello");
		
		String c = "hello";
		String d = new String("hello");
		
//		비교
		System.out.println(a==c);
		System.out.println(b==d);
		System.out.println(a==b);
		
//		글자가 같은지 비교(객체 비교)
		System.out.println(b.equals(d));
	}
}
