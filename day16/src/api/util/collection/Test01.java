package api.util.collection;

import java.util.*;

public class Test01 {
	public static void main(String[] args) {
//		List 방식 / Stack 방식 / Set 방식
//		-List 특징: 데이터 저장 순서를 보존
		
		ArrayList a = new ArrayList();
		
//		for(int i=0; i<10; i++) {
//			a.add(i, i);
//		}
			a.add("차은우");
			a.add("공유");
			a.add("정우성");
			a.add("강동원");
			a.add("원빈");
			
		System.out.println(a);
		
//		Set 특징: 데이터 저장 순서를 무시(지정된 방법으로 저장)
		TreeSet b = new TreeSet();
		
		b.add("차은우");
		b.add("공유");
		b.add("정우성");
		b.add("강동원");
		b.add("원빈");
		
		System.out.println(b);
		
//		Stack 특징: 최신 데이터 순서로 저장
		Stack c = new Stack();
		
		c.add("차은우");
		c.add("공유");
		c.add("정우성");
		c.add("강동원");
		c.add("원빈");
		
		System.out.println(c.search("원빈"));
	}
}
