package home.beans;

public class ReplyDto {
	private int no;
	private int rno;
	private String rwriter;
	private String rcontent;
	private String rdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public ReplyDto(int no, int rno, String rwriter, String rcontent, String rdate) {
		super();
		this.no = no;
		this.rno = rno;
		this.rwriter = rwriter;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}
	public ReplyDto() {
		super();
	}
	
	
	
}
