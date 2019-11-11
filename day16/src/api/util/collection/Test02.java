package api.util.collection;

import java.util.*;

public class Test02 {
	public static void main(String[] args) {
//		List - ArrayList, LinkedList
		
//		ArrayList a = new ArrayList();//비추천
//		ArrayList<Object> a = new ArrayList<>();//자료형 상관없이 아무거나 들어간다!
		ArrayList<?> a = new ArrayList<>();//위와 동일
		
		ArrayList<String> b = new ArrayList<String>(); //권장방법
		ArrayList<String> c = new ArrayList<>();//우측은 생략 가능
		ArrayList<Integer>d = new ArrayList<>();//int는 원시형이라 불가능
		
		LinkedList<String> e = new LinkedList<>();
		
//		최종형태
		List<String> f = new ArrayList<>();
		List<String> g = new LinkedList<>();
	}
}
