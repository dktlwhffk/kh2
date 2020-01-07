package home.beans;

public class FilesDto {
	private int no;
	private int origin;
	private String uploadname;
	private String savename;
	private String filetype;
	private long filesize;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public String getUploadname() {
		return uploadname;
	}
	public void setUploadname(String uploadname) {
		this.uploadname = uploadname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public FilesDto(int no, int origin, String uploadname, String savename, String filetype, long filesize) {
		super();
		this.no = no;
		this.origin = origin;
		this.uploadname = uploadname;
		this.savename = savename;
		this.filetype = filetype;
		this.filesize = filesize;
	}
	public FilesDto() {
		super();
	}
	
	
}
