package beans;

import java.util.List;

public class Test05 {
	public static void main(String[] args) throws Exception {
//		snack테이블의 모든 데이터를 snackdao를 이용해서 구해와 출력
		
		SnackDao dao = new SnackDao();
		
		List<SnackDto> list = dao.getList();
		
		System.out.println(list.size());
		System.out.println(list);
		for(SnackDto dto: list) {
			System.out.println(dto.getName());
		}
	}
}
