package output;

import java.lang.*;

public class Test02 {
	public static void main (String [] asrg) {
//		주의사항: 화면에 표시되지 않는 글자가 존재
//		-\ 와 조합하여 각종 명령을 수행할 수 있다.
//		-\t (tab), \n (new line)
		
		System.out.println("\t");
		System.out.println("\n");
		
		System.out.println("원빈		남자");
		System.out.println("이나영	여자");
		
		System.out.println("\n\n\n");
		
		System.out.println("원빈\t\t남자");
		System.out.println("이나영\t여자");
		
	}
}
