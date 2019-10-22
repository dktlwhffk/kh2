package input;
import java.io.IOException;
import java.lang.*;
public class Test01 {
	public static void main(String [] args) throws IOException {
		//입력: System.in 통로를 이용
		
		System.out.println("뭐라도 입력해봐");
		
		int v = System.in.read();
		
		System.out.println(v);
		System.out.println((char)v);
		
		v=System.in.read();
		System.out.println(v);
		v=System.in.read();
		System.out.println(v);
		v=System.in.read();
		System.out.println(v);
		
	}
}
