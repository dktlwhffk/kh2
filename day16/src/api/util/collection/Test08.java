package api.util.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Test08 {
	public static void main(String[] args) {
//		Queue 선입선출(FIFO) 구조의 저장소
		
//		생성
		Queue<String> q = new LinkedList<>();
		
		q.add("차은우");
		q.add("공유");
		q.add("정우성");
		q.add("강동원");
		q.add("원빈");
		
//		추출
		q.poll();
		q.poll();
		q.poll();
//		q.poll();
		
		System.out.println(q.peek());
		
		System.out.println(q);
		System.out.println(q.size());
	}
}
