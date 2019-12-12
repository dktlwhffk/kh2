package beans;

//DTO(Data Transfer Object): 포장상자
//-Table의 1줄을 저장하기 위한 클래스
public class SnackDto {
	private int no;
	private String name;
	private int price;
	private int stock;
	private String keyword;
	
//	생성자+setter/getter
	public SnackDto() {
		super();
	}
	
	public SnackDto(int no, String name, int price, int stock) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
//	public void setKeyword(String keyword) {
//		this.keyword=keyword;
//	}
//	public String getKeyword() {
//		return keyword;
//	}
}
