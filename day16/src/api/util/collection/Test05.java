package api.util.collection;

import java.util.Set;
import java.util.TreeSet;

public class Test05 {
	public static void main(String[] args) {
//		Set: 순서가 보장되지 않는 저장소. 중복 불가
//		TreeSet: 오름차순으로 정렬
		
		Set<String> set = new TreeSet<>();
		
//		추가
		set.add("차은우");
		set.add("공유");
		set.add("정우성");
		set.add("강동원");
		boolean a = set.add("원빈");
		boolean b = set.add("원빈");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		
//		수정 불가(위치 없음)
//		개수 확인
		System.out.println(set.size());
		
//		확인 불가(위치 없음)
//		검색
		System.out.println(set.contains("공유"));
//		삭제
		System.out.println(set.remove("공유"));
		System.out.println(set.remove("한가인"));
		
		
		System.out.println(set);
		
//		전체 추출이 되는가?
		for(String name : set) {
			System.out.println(name);
		}//확장 반복문
	}
}
