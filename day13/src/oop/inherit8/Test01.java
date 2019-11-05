package oop.inherit8;

public class Test01 {
	public static void main(String[] args) {
		MP3 mp3=new MP3("노래 이름", 0, 150);
		AVI avi=new AVI("영화 이름",0);
		PPT ppt=new PPT("파일 이름",0);
		
		mp3.filename();
		mp3.filesize();
		
		mp3.forward();
		ppt.information();
		mp3.execute();
	}
}