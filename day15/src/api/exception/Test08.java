package api.exception;

public class Test08 {
	public static void main(String[] args) {
		try {
			int a = 0;
			int b = 0;
			int c;
			c = Calculator.kieun(a, b);
			System.out.println(c);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류 발생!");
		}
	}
}
