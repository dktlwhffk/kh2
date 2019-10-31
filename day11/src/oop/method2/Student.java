package oop.method2;

public class Student {
	
	String name;

	int score1, score2, score3;
	
	
	void print() {
		int total = this.score1 + this.score2 + this.score3;
		double average = total / 3.0;
		System.out.println(this.name);
		System.out.println("국어= "+this.score1);
		System.out.println("영어= "+this.score2);
		System.out.println("수학= "+this.score3);
		System.out.println("총점= "+total);
		System.out.println("평균= "+average);
	}
	void set(String name,int score1, int score2, int score3) 
	{
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}
}
