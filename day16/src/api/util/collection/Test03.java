package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test03 {
	public static void main(String[] args) {
//		List 명령 다루기
		List<String> list = new ArrayList<>();

//		추가
		list.add("차은우"); // 0
		list.add("공유"); // 1-->2
		list.add(1, "정우성"); // 1번에 정우성 추가
		list.add("강동원"); // 3

//		수정
		list.set(1, "원빈");

//		확인
		list.get(1);
//		삭제
		list.remove("공유");

//		데이터 개수 확인
		System.out.println(list.size());
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); //일부분 가능
			
//		for (String str: list) {
//			System.out.println(str);
//		} //무조건 전체반복
		}
	}
}