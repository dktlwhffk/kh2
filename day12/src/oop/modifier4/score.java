package oop.modifier4;

public class score {
private String name;
private int korean, english, math;

void setName(String name) {
	this.name=name;
}
void setKorean(int korean) {
	if(korean>=0&&korean<=100) {
		this.korean=korean;		
	}
}
void setEnglish(int english) {
	if(english>=0&&english<=100) {
		this.english=english;		
	}
}
void setMath(int math) {
	if(math>=0&&math<=100) {
		this.math=math;		
	}
}
void set(String name, int korean, int english, int math) {
	this.setName(name);
	this.setKorean(korean);
	this.setEnglish(english);
	this.setMath(math);
}
String getName() {
	return this.name;
}
int getKorean() {
	return this.korean;
}
int getEnglish() {
	return this.english;
}
int getMath() {
	return this.math;
}
void print() {
	int total=this.korean+this.english+this.math;
	int average=total/3;
	System.out.println("이름: "+this.getName());
	System.out.println("국어점수: "+this.getKorean());
	System.out.println("영어점수: "+this.getEnglish());
	System.out.println("수학점수: "+this.getMath());
	System.out.println("총점: "+total);
	System.out.println("평균: "+average);
	if(average>=60) {
		System.out.println("합격!");
	}else {
		System.out.println("불합격!");
	}
	System.out.println();
}
}
