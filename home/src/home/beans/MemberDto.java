package home.beans;

public class MemberDto {
	private int point;
	private String id, pw, name, joindate, grade, post, basic_addr, extra_addr, phone, last_login;
	@Override
	public String toString() {
		return "MemberDto [point=" + point + ", id=" + id + ", pw=" + pw + ", name=" + name + ", joindate=" + joindate
				+ ", grade=" + grade + ", post=" + post + ", basic_addr=" + basic_addr + ", extra_addr=" + extra_addr
				+ ", phone=" + phone + ", last_login=" + last_login + "]";
	}
	
	public MemberDto() {
		super();
	}

	public MemberDto(int point, String id, String pw, String name, String joindate, String grade, String post,
			String basic_addr, String extra_addr, String phone, String last_login) {
		super();
		this.point = point;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.joindate = joindate;
		this.grade = grade;
		this.post = post;
		this.basic_addr = basic_addr;
		this.extra_addr = extra_addr;
		this.phone = phone;
		this.last_login = last_login;
	}

	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBasic_addr() {
		return basic_addr;
	}
	public void setBasic_addr(String basic_addr) {
		this.basic_addr = basic_addr;
	}
	public String getExtra_addr() {
		return extra_addr;
	}
	public void setExtra_addr(String extra_addr) {
		this.extra_addr = extra_addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

}
