package oop.multi1;

public class Test01 {
public static void main(String[] args) {
//	teacher의 인스턴스 생성
//	Teacher t = new Teacher();
	
//	person의 인스턴스 생성
	Person p = new Person();
	p.teach();
	p.speak();
	
//	Teacher t = p;
	Teacher t = new Person(); //업캐스팅
	t.teach();
	t.speak();
}
}
