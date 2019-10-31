package oop.method1;
//카카오톡 메세지 클래스
// = 이름(String) + 내용(String) + 시간(String) + 숫자(int)
public class message {
	String name;
	String content;
	String time;
	int remain;
	
//	void print(준비물) {
//		
//	}
	void print() {
		System.out.println(this.name);
		System.out.println(this.content);
		System.out.println(this.time);
		System.out.println(this.remain);
	}
	void set(String name, String content, String time, int remain)//매개변수
	{
		this.name = name;
		this.content = content;
		this.time = time;
		this.remain = remain;
	}
}
