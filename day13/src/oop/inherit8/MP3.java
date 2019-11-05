package oop.inherit8;

public class MP3 extends format{
//	변수
	protected int duration;
//	생성자
	public MP3(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.duration=duration;
		// TODO Auto-generated constructor stub
	}
//	메소드
	public void forward() {
		System.out.println("음악을 빨리감기 합니다.");
	}
	public void rewind() {
		System.out.println("음악을 되감기 합니다.");
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("음악 재생을 시작합니다. 재생시간: "+this.duration);
	}
}