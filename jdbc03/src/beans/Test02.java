package beans;

public class Test02 {
	public static void main(String[] args) throws Exception {
		Dao dao = new Dao();
		dao.insertAdmin("서국d", "tjrnrghks23", "tjrnrghks", 3000);
		System.out.println("등록완료!");
		
	}
}
