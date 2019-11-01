package oop.constructor;

public class Student {
	private String name;
	private int score;
	
	
//	student 생성자
//	만들기 위해서는 이름 / 점수를 가져와라
	Student(String name) {
//		this.name=name;
//		this.score=0;
		this(name, 0);
	}
	Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	
	void print() {
		System.out.println(this.name);
		System.out.println(this.score);
	}
}
