package api.lang.Integer;

public class Test01 {
	public static void main(String[] args) {
//		Integer n= new Integer("v");
		
		Integer a= new Integer(10000);
		Integer b= new Integer("10000");
		
		System.out.println(b);
		System.out.println(b.intValue());
		
		System.out.println(a.byteValue());
	}
}
