package kh;

import java.util.List;

public class Test02 {
public static void main(String[] args) throws Exception {
//	화면에 kh_member 테이블의 데이터 개수와 목록을 출력
//	메소드 이름: getlist
	
	
	
	KHMemberDao dao = new KHMemberDao();
	List<KHMemberDto> list = dao.getlist();
	
	System.out.println("데이터 개수: "+list.size());
	
	for(KHMemberDto dto: list) {
		System.out.println("No: "+dto.getNo());
		System.out.println(dto.getName());
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println(dto.getPoint());
		System.out.println(dto.getJoindate());
		System.out.println();
	}
}
}
