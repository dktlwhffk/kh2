package api.util.collection;

import java.util.*;


public class Test04 {


	public static void main(String[] args) {
//		로또 번호 6개를 추첨하여 중복없이 List에 저장
//		중복 여부 검사 명령을 찾아야 함
		Random r = new Random();
		List<Integer> list = new ArrayList<>();

//		for(int i=0; i<6; i++) {
//			int lotto = r.nextInt(45)+1;
//			if(list.contains(lotto)) {
//				i--;
//			}
//			else {
//				list.add(lotto);				
//			}
//		}	
//		for (Integer str: list) {
//			System.out.println(str);			
//		}
		
		while(list.size()<6){				//개수가 6개 미만이면 계속 실행
			int n = r.nextInt(45)+1;		//번호를 뽑는다
			if(!list.contains(null)) {		//없으면
				list.add(n);				//추가해라
			}
		}
		System.out.println(list);
	}
}
