package oop.inherit8;

public class PPT extends format{
	int size=1;
	public PPT(String filename,long filesize) {
		super(filename,filesize);
		// TODO Auto-generated constructor stub
	}
	

	public void information() {
		System.out.println("파일 정보 확인: "+filename+" "+filesize+" "+size);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("파워포인트 애니메이션을 재생합니다.");
	}

}
