package kh;

import java.util.List;
import java.util.Scanner;

public class Test03 {
public static void main(String[] args) throws Exception {
//	사용자에게 검색어를 입력받아 화면에 해당하는 검색어를 포함하는 이름을 가진 데이터 출력
//	- 메소드 이름 : search
	Scanner sc = new Scanner(System.in);
	System.out.println("검색어를 입력하세요");
	String keyword = sc.next();
	sc.close();
	KHMemberDao dao = new KHMemberDao();
	List<KHMemberDto> search = dao.search(keyword);
	

	for(KHMemberDto dto : search) {
		System.out.println(dto.getNo());
		System.out.println(dto.getName());
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getPoint());
		System.out.println(dto.getJoindate());
		System.out.println();		
	} 
	}
}

