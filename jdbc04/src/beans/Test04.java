package beans;

public class Test04 {
	public static void main(String[] args) throws Exception {
//		snackdto에 데이터를 넣은 상태로 insert를 수행
		SnackDto dto = new SnackDto();
		dto.setName("c");
		dto.setPrice(1000);
		dto.setStock(500);
		
		SnackDao dao = new SnackDao();
		dao.insert(dto);
		
		System.out.println("등록완료");
	}
}
