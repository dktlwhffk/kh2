package oop.inherit8;

public class AVI extends format{
	int speed=1;
	public AVI(String filename,long filesize) {
		super(filename, filesize);
		// TODO Auto-generated constructor stub
	}

	
	public void forward() {
		System.out.println("영상을 빨리감기 합니다.");
	}
	public void rewind() {
		System.out.println("영상을 되감기 합니다.");
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("영상 재생을 "+speed+"배속으로 시작합니다.");
	}

}
