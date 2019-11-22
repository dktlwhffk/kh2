package beans;

public class KHMemberDto {
	private int no, point;
	private String name, id, pw, joindate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public KHMemberDto(int no, int point, String name, String id, String pw, String joindate) {
		super();
		this.no = no;
		this.point = point;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.joindate = joindate;
	}
	public KHMemberDto() {
		super();
	}
}