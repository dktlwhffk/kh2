package api.util.collection;

import java.util.Stack;

public class Test09 {
	public static void main(String[] args) {
//		Stack 후입선출(LIFO) 저장소
		
		Stack<String> a = new Stack<>();
		
		a.push("차은우");
		a.push("공유");
		a.push("정우성");
		a.push("강동원");
		a.push("원빈");
		
		String n = a.pop();
		
		System.out.println(a.peek());
		
		System.out.println(a);
	}
}
