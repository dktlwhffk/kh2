package oop.method2;

public class Student {
	
	String name;

	int score1, score2, score3;
	int total = score1+score2+score3;
	int avg = total/3;
	
	void print() {
		System.out.println(this.name);
		System.out.println("국어= "+this.score1);
		System.out.println("영어= "+this.score2);
		System.out.println("수학= "+this.score3);
		System.out.println("총점= "+(this.total));
		System.out.println("평균= "+(this.avg));
	}
	void set(String name,int score1, int score2, int score3) 
	{
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		int total = score1+score2+score3;
		int avg = total/3;
	}
}
