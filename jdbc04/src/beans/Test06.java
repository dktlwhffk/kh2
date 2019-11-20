package beans;

import java.util.List;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) throws Exception {
//		사용자에게 이름 검색어를 입력받아 해당하는 이름을 포함하는 목록을 구하여 출력
		
//		클래스: SnackDao
//		메소드: search
		SnackDto dto1 = new SnackDto();
		
		
		Scanner sc = new Scanner(System.in);
		String keyword = sc.next();
		
		
		SnackDao dao=new SnackDao();
		List<SnackDto> search1=dao.search(keyword);
		sc.close();
		
//		System.out.println(search.size());
//		System.out.println(dto1.getKeyword());
		
		for(SnackDto dto: search1) {
			System.out.println(dto.getName());
			System.out.println(dto.getPrice());
		}
		
		
		
	}
}
