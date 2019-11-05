package oop.inherit8;

public abstract class format {
	protected String filename;
	protected long filesize;
	
	
	public format(String filename, long filesize) {
		this.filename=filename;
		this.setFilesize(filesize);
	}
	public void setFilesize(long filesize) {
		if(filesize>=0) {
			this.filesize=filesize;
		}
	}
	public void filename() {
		System.out.println(filename);
	}
	public void filesize() {
		System.out.println(filesize);
	}

	public abstract void execute();
}
